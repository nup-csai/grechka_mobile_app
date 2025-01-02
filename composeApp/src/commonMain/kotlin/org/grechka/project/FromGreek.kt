package org.grechka.project

import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlin.random.Random

val word0 = "fruit"
val rword = "apple"
val words = listOf("sun", "rain", "apple")
val shuffledWords = words.shuffled(Random(System.currentTimeMillis()))

val word1 = shuffledWords[0]
val word2 = shuffledWords[1]
val word3 = shuffledWords[2]

class FromGreek : Screen {
    @Composable
    override fun Content() {
        var buttonColors = remember { mutableStateListOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val navigator = LocalNavigator.current ?: return

            Button(
                onClick = { navigator.push(Trainings()) },
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(16.dp)
            ) {
                Text("Назад")
            }

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedButton(
                onClick = {
                    buttonColors[0] = if (word0 == rword) Color.Green else Color.Red
                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color(0xFF8A2BE2)
                ),
                border = BorderStroke(2.dp, Color(0xFF8A2BE2))
            ) {
                Text(text = word0)
            }
            OutlinedButton(
                onClick = {
                    buttonColors[1] = if (word1 == rword) Color.Green else Color.Red
                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = buttonColors[1],
                    contentColor = Color(0xFF8A2BE2)
                ),
                border = BorderStroke(2.dp, Color(0xFF8A2BE2))
            ) {
                Text(text = word1)
            }

            OutlinedButton(
                onClick = {
                    buttonColors[2] = if (word2 == rword) Color.Green else Color.Red
                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = buttonColors[2],
                    contentColor = Color(0xFF8A2BE2)
                ),
                border = BorderStroke(2.dp, Color(0xFF8A2BE2))
            ) {
                Text(text = word2)
            }
            OutlinedButton(
                onClick = {
                    buttonColors[3] = if (word3 == rword) Color.Green else Color.Red
                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = buttonColors[3],
                    contentColor = Color(0xFF8A2BE2)
                ),
                border = BorderStroke(2.dp, Color(0xFF8A2BE2))
            ) {
                Text(text = word3)
            }
        }
    }
}
