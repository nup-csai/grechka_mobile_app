package com.example.myapplication
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
                expectSuccess = false // Prevent exceptions for non-2xx responses
            }

            println("Response Status: ${response.status}")
            println("Response Headers: ${response.headers.entries()}")
            println("Response Body: ${response.bodyAsText()}")

            return if (response.status.value == 302) {
                // Extract Location header
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

//    private suspend fun handleLoginCallback(callbackUrl: String): String {
//        return try {
//            // Step 3: Call the callback endpoint
//            val response = client.get(callbackUrl) {
//                header("Accept", "application/json")
//            }
//
//            when {
//                response.status.value == 302 -> {
//                    // Handle redirection after callback
//                    val nextUrl = response.headers["Location"]
//                        ?: throw Exception("Redirect URL not found during callback")
//                    println("Redirected to: $nextUrl")
//                    nextUrl
//                }
//
//                response.status.isSuccess() -> {
//                    // Process callback response
//                    val responseBody = response.bodyAsText()
//                    println("Callback response: $responseBody")
//                    responseBody
//                }
//
//                else -> throw Exception("Unexpected response status: ${response.status.value}")
//            }
//        } catch (e: Exception) {
//            throw Exception("Error handling callback: ${e.message}")
//        }
//    }
//
//
//    suspend fun register(username: String, email: String? = null): RegisterResponse? {
//        val url = "https://stage.grechka.space/register"
//
//        return try {
//            val response = if (email != null) {
//                // GET request with email as a query parameter
//                client.get(url) {
//                    url { parameters.append("email", email) }
//                }
//            } else {
//                // POST request with username in the body
//                client.post(url) {
//                    contentType(ContentType.Application.Json)
//                    setBody(RegisterRequest(username = username))
//                }
//            }
//
//            if (response.status.value == 200) {
//                response.body()
//            } else {
//                println("Unexpected status code: ${response.status.value}")
//                null
//            }
//        } catch (e: Exception) {
//            println("Error during request: ${e.message}")
//            null
//        }
//    }
//
//
//    suspend fun checkUsername(username: String): Boolean {
//        return try {
//            val url = "https://stage.grechka.space/check_username"
//
//            // Get the JSON response
//            val rawResponse = client.get(url) {
//                url {
//                    parameters.append("username", username)
//                }
//            }.bodyAsText()
//            println("Raw Response: $rawResponse") // Log the raw JSON response
//
//            // Deserialize the response
//            val response: CheckUsernameResponse = Json.decodeFromString(rawResponse)
//            !response.isTaken // Username is available if isTaken is false
//        } catch (e: Exception) {
//            println("Error checking username: ${e.message}")
//            false // Default to unavailable in case of an error
//        }
//    }
////    suspend fun handleLoginCallback(authCode: String): String {
////        val url = "https://stage.grechka.space/login/callback"
////
////        return try {
////            val response = client.get(url) {
////                url {
////                    parameters.append("code", authCode) // Append the auth code as a query parameter
////                }
////            }
////
////            if (response.status.value == 302) {
////                // Log the redirection
////                val redirectUrl = response.headers["Location"]
////                if (redirectUrl != null) {
////                    println("Redirecting to: $redirectUrl")
////                    redirectUrl // Return the redirect URL
////                } else {
////                    throw Exception("Redirect URL not found")
////                }
////            } else {
////                throw Exception("Unexpected response status: ${response.status.value}")
////            }
////        } catch (e: Exception) {
////            throw Exception("Error handling login callback: ${e.message}")
////        }
////    }
//
//
//
//
//    // Close the client to avoid resource leaks
//    fun close() {
//        client.close()
//    }

