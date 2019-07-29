package com.rohanspencer.codechallenge.di

import android.app.Application
import com.rohanspencer.codechallenge.CodeChallengeApplication
import com.rohanspencer.codechallenge.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component (modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    MainActivityProviderModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(codeChallengeApplication: CodeChallengeApplication)
}