package com.uce.moviles.data.network.repository

import com.uce.moviles.data.network.entities.jikan.anime.FullInfoAnime
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
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    private val client = HttpClient(OkHttp){
        defaultRequest{url("https://api.jikan.moe/v4/") }

        install(Logging){
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getAnimeFullInfo(id:Int): FullInfoAnimeLG {
        return client.get("anime/{id}/full").body()
    }
}