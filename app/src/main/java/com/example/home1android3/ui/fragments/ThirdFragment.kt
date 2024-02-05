package com.example.home1android3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.home1android3.databinding.FragmentThirdBinding
import com.example.kotlin41.ui.prefernce.SharedPreference


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListiners()
    }

    private fun setupListiners() = with(binding) {
        val preference = SharedPreference(requireActivity())
        toBeContinue2.setOnClickListener{
            preference.user_name = userName2.text.toString().trim()
            preference.age = age2.text.toString().trim()
            preference.email = email2.text.toString().trim()
            preference.password = Password2.text.toString().trim()
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}