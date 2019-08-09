package kz.djunglestones.speechrecognizer.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal (
    val id:String,
    val name:String,
    val file_name:String,
    val file_url:String
):Parcelable