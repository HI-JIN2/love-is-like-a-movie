package com.eddy.movie.data.api

import com.eddy.movie.data.vo.MovieDetailResponseDto
import com.eddy.movie.data.vo.MovieListResponseDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieSevice {

    @GET("movie/popular")  //upcoming , popular
    fun getPopularMovie(
        @Query("page") page: Int
    ): Single<MovieListResponseDto>


    @GET("movie/{movie_id}")  //upcoming , popular
    fun getMovieDetails(
        @Path("movie_id") id: Int
    ): Single<MovieDetailResponseDto>

}