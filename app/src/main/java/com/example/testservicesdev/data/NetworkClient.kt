package com.example.testservicesdev.data

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class NetworkClient{

    companion object {
        var retrofit: Retrofit? = null
        val BASE_URL = "http://dellylucas.000webhostapp.com/"
        fun getRetrofitClient(): Retrofit? {
            //If condition to ensure we don't create multiple retrofit instances in a single application

            if (retrofit == null) {
                //Defining the Retrofit using Builder
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL) //This is the only mandatory call on Builder object.
                    .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                    .build()
            }
            return retrofit
        }
    }

    /*
    This public static method will return Retrofit client
    anywhere in the appplication
    */


}