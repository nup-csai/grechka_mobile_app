package org.grechka.project


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.grechka.project.DictionaryApi
import org.grechka.project.Word
import kotlinx.coroutines.launch
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator

expect fun provideAudioPlayer(): AudioPlayer
interface AudioPlayer {
    suspend fun playAudio(dictionaryApi: DictionaryApi, audioFileName: String?)
}

class DictionaryScreen(
    private val api: DictionaryApi,
    private val audioPlayer: AudioPlayer
) : Screen {
    @Composable
    override fun Content() {
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
                } catch (e: Exception) {
                    errorMessage = "Failed to load dictionary: ${e.message}"
                }
            }
        }
        val navigator = LocalNavigator.current ?: return
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            ) {
            Button(
                onClick = { navigator.push(HomeScreen()) },
            ) {
                Text("Назад")
            }
            Button(
                onClick = {
                    scope.launch {
                        try {
                            val response = api.filter(listOf("Глагол"))
                            words = response.words
                        } catch (e: Exception) {
                            errorMessage = "Failed to filter words: ${e.message}"
                        }
                    }
                }
            ) {
                Text("Глагол")
            }
            Button(
                onClick = {
                    scope.launch {
                        try {
                            val response = api.filter(listOf("Существительное"))
                            words = response.words
                        } catch (e: Exception) {
                            errorMessage = "Failed to filter words: ${e.message}"
                        }
                    }
                }
            ) {
                Text("Существительное")
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
                    currentPage = currentPage.coerceIn(0, paginatedWords.lastIndex) // Ensure currentPage is in bounds

                    if (paginatedWords.isNotEmpty()) {
                        VocabularyTable(
                            words = paginatedWords[currentPage],
                            currentPage = currentPage,
                            totalPages = paginatedWords.size,
                            onPreviousPage = { currentPage = (currentPage - 1).coerceAtLeast(0) },
                            onNextPage = { currentPage = (currentPage + 1).coerceAtMost(paginatedWords.lastIndex) },
                            api = api,
                            audioPlayer = audioPlayer
                        )
                    } else {
                        Text("No words available for display.")
                    }
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
    api: DictionaryApi,
    audioPlayer: AudioPlayer
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(words) { word ->
                WordCard(word = word, dictionaryApi = api, audioPlayer = audioPlayer)
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
fun WordCard(word: Word, dictionaryApi: DictionaryApi, audioPlayer: AudioPlayer) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = { isChecked ->
                onWordSelected(word, isChecked)
            }
        )
    }
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
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        IconButton(
            onClick = {
                coroutineScope.launch {
                    audioPlayer.playAudio(dictionaryApi,word.audio)
                }
            },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play Audio"
            )
        }

        HorizontalDivider(
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