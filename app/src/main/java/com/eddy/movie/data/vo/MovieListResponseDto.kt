package com.eddy.movie.data.vo

import com.google.gson.annotations.SerializedName

data class MovieListResponseDto(
    val page: Int,
    @SerializedName("results")
    val movieList: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)