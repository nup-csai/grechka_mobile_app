package org.grechka.project
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class DictionaryResponse(
    val words: List<Word>
)

@Serializable
data class Word(
    val audio: String? = null,
    val word: String,
    val ru: String? = null,
    val part_of_speech: String? = null,
    val gender: String? = null,
    val number: String? = null,
    val case: String? = null,
    val conjugation: String? = null,
    val inclination: String? = null,
    val tense: String? = null,
    val voice: String? = null
){
    val tags: List<String>
        get() = listOfNotNull(part_of_speech, gender, number, case, number, inclination, conjugation, tense)
}



class DictionaryApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(Logging) {
            level = LogLevel.BODY
        }
    }

    suspend fun getDictionary(): DictionaryResponse {
        val url = "https://stage.grechka.space/dictionary"
        return client.get(url) {
            headers {
                accept(ContentType.Application.Json)
            }
        }.body()
    }
    suspend fun filter(targetTags: List<String>): DictionaryResponse {
        val dict = getDictionary() // Fetch the dictionary
        val filteredWords = dict.words.filter { entry ->
            entry.tags.any { it in targetTags } // Filter the words based on the target tags
        }
        return DictionaryResponse(words = filteredWords) // Return a new DictionaryResponse
    }

    suspend fun createAudio(word: String): String {
        val url = "https://stage.grechka.space/creating_audio"

        val response: HttpResponse = client.post(url) {
            headers {
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
            }
            setBody(listOf(word))
        }
        val responseBody = response.bodyAsText()
        val responseJson = Json.parseToJsonElement(responseBody).jsonObject
        return responseJson["download_url"]?.jsonPrimitive?.content
            ?: throw IllegalStateException("Failed to parse download_url")
    }

    fun close() {
        client.close()
    }
}