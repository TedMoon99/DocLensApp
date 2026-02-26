package com.tedmoon.doclensapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tedmoon.doclensapp.R
import com.tedmoon.doclensapp.databinding.ItemHomeFolderBinding
import com.tedmoon.domain.model.category.Folder

class FolderAdapter(
    private val onClicked: (Folder) -> Unit,
) : ListAdapter<Folder, FolderAdapter.FolderViewHolder>(FolderDiffCallback) {
    class FolderViewHolder(
        private val binding: ItemHomeFolderBinding,
        private val onClicked: (Folder) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Folder) {
            binding.folder = item
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                onClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FolderViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeFolderBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_folder,
            parent,
            false
        )

        return FolderViewHolder(binding, onClicked)
    }

    override fun onBindViewHolder(
        holder: FolderViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}
