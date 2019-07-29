package com.rohanspencer.codechallenge.api

import com.google.gson.annotations.SerializedName

class WebResponse<T> (
    @SerializedName("response")
    val response: T
){
}