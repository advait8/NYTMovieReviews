package com.advait.opentableproject.nytmoviereviews.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.advait.opentableproject.nytmoviereviews.databinding.MovieReviewItemBinding
import com.advait.opentableproject.nytmoviereviews.viewmodel.MovieReviewViewModel

class MovieReviewAdapter : RecyclerView.Adapter<MovieReviewAdapter.MovieReviewViewHolder>() {
    lateinit var movieReviewViewModel: MovieReviewViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieReviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieReviewItemBinding = MovieReviewItemBinding.inflate(layoutInflater)
        return MovieReviewViewHolder(movieReviewItemBinding)
    }

    override fun getItemCount(): Int {
        return movieReviewViewModel.getMovieReviewList()?.run { size } ?: 0
    }

    override fun onBindViewHolder(holder: MovieReviewViewHolder, position: Int) {
        holder.bind()
    }

    class MovieReviewViewHolder(binding: MovieReviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val movieReviewItemBinding: MovieReviewItemBinding = binding

        fun bind() {
            movieReviewItemBinding.executePendingBindings()
        }
    }

}