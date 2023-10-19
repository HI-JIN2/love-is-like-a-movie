package com.eddy.movie

import android.content.Intent
import android.os.Bundle
import com.eddy.movie.base.BaseActivity
import com.eddy.movie.databinding.ActivityMainBinding
import com.eddy.movie.ui.MovieDetailsActivity

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it)}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.btn1.setOnClickListener {
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("id",299534)
            startActivity(intent)
        }
    }

}