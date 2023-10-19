package com.eddy.movie.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.eddy.movie.BuildConfig.POSTER_BASE_URL
import com.eddy.movie.base.BaseActivity
import com.eddy.movie.data.api.MovieService
import com.eddy.movie.data.api.Retrofit
import com.eddy.movie.data.repository.MovieRepository
import com.eddy.movie.data.repository.NetworkState
import com.eddy.movie.data.repository.MovieDetailsViewModel
import com.eddy.movie.data.vo.MovieDetailResponseDto
import com.eddy.movie.databinding.ActivitySingleMovieBinding
import com.eddy.movie.util.ConnectivityInterceptor
import java.text.NumberFormat
import java.util.Locale

class MovieDetailsActivity :
    BaseActivity<ActivitySingleMovieBinding>({ ActivitySingleMovieBinding.inflate(it) }) {

    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var repository: MovieRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val movieId: Int = intent.getIntExtra("id",1)

        val apiService: MovieService = Retrofit.getClient(ConnectivityInterceptor(this))

        repository = MovieRepository(apiService)
        viewModel = getViewModel(movieId)

        viewModel.movieDetails.observe(this, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(this, Observer {
            binding.progressBarPopular.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            binding.txtError.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE
        })

    }

    private fun bindUI(it: MovieDetailResponseDto) {
        val formatCurrency = NumberFormat.getCurrencyInstance(Locale.US)

        binding.movieTitle.text = it.title
        binding.movieTagline.text = it.tagline
        binding.movieReleaseDate.text = it.releaseDate
        binding.movieRating.text = it.rating
        binding.movieRuntime.text = it.runtime.toString() + " minutes"
        binding.movieBudget.text = formatCurrency.format(it.budget)
        binding.movieRevenue.text = formatCurrency.format(it.revenue)
        binding.movieOverview.text = it.overview

        val moviePosterURL = POSTER_BASE_URL + it.posterPath
        Glide.with(this)
            .load(moviePosterURL)
            .into(binding.ivMoviePoster);
    }

    private fun getViewModel(movieId: Int): MovieDetailsViewModel {
        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return MovieDetailsViewModel(repository, movieId) as T
            }
        })[MovieDetailsViewModel::class.java]
    }

}