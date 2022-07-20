package com.udacity.shoestore.ui.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.shoelisting.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeDetailBinding.inflate(layoutInflater, container, false)
        binding.cancelBt.setOnClickListener { findNavController().navigateUp() }
        binding.saveBt.setOnClickListener {
            val addResult = addNewShoe()
            // add success -> navigate back
            if (addResult) {
                showMessage(R.string.shoe_added_successfully_msg)
                findNavController().navigateUp()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeInputChanges()
    }

    private fun observeInputChanges() {
        // only for shoe name
        shoeNameEt.doAfterTextChanged {
            shoeNameEt.error = if (it.toString().isEmpty()) getString(R.string.empty) else null
        }
    }

    // if at least shoe name is not empty save show else show error message & return false
    private fun addNewShoe(): Boolean {
        if (shoeNameEt.text.toString().isEmpty()) {
            shoeNameEt.error = getString(R.string.empty)
            showMessage(R.string.shoe_name_error_msg)
            return false
        }
        val shoe = Shoe(
            name = shoeNameEt.text.toString(),
            size = shoeSizeEt.text.toString().toDoubleOrNull() ?: 0.0,
            company = companyEt.text.toString(),
            description = descriptionEt.text.toString()
        )
        viewModel.addShoe(shoe)
        return true
    }

    private fun showMessage(@StringRes resId: Int) {
        Toast.makeText(requireContext(), resId, Toast.LENGTH_SHORT).show()
    }
}