package org.grechka.project

import android.media.MediaPlayer
import android.util.Log
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.jvm.javaio.*
import kotlinx.coroutines.*
import java.io.File
import io.ktor.utils.io.*


actual fun provideAudioPlayer(): AudioPlayer = AndroidAudioPlayer()

class AndroidAudioPlayer : AudioPlayer {
    override suspend fun playAudio(dictionaryApi: DictionaryApi, audioFileName: String?) {
        val mediaPlayer = MediaPlayer()
        try {
            val audioUrl = if (audioFileName.isNullOrEmpty()) {
                val generatedAudio = dictionaryApi.createAudio("word")
                "http://stage.grechka.space$generatedAudio"
            } else if (audioFileName.startsWith("http")) {
                audioFileName
            } else {
                transformAudioPath(audioFileName)
            }
            val destinationFile = File("/data/data/org.grechka.project/cache/audio.mp3") // Adjust path as needed
            downloadAudioFile(audioUrl, destinationFile)

            Log.d("AudioDebug", "Trying to play: ${destinationFile.absolutePath}")
            mediaPlayer.setDataSource(destinationFile.absolutePath)
            mediaPlayer.setOnPreparedListener { it.start() }
            mediaPlayer.setOnCompletionListener { it.release() }
            mediaPlayer.setOnErrorListener { _, what, extra ->
                Log.e("MediaPlayerError", "Error playing audio: what=$what, extra=$extra")
                mediaPlayer.release()
                true
            }
            mediaPlayer.prepareAsync()
        } catch (e: Exception) {
            Log.e("AudioError", "Exception occurred: ${e.message}")
        }
    }
}

val client = HttpClient()

suspend fun downloadAudioFile(url: String, destination: File) {
    try {
        val response: HttpResponse = client.get(url)
        destination.outputStream().use { outputStream ->
            response.bodyAsChannel().copyTo(outputStream) // No need for toByteWriteChannel
        }
        Log.d("AudioDebug", "Audio file downloaded successfully to ${destination.absolutePath}")
    } catch (e: Exception) {
        Log.e("AudioDebug", "Failed to download audio file: ${e.message}")
        throw e
    }
}
