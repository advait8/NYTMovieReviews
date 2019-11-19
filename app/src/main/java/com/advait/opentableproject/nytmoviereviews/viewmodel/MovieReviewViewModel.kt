package com.advait.opentableproject.nytmoviereviews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.advait.opentableproject.nytmoviereviews.service.model.MovieReview
import com.advait.opentableproject.nytmoviereviews.service.model.MovieReviewList
import com.advait.opentableproject.nytmoviereviews.service.repository.NYTMovieReviewService
import com.advait.opentableproject.nytmoviereviews.service.repository.NYTMovieReviewsRepository
import com.advait.opentableproject.nytmoviereviews.service.repository.RetrofitClientInstance


class MovieReviewViewModel(application: Application) : AndroidViewModel(application) {
    private var listOfMovieReviews: MutableLiveData<MovieReviewList> = MutableLiveData()

    fun fetchMovieReviews(): MutableLiveData<MovieReviewList> {
        val movieReviewService: NYTMovieReviewService? =
            RetrofitClientInstance.retrofitInstance?.create(NYTMovieReviewService::class.java)
        if (movieReviewService != null)
            listOfMovieReviews =
                NYTMovieReviewsRepository.getInstance(movieReviewService).getMovieReviews()
        return listOfMovieReviews
    }

    fun getMovieReviewList(): ArrayList<MovieReview>? {
        return listOfMovieReviews.value?.movieReviewList
    }

}