package com.eddy.movie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eddy.movie.base.BaseActivity
import com.eddy.movie.databinding.ActivityMainBinding
import com.eddy.movie.databinding.ActivitySingleMovieBinding

class SingleMovieActivity : BaseActivity<ActivitySingleMovieBinding>({ ActivitySingleMovieBinding.inflate(it)}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}