package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.SearchApi
import com.example.myapplication.SWord
import kotlinx.coroutines.launch

fun SearchScreen(navController: NavController, api: SearchApi) {
    var query by remember { mutableStateOf("") }
    var searchResult by remember { mutableStateOf<List<SWord>?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope() // For launching coroutines in Composable

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = { navController.navigate("home") },
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

                    // Launch coroutine for API call
                    coroutineScope.launch {
                        try {
                            val response = api.search(query)
                            searchResult = listOf(response.word) // Adapted for single word result
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

        // Loading State
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }

        // Error Message
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
                    .weight(1f) // Allow LazyColumn to take up only available space
                    .fillMaxWidth()
            ) {
                items(words) { word ->
                    Card(word = word, searchApi = api)
                }
            }
        }
    }
}
@Composable
fun Card(word: SWord, searchApi: SearchApi) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Word
        Text(
            text = word.word,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Translation
        Text(
            text = word.ru ?: "-",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Tags
        Text(
            text = word.tags.joinToString(", "),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Divider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}