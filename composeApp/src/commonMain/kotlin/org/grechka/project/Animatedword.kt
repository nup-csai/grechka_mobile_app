package org.grechka.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.grechka.project.HomeScreen
import org.grechka.project.Trainings

class AnimatedWord(private val string: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current ?: return

        val sanitizedString = string.replace(" ", "")
        val shuffledString = remember { sanitizedString.toList().shuffled() }
        var targetLetters by remember {
            mutableStateOf(string.map { if (it == ' ') it else null }.toTypedArray())
        }
        var visibleLetters by remember { mutableStateOf(shuffledString.toMutableList()) }
        var feedbackMessage by remember { mutableStateOf("") }
        var isCorrect by remember { mutableStateOf(false) }
        var showCorrectOrderGrid by remember { mutableStateOf(false) }

        fun checkAnswer() {
            val filteredTargetLetters = targetLetters.filterIndexed { index, _ -> string[index] != ' ' }
            val currentAnswer = filteredTargetLetters.joinToString("") { it?.toString() ?: "" }
            if (currentAnswer.length == sanitizedString.length) {
                isCorrect = currentAnswer == sanitizedString
                feedbackMessage = if (isCorrect) "Правильно!\n$string" else
                    "Неправильно!\nПравильный ответ: $string"
            } else {
                feedbackMessage = ""
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Back Button
            Button(
                onClick = { navigator.push(Trainings()) },
                modifier = Modifier.align(Alignment.Start)
            ) {
                Text("Назад")
            }

            Spacer(modifier = Modifier.height(30.dp))

            if (!showCorrectOrderGrid) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(6),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    itemsIndexed(targetLetters) { index, letter ->
                        if (string[index] == ' ') {
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(4.dp)
                                    .background(Color.White)
                            )
                        } else {
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(4.dp),
                                enabled = true,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = when {
                                        isCorrect && letter != null -> Color.Green
                                        !isCorrect && feedbackMessage.isNotEmpty() -> Color.Red
                                        else -> Color.LightGray
                                    },
                                    contentColor = Color.Black
                                )
                            ) {
                                Text(
                                    text = letter?.toString() ?: "",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(6),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                items(visibleLetters) { letter ->
                    OutlinedButton(
                        onClick = {
                            val targetIndex = targetLetters.indexOfFirst { it == null && string[targetLetters.indexOf(it)] != ' ' }
                            if (targetIndex != -1) {
                                targetLetters = targetLetters.copyOf().apply {
                                    this[targetIndex] = letter
                                }
                                visibleLetters = visibleLetters.toMutableList().apply {
                                    remove(letter)
                                }
                                checkAnswer()
                            }
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color(0xFF8A2BE2)
                        ),
                        border = BorderStroke(2.dp, Color(0xFF8A2BE2)),
                        modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                    ) {
                        Text(
                            text = letter.toString(),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Text(
                text = feedbackMessage,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        targetLetters = string.map { if (it == ' ') it else null }.toTypedArray()
                        visibleLetters = shuffledString.toMutableList()
                        feedbackMessage = ""
                        isCorrect = false
                        showCorrectOrderGrid = false
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Сбросить")
                }
            }

            Button(
                onClick = {
                    showCorrectOrderGrid = true
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "=>")
            }
        }
    }
}
