package org.grechka.project

import platform.AVFoundation.*
import platform.Foundation.*


actual fun provideAudioPlayer(): AudioPlayer = IosAudioPlayer()

class IosAudioPlayer : AudioPlayer {
    private var player: AVPlayer? = null

    override suspend fun playAudio(dictionaryApi: DictionaryApi, audioFileName: String?) {
        try {
            val audioUrl = if (audioFileName.isNullOrEmpty()) {
                val generatedAudio = dictionaryApi.createAudio("word")
                "http://stage.grechka.space$generatedAudio"
            } else if (audioFileName.startsWith("http")) {
                audioFileName
            } else {
                transformAudioPath(audioFileName)
            }

            val localPath = downloadAudioFile(audioUrl, destination = "audio.mp3")
            if (localPath == null) {
                println("AudioError: Failed to download audio file.")
                return
            }

            val localUrl = NSURL.fileURLWithPath(localPath)

            val playerItem = AVPlayerItem.playerItemWithURL(localUrl)
            player = AVPlayer(playerItem = playerItem)

            player?.play()
            println("Playing audio from local file: $localPath")
        } catch (e: Exception) {
            println("AudioError: Exception occurred: ${e.message}")
        }
    }
}

suspend fun downloadAudioFile(url: String, destination: String): String? {
    return try {
        // Create NSURL from the URL string
        val nsUrl = NSURL.URLWithString(url) ?: throw IllegalArgumentException("Invalid URL")

        // Download the data from the URL
        val data = NSData.dataWithContentsOfURL(nsUrl) ?: throw IllegalStateException("Failed to fetch data from URL")

        // Save the file to a temporary directory
        val filePath = (NSTemporaryDirectory() as NSString).stringByAppendingPathComponent(destination)
        if (data.writeToFile(filePath, atomically = true)) {
            println("Audio file downloaded to: $filePath")
            filePath
        } else {
            throw IllegalStateException("Failed to write data to file: $filePath")
        }
    } catch (e: Exception) {
        println("AudioDownloadError: ${e.message}")
        null
    }
}
