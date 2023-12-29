package com.eddy.movie.ui

import android.content.Intent
import android.os.Bundle
import com.eddy.movie.base.BaseActivity
import com.eddy.movie.databinding.ActivityMainBinding
import com.eddy.movie.ui.detail.MovieDetailsActivity

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it)}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.btn1.setOnClickListener {
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("id",299534)
            showToast("영화의 상세보기로 넘어갑니다.")
            startActivity(intent)
        }
    }

}