package com.rohanspencer.codechallenge.api

import com.google.gson.annotations.SerializedName


data class Search (
    @SerializedName("status")
    val status: String = "",
    @SerializedName("userTier")
    val userTier: String = "",
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("startIndex")
    val startIndex: Int = 0,
    @SerializedName("pageSize")
    val pageSize: Int = 0,
    @SerializedName("currentPage")
    val currentPage: Int = 0,
    @SerializedName("pages")
    val pages: Int = 0,
    @SerializedName("orderBy")
    val orderBy: String = "",
    @SerializedName("results")
    val results: List<Article>

) {

}
