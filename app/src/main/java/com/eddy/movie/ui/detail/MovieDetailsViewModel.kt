package com.eddy.movie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.eddy.movie.data.repository.MovieRepository
import com.eddy.movie.data.repository.NetworkState
import com.eddy.movie.data.vo.MovieDetailResponseDto
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MovieDetailsViewModel(private val movieRepository: MovieRepository, movieId: Int): ViewModel() {

    private val compositDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetailResponseDto> by lazy {
        movieRepository.fetchSingleMovieDetails(compositDisposable,movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() { //when destroyed
        super.onCleared()
        compositDisposable.dispose()
    }
}