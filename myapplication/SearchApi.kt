package com.example.myapplication

import io.ktor.client.HttpClient
import io.ktor.client.call.body


import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class SearchResponse(
    val word: SWord,
    val query: String,
)

@Serializable
data class SWord(
    val audio: String? = null,
    val word: String,
    val ru: String? = null,
    val gender: String? = null,
    val number: String? = null,
    val case: String? = null,
    val conjugation: String? = null,
    val inclination: String? = null,
    val tense: String? = null,
    val voice: String? = null,
    val person: String? = null,
    val regularity: String? = null)
{
    val tags: List<String>
        get() = listOfNotNull(gender, number, case, number, conjugation, tense)
}

class SearchApi {
    private val client = HttpClient(CIO) {

        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(Logging) {
            level = LogLevel.BODY
        }
    }
    suspend fun search(query: String): SearchResponse {
        val url = "http://stage.grechka.space/search"

        val response = client.post(url) {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
                append(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded.toString())
            }
            setBody(FormDataContent(Parameters.build {
                append("query", query)
            }))
        }

        return response.body()
    }
}
