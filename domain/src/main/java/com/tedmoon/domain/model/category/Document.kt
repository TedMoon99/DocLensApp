package com.tedmoon.domain.model.category

data class Document(
    val id: Long,
    val title: String,
    val category: Category,
    val isRecentOpened: Boolean,
    val documentImageUrl: String,
    val date: String,
    val pageCnt: Int
)
