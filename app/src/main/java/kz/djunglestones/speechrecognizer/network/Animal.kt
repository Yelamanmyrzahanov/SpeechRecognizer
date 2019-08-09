package kz.djunglestones.speechrecognizer.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal (
    val id:String,
    val name:String,
    val file_name:String,
    @Json(name = "file_url") val file_url:String
):Parcelable