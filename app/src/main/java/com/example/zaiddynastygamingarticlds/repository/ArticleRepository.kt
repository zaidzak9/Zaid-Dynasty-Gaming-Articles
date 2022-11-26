package com.example.zaiddynastygamingarticlds.repository

import com.example.zaiddynastygamingarticlds.data.remote.ArticlesApi
import com.example.zaiddynastygamingarticlds.data.remote.responses.ArticleMain
import com.example.zaiddynastygamingarticlds.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class ArticleRepository @Inject constructor(
    private val api: ArticlesApi
) {

    suspend fun getArticleList(page:Int): Resource<ArticleMain> {
        val response = try {
            api.getArticleList(page)
        }catch (e:Exception){
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

}