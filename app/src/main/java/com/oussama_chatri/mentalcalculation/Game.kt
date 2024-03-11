
package com.oussama_chatri.mentalcalculation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.system.exitProcess
import com.oussama_chatri.mentalcalculation.databinding.FragmentGameBinding as FragmentGameBinding1

var level=1
var answer=true
class Game : Fragment() {
private lateinit var binding: FragmentGameBinding1
    var n1: Int = 1
    var n2: Int = 1
        @SuppressLint("SuspiciousIndentation", "SetTextI18n")
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
      binding= FragmentGameBinding1.inflate(inflater,container,false)
      binding.level.text= "Level : $level"
          qcm(type_answer)

        return binding.root
    }
    private fun qcm(type: Int) {
            n1 = (n1..n1 + 10).random()
            n2 = (n2..n2 + 10).random()
            when (type) {
                1 -> {
                    MakeOptions('+', n1, n2)
                }

                2 -> {
                    MakeOptions('-', n1, n2)
                }

                3 -> {
                    MakeOptions('*', n1, n2)
                }

                4 -> {
                    MakeOptions('/', n1, n2)
                }

                5 -> {
                    MakeOptions('?', n1, n2)
                }

                else -> exitProcess(0)
            }
    }
    @SuppressLint("SetTextI18n")
    private fun MakeOptions(arithmetic:Char, n1:Int, n2:Int) {
        var mix=(1..4).random()
        if (arithmetic!='?') {
            binding.questionTextView.text = n1.toString() + arithmetic + n2.toString()
        }
        val correctAnswer=if (arithmetic=='+'){
            n1+n2
        } else if (arithmetic=='-') {
            n1-n2
        } else if (arithmetic=='*'){
            n1*n2
        } else if (arithmetic=='/'){
            n1/n2
        } else{
            if (mix==1){
                binding.questionTextView.text = "$n1+$n2"
                n1+n2
            } else if (mix==2) {
                binding.questionTextView.text = "$n1*$n2"
                n1*n2
            } else if (mix==3){
                binding.questionTextView.text = "$n1-$n2"
                n1-n2
            } else{
                binding.questionTextView.text = "$n1/$n2"
                n1/n2
            }
        }
        mix=(1..4).random()
        if (mix==1){
            MakeText(mix,correctAnswer)
        }else if(mix==2){
            MakeText(mix,correctAnswer)
        } else if (mix==3){
            MakeText(mix,correctAnswer)
        } else {
            MakeText(mix,correctAnswer)
        }
        binding.answer1TextView.setOnClickListener{
            onOptionClick(binding.answer1TextView, correctAnswer)
        }
        binding.answer2TextView.setOnClickListener{
            onOptionClick(binding.answer2TextView, correctAnswer)
        }
        binding.answer3TextView.setOnClickListener{
            onOptionClick(binding.answer3TextView, correctAnswer)
        }
        binding.answer4TextView.setOnClickListener{
            onOptionClick(binding.answer4TextView, correctAnswer)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun MakeText(x:Int, correctAnswer: Int) {
        for(i in 1..4){
            if(i==x){
                if (i==1){
                    binding.answer1TextView.text=correctAnswer.toString()
                } else if (i==2){
                    binding.answer2TextView.text=correctAnswer.toString()
                } else if (i==3){
                    binding.answer3TextView.text=correctAnswer.toString()
                } else {
                    binding.answer4TextView.text=correctAnswer.toString()
                }
            }else {
                if (i==1){
                    binding.answer1TextView.text=(correctAnswer-10..correctAnswer+10).random().toString()
                } else if (i==2){
                    binding.answer2TextView.text=(correctAnswer-10..correctAnswer+10).random().toString()
                } else if (i==3){
                    binding.answer3TextView.text=(correctAnswer-10..correctAnswer+10).random().toString()
                } else {
                    binding.answer4TextView.text=(correctAnswer-10..correctAnswer+10).random().toString()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun onOptionClick(view: View, correctAnswer: Int){
        val textView = view as TextView
        val optionText = textView.text.toString()
        if (optionText==correctAnswer.toString()){
            level+=1
            binding.level.text= "Level : $level"
            qcm(type_answer)
        } else{
            answer=false
            replaceFragment(Score())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}