package com.rohanspencer.codechallenge.di

import com.rohanspencer.codechallenge.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityProviderModule {
    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainActivity(): MainActivity
}