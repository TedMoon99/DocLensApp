package com.tedmoon.doclensapp.home

import androidx.recyclerview.widget.DiffUtil
import com.tedmoon.domain.model.category.Document

object DocumentDiffCallback: DiffUtil.ItemCallback<Document>() {
    override fun areItemsTheSame(
        oldItem: Document,
        newItem: Document
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Document,
        newItem: Document
    ): Boolean {
        return oldItem == newItem
    }
}