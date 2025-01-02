package org.grechka.project

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.grechka.project.SearchApi
import org.grechka.project.DictionaryApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

val dictionaryApi = DictionaryApi()
class SearchScreen(
    private val api: SearchApi,
    private val audioPlayer: AudioPlayer
) : Screen {
    @Composable
    override fun Content() {
        var query by remember { mutableStateOf("") }
        var searchResult by remember { mutableStateOf<List<SWord>?>(null) }
        var isLoading by remember { mutableStateOf(false) }
        var errorMessage by remember { mutableStateOf<String?>(null) }
        val coroutineScope = rememberCoroutineScope()
        val navigator = LocalNavigator.current ?: return
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Button(
                onClick = { navigator.push(HomeScreen()) },
                modifier = Modifier.align(Alignment.Start)
            ) {
                Text("Назад")
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Введите запрос") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (query.isNotBlank()) {
                        isLoading = true
                        errorMessage = null
                        searchResult = null

                        coroutineScope.launch {
                            try {
                                val response = api.search(query)
                                searchResult = listOf(response.word)
                            } catch (e: Exception) {
                                errorMessage = "Ошибка: ${e.message}"
                            } finally {
                                isLoading = false
                            }
                        }
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Поиск")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            errorMessage?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            searchResult?.let { words ->
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    items(words) { word ->
                        Card(word = word, searchApi = api)
                    }
                }
            }
        }
    }
}
@Composable
fun Card(word: SWord, searchApi: SearchApi) {
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