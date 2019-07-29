package com.rohanspencer.codechallenge.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlineService {
    @GET("search")
    fun getArticles(@Query("api-key") key: String) : Single<WebResponse<Search>>
}