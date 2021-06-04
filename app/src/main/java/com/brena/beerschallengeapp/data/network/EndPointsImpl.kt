package com.brena.beerschallengeapp.data.network

import com.brena.beerschallengeapp.data.response.BeerResponse
import com.brena.beerschallengeapp.data.util.ConnectionUtils
import com.brena.beerschallengeapp.domain.handle.Either
import com.brena.beerschallengeapp.domain.handle.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class EndPointsImpl(
    private val connectionUtils: ConnectionUtils,
    private val endPointService: EndPointService
): EndPoints {

    companion object{
        private val TAG = EndPointsImpl::class.java.simpleName
        private val KEY_STATUS_CODE = "statusCode"
        private val KEY_MESSAGE = "message"
    }


    override suspend fun getBeers(page: Int): Either<Failure, List<BeerResponse>> = callService { endPointService.getBeers(page) }


    private suspend inline fun <T> callService(crossinline retrofitCall: suspend () -> Response<T>)
            : Either<Failure, T> {
        return when (connectionUtils.isNetworkAvailable()) {
            true -> {
                try {
                    withContext(Dispatchers.IO) {
                        val response = retrofitCall.invoke()
                        if (response.isSuccessful && response.body() != null) {
                            return@withContext Either.Right(response.body()!!)
                        } else {
                            return@withContext Either.Left(
                                getErrorMessageFromServer(response.errorBody()?.string())
                            )
                        }
                    }
                } catch (e: Exception) {
                    return Either.Left(parseException(e))
                }
            }
            false -> Either.Left(Failure.NoNetworkDetected)
        }
    }

    /**
     * Parse Server Error to [Failure.ServerBodyError] if [errorBody] [isServerErrorValid].
     * @return [Failure] object.
     */
    private suspend fun getErrorMessageFromServer(errorBody: String?): Failure {
        return if (errorBody != null) {
            return withContext(Dispatchers.IO) {
                val serverErrorJson = JSONObject(errorBody)
                when {
                    isServerErrorValid(serverErrorJson.toString()) -> {
                        val code = serverErrorJson[KEY_STATUS_CODE].toString().toInt()
                        if (code == 401 || code == 403) {
                            return@withContext Failure.UnauthorizedOrForbidden // in this project no is invoke
                        } else {
                            return@withContext Failure.ServerBodyError(
                                code,
                                serverErrorJson[KEY_MESSAGE].toString()
                            )
                        }
                    }
                    serverErrorJson.toString().contains("\"$KEY_MESSAGE\"") -> {
                        return@withContext Failure.ServiceUncaughtFailure(
                            serverErrorJson[KEY_MESSAGE].toString()
                        )
                    }
                    else -> return@withContext Failure.None
                }
            }
        } else {
            //No error body was found.
            Failure.None
        }
    }

    private fun isServerErrorValid(error: String): Boolean {
        return error.contains("\"$KEY_STATUS_CODE\"") && error.contains("\"$KEY_MESSAGE\"")
    }

    private fun parseException(throwable: Throwable): Failure {
        return when (throwable) {
            is SocketTimeoutException -> Failure.TimeOut
            is SSLException -> Failure.NetworkConnectionLostSuddenly
            is SSLHandshakeException -> Failure.SSLError
            else -> Failure.ServiceUncaughtFailure(
                throwable.message
                    ?: "Service response doesn't match with response object."
            )
        }
    }

}