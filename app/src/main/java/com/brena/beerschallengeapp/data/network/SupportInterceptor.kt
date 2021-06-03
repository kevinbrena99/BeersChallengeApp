package com.brena.beerschallengeapp.data.network

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class SupportInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}