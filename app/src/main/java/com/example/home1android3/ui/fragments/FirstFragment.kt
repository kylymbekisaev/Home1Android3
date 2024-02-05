package com.example.home1android3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.home1android3.R
import com.example.home1android3.databinding.FragmentFirstBinding
import com.example.home1android3.model.RegisterModel
import com.example.kotlin41.ui.prefernce.SharedPreference

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val registerModel: RegisterModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() = with(binding) {
        toBeContinue.setOnClickListener {
            val name = userName.text.toString().trim()
            val age = age.text.toString().trim()
            val email = email.text.toString().trim()
            val password = password.text.toString().trim()
            val showReg = true

            registerModel.saveUserData(requireContext(), name, age, email, password, showReg)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}