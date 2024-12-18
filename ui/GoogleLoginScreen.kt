package ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.AuthApi

fun GoogleLoginScreen(api: AuthApi) {
    val context = LocalContext.current
    var loading by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val loginUrl = "https://stage.grechka.space/login"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(loginUrl))
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF03DAC5),
                contentColor = Color.Black
            )
        ) {
            Text("Авторизация")
        }
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = Color.Black,
                strokeWidth = 2.dp
            )
        } else {
            Text("Авторизация")
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (message.isNotEmpty()) {
        Text(message, color = MaterialTheme.colorScheme.primary)
    }
}
