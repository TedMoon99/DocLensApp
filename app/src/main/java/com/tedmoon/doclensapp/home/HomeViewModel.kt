package com.tedmoon.doclensapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tedmoon.domain.model.category.Category
import com.tedmoon.domain.model.category.Document
import com.tedmoon.domain.model.category.Folder

class HomeViewModel : ViewModel() {

    private val _categoryList = MutableLiveData<List<Category>>()
    private val _documentList = MutableLiveData<List<Document>>()
    private val _folderList = MutableLiveData<List<Folder>>()

    val categoryList: LiveData<List<Category>> get() = _categoryList
    val documentList: LiveData<List<Document>> get() = _documentList
    val folderList: LiveData<List<Folder>> get() = _folderList

    init {
        loadSampleData()
    }

    private fun loadSampleData() {

        _categoryList.value = listOf(
            Category.ALL,
            Category.CONTRACT,
            Category.RECEIPT,
            Category.OTHER
        )

        _documentList.value = listOf(
            Document(
                1L, "계약서_2024.pdf",
                documentImageUrl = "asdfasdf",
                date = "2024.05.07",
                pageCnt = 3,
                category = Category.ALL,
                isRecentOpened = true
            ),
            Document(
                2L, "계약서_2024.pdf",
                documentImageUrl = "asdfasdf",
                date = "2024.05.08",
                pageCnt = 3,
                category = Category.CONTRACT,
                isRecentOpened = true
            ),
            Document(
                3L, "계약서_2024.pdf",
                documentImageUrl = "asdfasdf",
                date = "2024.05.09",
                pageCnt = 3,
                category = Category.RECEIPT,
                isRecentOpened = true
            ),
            Document(
                4L, "계약서_2024.pdf",
                documentImageUrl = "asdfasdf",
                date = "2024.05.10",
                pageCnt = 3,
                category = Category.OTHER,
                isRecentOpened = true
            ),
            Document(
                5L, "계약서_2024.pdf",
                documentImageUrl = "asdfasdf",
                date = "2024.05.11",
                pageCnt = 3,
                category = Category.RECEIPT,
                isRecentOpened = true
            ),
            Document(
                6L, "계약서_2024.pdf",
                documentImageUrl = "asdfasdf",
                date = "2024.05.12",
                pageCnt = 3,
                category = Category.ALL,
                isRecentOpened = true
            ),
            Document(
                7L, "계약서_2024.pdf",
                documentImageUrl = "asdfasdf",
                date = "2024.05.13",
                pageCnt = 3,
                category = Category.CONTRACT,
                isRecentOpened = true
            ),
        )

        _folderList.value = listOf(
            Folder(
                1,
                Category.ALL,
                documentList.value!!
            ),
            Folder(
                2,
                Category.RECEIPT,
                documentList.value!!
            ),
            Folder(
                3,
                Category.CONTRACT,
                documentList.value!!
            ),
            Folder(
                4,
                Category.OTHER,
                documentList.value!!
            ),
        )
    }
}