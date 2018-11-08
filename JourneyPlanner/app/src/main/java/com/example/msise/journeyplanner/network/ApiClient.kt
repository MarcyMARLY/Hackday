package com.example.msise.journeyplanner.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    val gson = GsonBuilder().create()
    val interceptor = HttpLoggingInterceptor()

    fun getClient(): Retrofit {
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(interceptor)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://scala-test-api.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient.build())
                .build()

        return retrofit
    }
}