package com.project.core.data.networking

import com.project.core.domain.logging.CineVaultLogger
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory(
    private val cineVaultLogger: CineVaultLogger,
) {

    fun create(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        cineVaultLogger.debug(message)
                    }
                }
                level = LogLevel.ALL
            }
            install(WebSockets) {
                pingIntervalMillis = 20_000L
            }
            defaultRequest {
                accept(ContentType.Application.Json)
                header(HttpHeaders.Authorization, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1MGUxYTdhMmQyNWZmNDNiY2RlYjZlOTQzMjc5YWE2YyIsIm5iZiI6MTc2NjE1NTIxMC4zODksInN1YiI6IjY5NDU2M2NhOTU4ZDU1MmM0NTdhYjQ4YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4nJAC_91dYuKecQwXv9bttjNQL-fyOeUqi3EisdS08w")
            }
        }
    }
}