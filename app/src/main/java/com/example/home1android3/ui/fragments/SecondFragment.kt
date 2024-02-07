package com.example.home1android3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.home1android3.R
import com.example.home1android3.databinding.FragmentSecondBinding
import com.example.home1android3.model.viewModel.MainModel

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val secondViewModel: MainModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
    }

    private fun initialize() {
        secondViewModel.huynia(requireContext())
    }

    private fun setupObserver() = with(binding) {
        secondViewModel.userData.observe(viewLifecycleOwner) { userData ->
            text1.text = userData.userName
            text2.text = userData.age
            text3.text = userData.email
            text4.text = userData.password
        }
        btnSecond.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
