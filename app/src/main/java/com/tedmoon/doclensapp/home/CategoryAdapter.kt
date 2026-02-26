package com.tedmoon.doclensapp.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tedmoon.doclensapp.R
import com.tedmoon.doclensapp.databinding.ItemHomeCategoryBinding
import com.tedmoon.domain.model.category.Category

class CategoryAdapter(
    private val onClicked: (Category) -> Unit,
) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback) {
    class CategoryViewHolder(
        private val binding: ItemHomeCategoryBinding,
        private val onClicked: (Category) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) {
            binding.category = item // xml에 data 변경 예약
            binding.executePendingBindings() // 미루어져있는 Binding을 즉시 실행 -> 화면에 그리기 전에 즉시 반영

            binding.root.setOnClickListener {
                Log.d(TAG, "Category Item Clicked: ${item.id}, ${item.title}")
                onClicked(item)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {

        val binding = DataBindingUtil.inflate<ItemHomeCategoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_category,
            parent,
            false
        )

        return CategoryViewHolder(
            binding = binding,
            onClicked = onClicked
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private const val TAG = "CategoryAdapter"
    }
}