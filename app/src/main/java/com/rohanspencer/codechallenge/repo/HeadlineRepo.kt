package com.rohanspencer.codechallenge.repo

import com.rohanspencer.codechallenge.api.HeadlineService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

//todo: this is where i would inject room (or some other similar library) to persist the data coming back from the web
class HeadlineRepo @Inject constructor(val headlineService: HeadlineService) {

    fun getHeadlines(apiKey: String): Single<List<String>> {
        //todo: this map will throw an exception if we have malformed data, ideally i would check the incoming data,
        // and go to the local data store in the case of malformed or failed web requests
        return headlineService.getArticles(apiKey).map { it.response.results }
            .map { it.map { article -> article.webTitle} }
            .subscribeOn(Schedulers.io())
    }
}