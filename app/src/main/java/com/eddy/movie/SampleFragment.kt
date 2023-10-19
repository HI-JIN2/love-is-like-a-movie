package com.eddy.movie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eddy.movie.base.BaseFragment
import com.eddy.movie.databinding.FragmentSampleBinding

class SampleFragment : BaseFragment<FragmentSampleBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSampleBinding {
        return FragmentSampleBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Handler(Looper.getMainLooper()).postDelayed({
//            if (isOnBoardingFinished()) {
//                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
//            } else {
//                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
//            }
//        }, 1500)
    }

    private fun isOnBoardingFinished(): Boolean {
        val prefs = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return prefs.getBoolean("finished", false)
    }

}