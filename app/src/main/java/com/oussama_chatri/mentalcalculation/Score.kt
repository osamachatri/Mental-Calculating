package com.oussama_chatri.mentalcalculation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oussama_chatri.mentalcalculation.databinding.FragmentScoreBinding as FragmentScoreBinding1

class Score : Fragment() {
    lateinit var binding: FragmentScoreBinding1
      @SuppressLint("SetTextI18n")
      override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
          binding= FragmentScoreBinding1.inflate(inflater,container,false)
          binding.score.text="Your level on Mental Calculation is:\n $level"
          binding.tryAgain.setOnClickListener {
              replaceFragment(choose())
              level=1
          }

          return binding.root
    }
    private fun replaceFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}