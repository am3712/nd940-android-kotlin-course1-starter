package com.udacity.shoestore.ui.shoelisting

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import kotlinx.android.synthetic.main.fragment_shoe_listing.*


class ShoeListingFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // https://stackoverflow.com/questions/29099702/how-to-hide-the-up-button-in-the-top-fragment-and-show-it-in-other-fragments
        // hide up button
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // Inflate the layout for this fragment
        val binding = FragmentShoeListingBinding.inflate(layoutInflater, container, false)
        binding.addNewShoeBt.setOnClickListener {
            findNavController().navigate(
                ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment()
            )
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeShoeList()
    }

    private fun observeShoeList() {
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { list ->
            list.forEach { shoe ->
                // https://developer.android.com/topic/libraries/data-binding/expressions#binding_data
                //  or
                // val shoeItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.shoe_list_item, listLL, false)
                val shoeItemBinding = ShoeListItemBinding.inflate(layoutInflater, listLL, false)
                shoeItemBinding.shoe = shoe
                listLL.addView(shoeItemBinding.root)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logoutItem)
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment())
        return super.onOptionsItemSelected(item)
    }
}