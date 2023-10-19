package com.eddy.movie.data.api

import com.eddy.movie.BuildConfig
import com.eddy.movie.util.ConnectivityInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


const val API_KEY = BuildConfig.API_KEY
const val BASE_URL = BuildConfig.BASE_URL
const val POSTER_BASE_URL = BuildConfig.POSTER_BASE_URL
const val FIRST_PAGE = 1
const val POST_PER_PAGE = 20

// https://api.themoviedb.org/3/movie/popular?api_key=6e63c2317fbe963d76c3bdc2b785f6d1&page=1
// https://api.themoviedb.org/3/movie/399579?api_key=6e63c2317fbe963d76c3bdc2b785f6d1

object Retrofit{

    fun getClient(connectivityInterceptor: ConnectivityInterceptor): MovieService
    {
        val requestInterceptor = Interceptor { chain ->
            // Interceptor take only one argument which is a lambda function so parenthesis can be omitted

            val url = chain.request()
                .url
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)   //explicitly return a value from whit @ annotation. lambda always returns the value of the last expression implicitly
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            //.addInterceptor(connectivityInterceptor)
//            .readTimeout(60, TimeUnit.SECONDS)
//            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)  // this line of code can be removed and added in the part where it is instantiated
    }
}