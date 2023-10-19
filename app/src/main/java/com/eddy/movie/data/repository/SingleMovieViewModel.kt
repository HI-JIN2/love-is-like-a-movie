package com.eddy.movie.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eddy.movie.data.vo.MovieDetailResponseDto
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository: MovieRepository, movieId: Int): ViewModel() {

    private val compositDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetailResponseDto> by lazy {
        movieRepository.fetchSingleMovieDetails(compositDisposable,movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDatailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositDisposable.dispose()
    }
}