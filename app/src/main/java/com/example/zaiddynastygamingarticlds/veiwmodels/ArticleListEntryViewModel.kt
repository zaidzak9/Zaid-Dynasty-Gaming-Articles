package com.example.zaiddynastygamingarticlds.veiwmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zaiddynastygamingarticlds.repository.ArticleRepository
import com.example.zaiddynastygamingarticlds.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListEntryViewModel @Inject constructor(
    private val repository: ArticleRepository
): ViewModel() {

    init {
        loadArticleList()
    }

    private fun loadArticleList() {
        viewModelScope.launch {
            when(val result = repository.getArticleList(1)) {
                is Resource.Success -> {

                }
                is Resource.Error -> {
                }
                else -> {}
            }
        }
    }
}