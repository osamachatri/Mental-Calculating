package com.oussama_chatri.mentalcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oussama_chatri.mentalcalculation.databinding.FragmentHomeBinding as FragmentHomeBinding1

class home : Fragment() {
    lateinit var binding: FragmentHomeBinding1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding1.inflate(inflater, container, false)

        // Set click listener for the button
        binding.beginPlay.setOnClickListener {
            replaceFragment(choose())
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
