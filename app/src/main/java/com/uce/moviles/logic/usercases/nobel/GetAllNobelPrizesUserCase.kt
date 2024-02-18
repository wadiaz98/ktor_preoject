package com.uce.moviles.logic.usercases.nobel

import android.util.Log
import com.uce.moviles.data.network.endpoints.nobel.NobelPrizeEndPoint
import com.uce.moviles.data.network.entities.nobel.NobelPrize
import com.uce.moviles.data.network.entities.nobel.NobelPrizeX
import com.uce.moviles.data.network.repository.KtorClient
import com.uce.moviles.data.network.repository.RetrofitBase
import com.uce.moviles.ui.core.Constants
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllNobelPrizesUserCase {
    private val ktorClient:KtorClient = KtorClient()
    suspend fun invoke(limit: Int): Flow<Result<List<NobelPrizeX>>> = flow {

        var result: Result<List<NobelPrizeX>>? = null
        var newLimit = limit

        while (newLimit < 6) {

            val call: HttpResponse = ktorClient.getAllNobelPrizes(newLimit)
            try {
                if (call.status.isSuccess()) {
                    val a = call.body<NobelPrize>()
                    val nobelPrizes = a.nobelPrizes
                    result = Result.success(nobelPrizes)
                } else {
                    val msg = "Error en el llamado a la API de Jikan"
                    result = Result.failure(Exception(msg))
                    Log.d(Constants.TAG, msg)
                }
            } catch (ex: Exception) {
                Log.e(Constants.TAG, ex.stackTraceToString())
                result = Result.failure(ex)
            }
            emit(result!!)
            delay(2000)
            newLimit++
        }
    }
}