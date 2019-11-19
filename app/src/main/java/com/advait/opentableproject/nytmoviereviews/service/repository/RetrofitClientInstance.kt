package com.advait.opentableproject.nytmoviereviews.service.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
Singleton class to get instance of retrofit object
 */
object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    val NYTIMES_BASE_URL: String = "http://api.nytimes.com"
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(NYTIMES_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}