package com.rohanspencer.codechallenge.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rohanspencer.codechallenge.api.HeadlineService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Here we can instantiate and provide retrofit, or any other app wide dependencies, like room or context
 *
 */

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideHeadlineService(): HeadlineService {
        // todo: the logging interceptor should only be added for debug builds
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .baseUrl("https://content.guardianapis.com/")
            .client(OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build())
            .addConverterFactory(GsonConverterFactory
                .create(GsonBuilder().setLenient()
                    .create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(HeadlineService::class.java)
    }
}