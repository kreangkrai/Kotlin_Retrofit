package com.example.testretrofit.Models

import com.google.gson.annotations.SerializedName

data class MovieModel (
    @SerializedName("id") val id: Int,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("title") val title: String,
    @SerializedName("excerpt") val excerpt: String,
)



