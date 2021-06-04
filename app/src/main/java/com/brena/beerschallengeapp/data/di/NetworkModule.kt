package com.brena.beerschallengeapp.data.di

import com.brena.beerschallengeapp.BuildConfig
import com.brena.beerschallengeapp.data.network.EndPointService
import com.brena.beerschallengeapp.data.network.EndPoints
import com.brena.beerschallengeapp.data.network.EndPointsImpl
import com.brena.beerschallengeapp.data.network.SupportInterceptor
import com.brena.beerschallengeapp.data.util.ConnectionUtils
import com.brena.beerschallengeapp.data.util.ConnectionUtilsImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
val netWorkModule = module {
    single<ConnectionUtils> { ConnectionUtilsImpl(androidContext()) }
    factory { SupportInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideApi(get()) }
    single<EndPoints> { EndPointsImpl(get(), get()) }
}

fun provideOkHttpClient(authInterceptor: SupportInterceptor): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(interceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
    return builder.build()
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideApi(retrofit: Retrofit): EndPointService = retrofit.create(EndPointService::class.java)