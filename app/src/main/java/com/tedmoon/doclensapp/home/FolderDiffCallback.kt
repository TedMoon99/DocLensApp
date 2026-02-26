package com.tedmoon.doclensapp.home

import androidx.recyclerview.widget.DiffUtil
import com.tedmoon.domain.model.category.Folder

object FolderDiffCallback: DiffUtil.ItemCallback<Folder>() {
    override fun areItemsTheSame(
        oldItem: Folder,
        newItem: Folder
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Folder,
        newItem: Folder
    ): Boolean {
        return oldItem == newItem
    }
}