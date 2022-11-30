package com.example.zaiddynastygamingarticlds.data.remote.responses

data class Article(
    val _id: String,
    val articleStatus: String,
    val author: Author,
    val category: Category,
    val content: Content,
    val createdBy: String,
    val createdDate: String,
    val createdOn: String,
    val fullText: String,
    val game: String,
    val gameDetails: String,
    val genre: List<String>,
    val id: String,
    val image: String,
    val isFeature: Boolean,
    val minRead: Int,
    val platform: List<String>,
    val shortDescription: ShortDescription,
    val slug: String,
    val status: String,
    val tags: List<String>,
    val title: Title,
    val updatedBy: String,
    val updatedOn: String,
    val views: Int
)