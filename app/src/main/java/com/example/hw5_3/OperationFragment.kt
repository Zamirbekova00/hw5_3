package com.example.hw5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw5_3.databinding.FragmentOperationBinding

class OperationFragment : Fragment() {
    lateinit var binding: FragmentOperationBinding
    var itsWasTen: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperationBinding.inflate(layoutInflater)
        binding.textView.text = "0"
        itsWasTen = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn1.setOnClickListener {
            if (!itsWasTen) {
                binding.textView.text = (binding.textView.text.toString().toInt() + 1).toString()
                if (binding.textView.text.toString().toInt() == 10) {
                    binding.btn1.text = "-1"
                    itsWasTen = true
                }
            } else {
                binding.textView.text = (binding.textView.text.toString()
                    .toInt() - 1).toString()
                if (binding.textView.text.toString() == "0") {
                    val bundle = Bundle()
                    bundle.putString("Result", binding.textView.text.toString())
                    val resultFragment = ResultFragment()
                    resultFragment.arguments = bundle

                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.container, resultFragment)?.addToBackStack(null)?.commit()
                }
            }
        }
    }
}

