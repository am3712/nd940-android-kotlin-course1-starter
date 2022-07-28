package com.udacity.shoestore.ui.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.shoelisting.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeDetailBinding.inflate(layoutInflater, container, false)
        with(binding) {
            cancelBt.setOnClickListener { findNavController().navigateUp() }
            shoe = Shoe.newInstance()
            lifecycleOwner = viewLifecycleOwner
            saveBt.setOnClickListener {
                viewModel.addShoe(shoe!!)
                showMessage(R.string.shoe_added_successfully_msg)
                findNavController().navigateUp()
            }
        }
        return binding.root
    }

    private fun showMessage(@StringRes resId: Int) {
        Toast.makeText(requireContext(), resId, Toast.LENGTH_SHORT).show()
    }
}


/*binding.saveBt.setOnClickListener {
            val validationResult = binding.validateInputs()
            // add success -> navigate back
            if (validationResult) {
                showMessage(R.string.shoe_added_successfully_msg)
                findNavController().navigateUp()
            }else{
                showMessage(R.string.shoe_added_successfully_msg)
            }
        }*/
// binding.observeInputChanges()


/*private fun FragmentShoeDetailBinding.observeInputChanges() {
    val inputFields = listOf(shoeNameEt, shoeSizeEt, companyEt, descriptionEt)
    inputFields.forEach { field ->
        field.doAfterTextChanged {
            val textValue = it.toString()
            field.error =
                if (textValue.isEmpty()) getString(R.string.empty) else
                    if (textValue == "0") getString(R.string.invalid)
                    else null
        }
    }
}*/

// if at least shoe name is not empty save show else show error message & return false
/*private fun FragmentShoeDetailBinding.validateInputs(): Boolean {
    val inputFields = listOf(shoeNameEt, shoeSizeEt, companyEt, descriptionEt)
    return inputFields.all { it.error == null }
}*/