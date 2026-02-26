package com.tedmoon.domain.model.category

data class Folder(
    val id: Int,
    val category: Category,
    val files: List<Document>
)