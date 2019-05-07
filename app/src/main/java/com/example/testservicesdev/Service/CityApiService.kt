package com.example.testservicesdev.Service

import com.example.testservicesdev.Model.catalogsCity
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


interface CityApiService {
    @GET("test.json")
    fun hitCountCheck():
            Observable<catalogsCity>

    companion object {
        fun create(): CityApiService {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://dellylucas.000webhostapp.com/")
                .client(okHttpClient)
                .build()

            return retrofit.create(CityApiService::class.java)
        }
    }

}