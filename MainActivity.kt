package com.example.myapplication.android

import com.example.myapplication.Greeting
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    // Firebase Authentication instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Yellow
                ) {
                    // Sign-in and Sign-up UI with Firebase Authentication
                    AuthScreen(auth)
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun AuthScreen(auth: FirebaseAuth) {
    // State variables to hold email, password input, and feedback message
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var authMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                signInWithEmail(auth, email, password) { message ->
                    authMessage = message
                }
            }) {
                Text("Sign In")
            }

            Button(onClick = {
                signUpWithEmail(auth, email, password) { message ->
                    authMessage = message
                }
            }) {
                Text("Sign Up")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = authMessage, color = Color.Black)
    }
}

// Function to sign in with email and password
fun signInWithEmail(auth: FirebaseAuth, email: String, password: String, onResult: (String) -> Unit) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                onResult("Sign-in successful. Welcome ${user?.email}")
            } else {
                onResult("Sign-in failed: ${task.exception?.message}")
            }
        }
}

// Function to sign up with email and password
fun signUpWithEmail(auth: FirebaseAuth, email: String, password: String, onResult: (String) -> Unit) {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                onResult("Sign-up successful. Welcome ${user?.email}")
            } else {
                onResult("Sign-up failed: ${task.exception?.message}")
            }
        }
}

@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography(),
        content = content
    )
}

@Composable
fun GreetingView(text: String) {
    Text(text = text, color = Color.Black)
}
