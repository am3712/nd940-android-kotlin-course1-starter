package com.udacity.shoestore.ui.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData(emptyList<Shoe>())
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun addShoe(shoe: Shoe) {
        val newList = _shoeList.value?.plus(shoe)
        _shoeList.value = newList
    }

}