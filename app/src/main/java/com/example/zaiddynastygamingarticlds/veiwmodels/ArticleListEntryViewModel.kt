package com.example.zaiddynastygamingarticlds.veiwmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zaiddynastygamingarticlds.data.remote.responses.Article
import com.example.zaiddynastygamingarticlds.repository.ArticleRepository
import com.example.zaiddynastygamingarticlds.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListEntryViewModel @Inject constructor(
    private val repository: ArticleRepository
): ViewModel() {

    sealed class Events{
        class Success(val articleResponse: List<Article>):Events()
        object Failure : Events()
        object Loading : Events()
        object Empty : Events()
    }

    init {
        loadArticleList()
    }

    private val _articleFlow = MutableStateFlow<Events>(Events.Empty)
    val articleFlow: StateFlow<Events> = _articleFlow

    private fun loadArticleList() {
        _articleFlow.value = Events.Loading
        viewModelScope.launch {
            when(val result = repository.getArticleList(1)) {
                is Resource.Success -> {
                    val articleResponse = result.data!!.articles
                    if (articleResponse == null) {
                        _articleFlow.value = Events.Failure
                    } else {
                        _articleFlow.value = Events.Success(articleResponse)
                    }
                }
                is Resource.Error -> {
                    _articleFlow.value = Events.Failure
                }
                else -> {}
            }
        }
    }
}