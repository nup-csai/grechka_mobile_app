package org.grechka.project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.grechka.project.DictionaryApi

class Trainings(
)
    : Screen {
    @Composable
    override fun Content() {
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
            Spacer(modifier = Modifier.height(200.dp))
            Button(
                onClick = { navigator.push(AnimatedWord("run sun")) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF03DAC5),
                    contentColor = Color.Black
                )
            ) {
                Text("Words")
            }
            Button(
                onClick = { navigator.push(FromGreek()) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF03DAC5),
                    contentColor = Color.Black
                )
            ) {
                Text("greek")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
