package com.tedmoon.domain.model.category

enum class Category(val id: Long, val title: String, val isClicked: Boolean = false) {
    ALL(1L, "전체", true),
    CONTRACT(2L, "계약서"),
    RECEIPT(3L, "영수증"),
    OTHER(4L, "기타")
}