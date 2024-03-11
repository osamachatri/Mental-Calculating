package com.oussama_chatri.mentalcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oussama_chatri.mentalcalculation.databinding.FragmentChooseBinding

 var type_answer=0
class choose : Fragment() {
    lateinit var binding:FragmentChooseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentChooseBinding.inflate(inflater,container,false)

        binding.additionButton.setOnClickListener {
            type_answer=1
            replaceFragment(Game())
        }
        binding.subtractionButton.setOnClickListener {
            type_answer=2
            replaceFragment(Game())
        }
        binding.multiplicationButton.setOnClickListener {
            type_answer=3
            replaceFragment(Game())
        }
        binding.divisionButton.setOnClickListener {
            type_answer=4

            replaceFragment(Game())
        }
        binding.mixButton.setOnClickListener {
            type_answer=5
            replaceFragment(Game())
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