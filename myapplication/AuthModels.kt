package com.example.myapplication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val username: String,
    val email: String? = null
)

@Serializable
data class RegisterResponse(
    val success: Boolean,
    val message: String
)

@Serializable
data class CheckUsernameResponse(
    @SerialName("is_taken") val isTaken: Boolean
)
