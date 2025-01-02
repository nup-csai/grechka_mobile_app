package org.grechka.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.grechka.project.AuthApi
import androidx.compose.runtime.*

val dapi = DictionaryApi()
val sapi = SearchApi()
val aapi = AuthApi()
val audioPlayer = provideAudioPlayer()
class HomeScreen()
: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current ?: return
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val loginUrl = "https://stage.grechka.space/login"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(loginUrl))
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFBB86FC),
                    contentColor = Color.Black
                )
            ) {
                Text("Авторизация")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navigator.push(Trainings()) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF03DAC5),
                    contentColor = Color.Black
                )
            ) {
                Text("Тренировки")
        }
        Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navigator.push(DictionaryScreen(api = dapi, audioPlayer = audioPlayer)) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFBB86FC),
                    contentColor = Color.Black
                )
            ) {
                Text("Словарь")
            }

            Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navigator.push(SearchScreen(api = sapi, audioPlayer = audioPlayer)) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF03DAC5),
                contentColor = Color.Black
            )
        ) {
            Text("Поиск слова")
        }
        }
    }
}
