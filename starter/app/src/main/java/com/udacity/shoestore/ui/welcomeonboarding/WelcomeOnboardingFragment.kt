package com.udacity.shoestore.ui.welcomeonboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeOnboardingBinding

class WelcomeOnboardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentWelcomeOnboardingBinding.inflate(layoutInflater, container, false)
        binding.nextBt.setOnClickListener {
            findNavController().navigate(
                WelcomeOnboardingFragmentDirections.actionWelcomeOnboardingFragmentToInstructionsOnboardingFragment()
            )
        }
        return binding.root
    }
}