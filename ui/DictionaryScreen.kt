package ui

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.DictionaryApi
import com.example.myapplication.Word
import kotlinx.coroutines.launch

fun DictionaryScreen(api: DictionaryApi, navController: NavController) {
    var words by remember { mutableStateOf<List<Word>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var currentPage by remember { mutableStateOf(0) }
    val itemsPerPage = 10
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                val response = api.getDictionary()
                words = response.words
                Log.d("PaginationDebug", "Loaded words: ${words.size}")
            } catch (e: Exception) {
                errorMessage = "Failed to load dictionary: ${e.message}"
                Log.e("PaginationError", e.message ?: "Unknown error")
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Назад")
        }

        when {
            errorMessage != null -> {
                Text(
                    text = errorMessage ?: "Unknown error",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            words.isEmpty() -> {
                Text(
                    text = "Загрузка словаря...",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            else -> {
                val paginatedWords = paginateVocabulary(words, itemsPerPage)
                currentPage = currentPage.coerceIn(0, paginatedWords.lastIndex) // Ensure `currentPage` is in bounds

                if (paginatedWords.isNotEmpty()) {
                    VocabularyTable(
                        words = paginatedWords[currentPage],
                        currentPage = currentPage,
                        totalPages = paginatedWords.size,
                        onPreviousPage = { currentPage = (currentPage - 1).coerceAtLeast(0) },
                        onNextPage = { currentPage = (currentPage + 1).coerceAtMost(paginatedWords.lastIndex) },
                        api
                    )
                } else {
                    Text("No words available for display.")
                }
            }
        }
    }
}
@Composable
fun VocabularyTable(
    words: List<Word>,
    currentPage: Int,
    totalPages: Int,
    onPreviousPage: () -> Unit,
    onNextPage: () -> Unit,
    api: DictionaryApi
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(words) { word ->
                WordCard(word = word, dictionaryApi = api)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPreviousPage,
                enabled = currentPage > 0
            ) {
                Text("Назад")
            }

            Text(
                text = "Page ${currentPage + 1} of $totalPages",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Button(
                onClick = onNextPage,
                enabled = currentPage < totalPages - 1
            ) {
                Text("Далее")
            }
        }
    }
}

@Composable
fun WordCard(word: Word, dictionaryApi: DictionaryApi) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = word.word,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = word.ru ?: "-",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = word.tags.joinToString(", "),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        IconButton(
            onClick = {
                coroutineScope.launch {
                    playAudio(dictionaryApi, word.word, word.audio)
                }
            },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play Audio"
            )
        }

        Divider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}


fun paginateVocabulary(words: List<Word>, itemsPerPage: Int): List<List<Word>> {
    return words.chunked(itemsPerPage)
}

fun decodeUnicode(input: String): String {
    val regex = Regex("\\\\u([0-9a-fA-F]{4})")
    return regex.replace(input) { matchResult ->
        val hexCode = matchResult.groupValues[1]
        val charCode = hexCode.toInt(16)
        charCode.toChar().toString()
    }
}

fun encodeForUrl(input: String): String {
    return input.map { char ->
        when (char) {
            ' ' -> "%20"
            '.' -> "."
            else -> if (char.isLetterOrDigit()) char.toString() else "%${char.code.toString(16).uppercase()}"
        }
    }.joinToString("")
}

fun transformAudioPath(audioPath: String): String {
    val decodedPath = decodeUnicode(audioPath)
    val cleanedFileName = decodedPath.removePrefix("/data/audio/")
    val encodedFileName = encodeForUrl(cleanedFileName)
    val baseUrl = "http://stage.grechka.space/static/audio/"
    return "$baseUrl$encodedFileName"
}

suspend fun playAudio(dictionaryApi: DictionaryApi, word: String, audioFileName: String?) {
    val mediaPlayer = MediaPlayer()
    try {
        val audioUrl = if (audioFileName.isNullOrEmpty()) {
            val generatedAudio = dictionaryApi.createAudio(word)
            "http://stage.grechka.space$generatedAudio"
        } else if (audioFileName.startsWith("http")) {
            audioFileName
        } else {
            transformAudioPath(audioFileName)
        }

        Log.d("AudioDebug", "Trying to play: $audioUrl")
        mediaPlayer.setDataSource(audioUrl)
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