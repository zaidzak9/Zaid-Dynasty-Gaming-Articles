package com.example.zaiddynastygamingarticlds.data.remote

import com.example.zaiddynastygamingarticlds.data.remote.responses.ArticleMain
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApi {

    @GET("articles/1")
    suspend fun getArticleList():ArticleMain
}