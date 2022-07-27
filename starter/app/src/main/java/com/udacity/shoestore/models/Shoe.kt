package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {
    companion object {
        fun newInstance(): Shoe {
            return Shoe("Nick Adapt BB", 9.5, "Nick", "Men running shoes")
        }
    }
}