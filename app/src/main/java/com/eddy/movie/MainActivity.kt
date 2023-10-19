package com.eddy.movie

import android.os.Bundle
import com.eddy.movie.base.BaseActivity
import com.eddy.movie.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it)}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}