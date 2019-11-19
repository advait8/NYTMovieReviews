package com.advait.opentableproject.nytmoviereviews.service.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.advait.opentableproject.nytmoviereviews.BuildConfig
import com.advait.opentableproject.nytmoviereviews.service.model.MovieReviewList
import com.advait.opentableproject.nytmoviereviews.service.repository.ErrorUtils.parseError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


object NYTMovieReviewsRepository {
    lateinit var movieService: NYTMovieReviewService

    fun getInstance(movieService: NYTMovieReviewService): NYTMovieReviewsRepository {
        this.movieService = movieService
        return NYTMovieReviewsRepository
    }


    private val orderByKey = "by-date"

    public fun getMovieReviews(): MutableLiveData<MovieReviewList> {
        val data: MutableLiveData<MovieReviewList> = MutableLiveData()

        movieService.fetchMovieReviews(orderByKey, BuildConfig.NYT_API_KEY, 0)
            .enqueue(object : Callback<MovieReviewList> {
                override fun onResponse(
                    call: Call<MovieReviewList>,
                    response: Response<MovieReviewList>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    } else {
                        val error = parseError(response)
                        Log.d(
                            "MovieReviewList",
                            error?.message() ?: "Unable to parse the error message."
                        )
                    }
                }

                override fun onFailure(call: Call<MovieReviewList>, t: Throwable) {
                    if (t is IOException) {
                        Log.d(
                            "MovieReviewList",
                            "API call failed due to lack of internet connectivity"
                        )
                    } else {
                        Log.d("MovieReviewList", "Issues with converting the json")
                    }
                }
            })
        return data
    }
}