package com.eddy.movie.data.repository

import androidx.paging.PageKeyedDataSource
import com.eddy.movie.data.api.MovieService
import com.eddy.movie.data.vo.Movie
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MovieDataSource(private val apiService: MovieService, private val compositeDisposable: CompositeDisposable)
    : PageKeyedDataSource<Int, Movie>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        TODO("Not yet implemented")
    }
}