package com.advait.opentableproject.nytmoviereviews.service.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.advait.opentableproject.nytmoviereviews.BuildConfig
import com.advait.opentableproject.nytmoviereviews.service.model.MovieReviewList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NYTMovieReviewsRepository {
    lateinit var movieService: NYTMovieReviewService

        fun getInstance(movieService: NYTMovieReviewService): NYTMovieReviewsRepository {
            this.movieService = movieService
            return NYTMovieReviewsRepository
        }


    private val orderByKey = "by-date"

    public fun getMovieReviews():MutableLiveData<MovieReviewList> {
        val data:MutableLiveData<MovieReviewList> = MutableLiveData()
        movieService.fetchMovieReviews(orderByKey,BuildConfig.NYT_API_KEY,0).enqueue(object : Callback<MovieReviewList> {
            override fun onResponse(call: Call<MovieReviewList>, response: Response<MovieReviewList>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<MovieReviewList>, t: Throwable) {
                Log.d("MovieReviewList", "API Call failed")
            }
        })
        return data
    }
}