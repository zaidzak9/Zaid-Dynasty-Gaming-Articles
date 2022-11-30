package com.example.zaiddynastygamingarticlds.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zaiddynastygamingarticlds.R
import com.example.zaiddynastygamingarticlds.utils.ArticlesAdapter
import com.example.zaiddynastygamingarticlds.veiwmodels.ArticleListEntryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var articlesAdapter: ArticlesAdapter
    private val  articleListEntryViewModel : ArticleListEntryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        articleListRecyclerView()
        getArticleListDataFromStateFlow()
    }

    private fun getArticleListDataFromStateFlow(){
        lifecycleScope.launchWhenStarted {
            articleListEntryViewModel.articleFlow.collect{articleListResponse ->
                when(articleListResponse){
                    is ArticleListEntryViewModel.Events.Success -> {
                        progressBar.isVisible = false
                        articleListResponse.let {
                            articlesAdapter.differ.submitList(it.articleResponse)
                        }
                    }
                    is ArticleListEntryViewModel.Events.Failure -> {
                        progressBar.isVisible = true
                    }
                    is ArticleListEntryViewModel.Events.Loading -> {
                        progressBar.isVisible = true
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun articleListRecyclerView(){
        articlesAdapter = ArticlesAdapter()

        articlesRecyclerView.apply {
            adapter = articlesAdapter
            layoutManager = GridLayoutManager(this@MainActivity,2)
        }
    }
}