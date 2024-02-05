package com.example.home1android3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.home1android3.R
import com.example.home1android3.databinding.FragmentThirdBinding
import com.example.home1android3.model.OneModel


class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val oneModel: OneModel by viewModels()
    private val binding: FragmentThirdBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()

    }

    private fun setupListener() = with(binding) {
        binding.toBeContinue2.setOnClickListener {
            val name = binding.userName2.text.toString().trim()
            val age = binding.age2.text.toString().trim()
            val email = binding.email2.text.toString().trim()
            val password = binding.Password2.text.toString().trim()

            oneModel.saveUserData(requireContext(), name, age, email, password)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}