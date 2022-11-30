package com.example.zaiddynastygamingarticlds.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.zaiddynastygamingarticlds.R
import com.example.zaiddynastygamingarticlds.utils.ArticlesAdapter
import com.example.zaiddynastygamingarticlds.veiwmodels.ArticleListEntryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var articlesAdapter: ArticlesAdapter
    private val  articleListEntryViewModel : ArticleListEntryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        articleListRecyclerView()
    }

    private fun getArticleListDataFromStateFlow(){
        lifecycleScope.launchWhenStarted {
            articleListEntryViewModel.articleFlow.collect{articleListResponse ->
                when(articleListResponse){
                    is ArticleListEntryViewModel.Events.Success -> {

                    }
                    is ArticleListEntryViewModel.Events.Failure -> {

                    }
                    is ArticleListEntryViewModel.Events.Loading -> {

                    }
                    else -> Unit
                }
            }
        }
    }

    private fun articleListRecyclerView(){

    }
}