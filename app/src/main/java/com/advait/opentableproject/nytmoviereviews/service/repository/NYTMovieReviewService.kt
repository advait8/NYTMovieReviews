package com.advait.opentableproject.nytmoviereviews.service.repository

import com.advait.opentableproject.nytmoviereviews.service.model.MovieReviewList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTMovieReviewService {
    @GET("/svc/movies/v2/reviews/dvd-picks.json")
    fun fetchMovieReviews(
        @Query("order") order: String,
        @Query("api-key") apiKey: String,
        @Query("offset") offset: Int
    ): Call<MovieReviewList>
}