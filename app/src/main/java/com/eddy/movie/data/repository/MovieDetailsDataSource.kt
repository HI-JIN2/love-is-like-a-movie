package com.eddy.movie.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eddy.movie.data.api.MovieService
import com.eddy.movie.data.vo.MovieDetailResponseDto
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDetailsDataSource (private val apiService: MovieService, private val compositeDisposable: CompositeDisposable){

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _downloadedMovieDetailsResponse = MutableLiveData<MovieDetailResponseDto>()
    val downloadedMovieDetailsResponse: LiveData<MovieDetailResponseDto>
        get() = _downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId: Int){
        _networkState.postValue(NetworkState.LOADING)
        Log.d("d", movieId.toString())

        try {
            compositeDisposable.add(
                apiService.getMovieDetails(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe (
                        {
                            Log.d("d",it.title)

                            _downloadedMovieDetailsResponse.postValue(it)
                            Log.d("d",it.title)

                            _networkState.postValue(NetworkState.LOADED)
                            Log.d("d",it.title)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            it.message?.let { it1 -> Log.e("MovieDetailsDataSource", it1) }

                        }
                    )
            )

        }
        catch(e: Exception){
            e.message?.let { Log.e("MovieDetailsDataSource", it) }
        }
    }
}