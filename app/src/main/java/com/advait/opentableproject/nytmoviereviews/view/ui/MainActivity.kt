package com.advait.opentableproject.nytmoviereviews.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.advait.opentableproject.nytmoviereviews.R
import com.advait.opentableproject.nytmoviereviews.databinding.ActivityMainBinding
import com.advait.opentableproject.nytmoviereviews.view.adapter.MovieReviewAdapter
import com.advait.opentableproject.nytmoviereviews.viewmodel.MovieReviewViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        val movieReviewViewModel =
            ViewModelProviders.of(this).get(MovieReviewViewModel::class.java)
        observeViewModel(movieReviewViewModel)
    }

    private fun observeViewModel(movieReviewViewModel: MovieReviewViewModel) {
        movieReviewViewModel.getMovieReviewList().observe(this, Observer {
            it.movieReviewList.let {
                binding.progressBar.visibility = View.GONE
                adapter = MovieReviewAdapter()
                adapter.movieReviewViewModel = movieReviewViewModel
                setupRecyclerView() }
        })
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.movieReviewRecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter.let { recyclerView.adapter = adapter }
    }
}
