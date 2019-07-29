package com.rohanspencer.codechallenge

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.rohanspencer.codechallenge.repo.HeadlineRepo
import dagger.android.AndroidInjection
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class MainActivity : Activity() {

    // todo: ideally this would sit inside a presenter or viewmodel
    @Inject
    lateinit var headlineRepo: HeadlineRepo

    // todo: we could eliminate the boilerplate and risk of accessing this view when it hasn't been instantiated using
    // data binding, in addition this should ideally be a recyclerview, but without data binding there is a lot of
    // boilerplate
    lateinit var mainListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mainListView = findViewById(R.id.headlineListView)

        getData()
    }

    private fun getData() {
        val headlineSingle: Single<List<String>> = headlineRepo.getHeadlines(BuildConfig.apiKey)

        headlineSingle
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<String>> {
                override fun onSuccess(t: List<String>) {
                    setValues(t)
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    // todo: we should only print stack traces in the debug build flavour
                    e.printStackTrace()
                }

            })
    }

    private fun setValues(t: List<String>) {
        mainListView.adapter = ArrayAdapter(this, R.layout.headline_view, t)
    }
}
