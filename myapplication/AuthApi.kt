package org.grechka.project
import io.ktor.client.*
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.expectSuccess
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.HttpHeaders
import io.ktor.http.isSuccess

class AuthApi {
    private val client = HttpClient {
        install(HttpRedirect)
    }

    suspend fun login(): String {
        try {
            val response = client.get("https://stage.grechka.space/login") {
                headers {
                    append(HttpHeaders.Accept, "application/json")
                }
                expectSuccess = false
            }

            println("Response Status: ${response.status}")
            println("Response Headers: ${response.headers.entries()}")
            println("Response Body: ${response.bodyAsText()}")

            return if (response.status.value == 302) {
                response.headers["Location"] ?: "No Location header found"
            } else {
                "Error: Unexpected response status ${response.status}"
            }
        } catch (e: Exception) {
            println("Error during login: ${e.message}")
            return "Error during login: ${e.message}"
        }
    }



    suspend fun handleLoginCallback(authCode: String): String {
        val callbackUrl = "https://stage.grechka.space/login/callback"

        try {
            val response = client.get(callbackUrl) {
                parameter("code", authCode)
            }

            if (response.status.isSuccess()) {
                return response.bodyAsText() // Process the callback response
            } else {
                throw Exception("Unexpected response: ${response.status}")
            }
        } catch (e: Exception) {
            println("Error during callback handling: ${e.message}")
            throw e
        }
    }
}

