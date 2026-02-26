package com.tedmoon.doclensapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tedmoon.doclensapp.R
import com.tedmoon.doclensapp.databinding.ItemHomeDocumentBinding
import com.tedmoon.domain.model.category.Document

class DocumentAdapter(private val onClicked: (Document) -> Unit) :
    ListAdapter<Document, DocumentAdapter.DocumentViewHolder>(DocumentDiffCallback) {

    class DocumentViewHolder(
        private val binding: ItemHomeDocumentBinding,
        private val onClicked: (Document) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Document) {
            binding.document = item
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                onClicked(item)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DocumentViewHolder {

        val binding = DataBindingUtil.inflate<ItemHomeDocumentBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_document,
            parent,
            false
        )

        return DocumentViewHolder(
            binding = binding,
            onClicked = onClicked
        )
    }

    override fun onBindViewHolder(
        holder: DocumentViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}