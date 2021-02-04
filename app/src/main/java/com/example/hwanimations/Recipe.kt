package com.example.hwanimations

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(val name: String, val ingredients: String, @DrawableRes val picture: Int) :
    Parcelable {
}