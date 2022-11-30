package com.example.zaiddynastygamingarticlds.di

import com.example.zaiddynastygamingarticlds.data.remote.ArticlesApi
import com.example.zaiddynastygamingarticlds.repository.ArticleRepository
import com.example.zaiddynastygamingarticlds.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideArticleRepository(
        api: ArticlesApi
    ) = ArticleRepository(api = api)

    @Singleton
    @Provides
    fun provideArticleApi(): ArticlesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ArticlesApi::class.java)
    }
}