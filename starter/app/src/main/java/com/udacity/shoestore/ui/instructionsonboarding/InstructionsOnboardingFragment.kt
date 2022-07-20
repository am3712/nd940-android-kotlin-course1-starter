package com.udacity.shoestore.ui.instructionsonboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsOnboardingBinding


class InstructionsOnboardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding =
            FragmentInstructionsOnboardingBinding.inflate(layoutInflater, container, false)
        binding.getStartedBt.setOnClickListener {
            findNavController().navigate(
                InstructionsOnboardingFragmentDirections.actionInstructionsOnboardingFragmentToLoginFragment()
            )
        }
        return binding.root
    }
}