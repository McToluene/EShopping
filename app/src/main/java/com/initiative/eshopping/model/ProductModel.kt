package com.initiative.eshopping.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductModel(val imageId: Int, val title: String, val price: Double, var description: String) :Parcelable