package com.uce.moviles.data.network.repository

import com.uce.moviles.data.network.entities.jikan.anime.FullInfoAnime
import com.uce.moviles.data.network.entities.jikan.top.TopAnime
import com.uce.moviles.data.network.entities.nobel.NobelPrize
import com.uce.moviles.logic.usercases.jikan.entities.FullInfoAnimeLG
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import retrofit2.Response
import retrofit2.http.Query

object KtorClient {
    private val client = HttpClient(OkHttp){
        defaultRequest{url("http://api.nobelprize.org/2.1/") }

        install(Logging){
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(
                Json{
                    explicitNulls = false
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getAllNobelPrizes(limit: Int): HttpResponse{
        return client.get("nobelPrizes?limit=$limit").body()
    }
}