package com.example.home1android3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.home1android3.R
import com.example.home1android3.databinding.FragmentFirstBinding
import com.example.kotlin41.ui.prefernce.SharedPreference

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListiner()
    }

    private fun setupListiner() = with(binding){
        val preference = SharedPreference(requireActivity())
        toBeContinue.setOnClickListener{
            preference.user_name = userName.text.toString().trim()
            preference.age = age.text.toString().trim()
            preference.email = email.text.toString().trim()
            preference.password = password.text.toString().trim()
            preference.isShowRegister = true
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}