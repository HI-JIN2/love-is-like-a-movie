package com.eddy.movie.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.eddy.movie.data.api.MovieService
import com.eddy.movie.data.vo.MovieDetailResponseDto
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MovieRepository (private val apiService: MovieService){

    lateinit var movieDetailsDataSource: MovieDetailsDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetailResponseDto>{

        movieDetailsDataSource = MovieDetailsDataSource(apiService, compositeDisposable)
        movieDetailsDataSource.fetchMovieDetails(movieId)

        Log.d("MovieRepository", movieId.toString())
        return movieDetailsDataSource.downloadedMovieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsDataSource.networkState
    }
}