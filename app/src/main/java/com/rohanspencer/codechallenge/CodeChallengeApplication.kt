package com.rohanspencer.codechallenge

import android.app.Activity
import android.app.Application
import com.rohanspencer.codechallenge.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Simple application wrapper to set up our activity injector so we can provide our repo to the activity while keeping
 * the two classes decoupled
 */
class CodeChallengeApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}