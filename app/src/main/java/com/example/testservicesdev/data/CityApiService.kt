package com.example.testservicesdev.data


import com.example.testservicesdev.Model.catalogsCity
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface CityApiService {


    @GET("test.json")
    fun  hitCountCheck(): Call<catalogsCity>

    @Headers("Accept : application/json")
    @POST("")
    fun postTest(): Call<catalogsCity>
           // Observable<catalogsCity>

    /*companion object {
        fun create(): CityApiService {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
               // .baseUrl("http://httpbin.org/post")
                    .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()

            return retrofit.create(CityApiService::class.java)
        }
    }*/

}