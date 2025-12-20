package com.project.cinevault

import com.project.core.data.logging.KermitLogger
import com.project.core.data.networking.HttpClientFactory
import com.project.core.data.networking.get
import com.project.core.data.networking.getHttpClientEngine
import com.project.core.domain.util.onFailure
import com.project.core.domain.util.onSuccess

class Test {

    private val engine = getHttpClientEngine()
    private fun httpClient() = HttpClientFactory(
        cineVaultLogger = KermitLogger
    ).create(engine)

    suspend fun getMovies(): String {
        val result = httpClient().get<String>(
            route = "/discover/movie"
        )
       result
           .onFailure { error ->
                return error.name
            }
            .onSuccess { data ->
                return data
            }
        return "Some error"
    }
}