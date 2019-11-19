package com.advait.opentableproject.nytmoviereviews.view.adapter

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.advait.opentableproject.nytmoviereviews.databinding.MovieReviewItemBinding
import com.advait.opentableproject.nytmoviereviews.service.model.MovieReview
import com.advait.opentableproject.nytmoviereviews.viewmodel.MovieReviewViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class MovieReviewAdapter : RecyclerView.Adapter<MovieReviewAdapter.MovieReviewViewHolder>() {
    private lateinit var movieReviewItemBinding: MovieReviewItemBinding
    lateinit var movieReviewViewModel: MovieReviewViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieReviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        movieReviewItemBinding = MovieReviewItemBinding.inflate(layoutInflater)
        return MovieReviewViewHolder(movieReviewItemBinding)
    }

    override fun getItemCount(): Int {
        return movieReviewViewModel.getMovieReviewList().value?.movieReviewList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieReviewViewHolder, position: Int) {
        Glide.with(movieReviewItemBinding.moviePreviewImage.context)
            .setDefaultRequestOptions(RequestOptions().fitCenter())
            .load(
                movieReviewViewModel.getMovieReviewList()
                    .value?.movieReviewList?.get(position)?.multimedia?.src
            )
            .placeholder(R.drawable.ic_media_play)
            .into(movieReviewItemBinding.moviePreviewImage)
        movieReviewViewModel.getMovieReviewList()
            .value?.movieReviewList?.get(position)?.let { holder.bind(it) }
    }

    class MovieReviewViewHolder(binding: MovieReviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val movieReviewItemBinding: MovieReviewItemBinding = binding

        fun bind(review: MovieReview) {
            movieReviewItemBinding.movieReview = review
            movieReviewItemBinding.executePendingBindings()
        }
    }
}