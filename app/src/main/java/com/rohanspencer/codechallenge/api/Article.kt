package com.rohanspencer.codechallenge.api

import com.google.gson.annotations.SerializedName

data class Article (
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("sectionId")
    val sectionId: String = "",
    @SerializedName("sectionName")
    val sectionName: String = "",
    @SerializedName("webPublicationDate")
    val webPublicationDate: String = "",
    @SerializedName("webTitle")
    val webTitle: String = ""
) {

}
