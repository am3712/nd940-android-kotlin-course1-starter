package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
    }

    private fun setupClickListener() {
        // use clickableSpan
        // https://developer.android.com/reference/android/text/style/ClickableSpan
        val createNewAccountText =
            SpannableString(getString(R.string.does_not_have_an_account_create))
        createNewAccountText.setSpan(
            object : ClickableSpan() {
                override fun onClick(p0: View) {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListingFragment())
                }

            },
            createNewAccountText.indexOf("Create"),
            createNewAccountText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        // https://stackoverflow.com/questions/8641343/android-clickablespan-not-calling-onclick
        createNewAccount.movementMethod = LinkMovementMethod.getInstance()
        createNewAccount.text = createNewAccountText

        loginBt.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListingFragment())
        }

    }


}