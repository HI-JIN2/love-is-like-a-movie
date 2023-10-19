package com.eddy.movie.data.repository

import androidx.lifecycle.LiveData
import com.eddy.movie.data.api.MovieService
import com.eddy.movie.data.vo.MovieDetailResponseDto
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MovieRepository (private val apiService: MovieService){

    lateinit var movieDetailsDataSource: MovieDetailsDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetailResponseDto>{

        movieDetailsDataSource = MovieDetailsDataSource(apiService, compositeDisposable)
        movieDetailsDataSource.fetchMovieDetails(movieId)

        return movieDetailsDataSource.downloadedMovieDetailsResponse
    }

    fun getMovieDatailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsDataSource.networkState
    }
}