package com.tedmoon.doclensapp.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tedmoon.doclensapp.R
import com.tedmoon.doclensapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val categoryAdapter = CategoryAdapter(
        onClicked = { category ->
            Log.d(TAG, "CategoryAdapter Clicked")

        }
    )

    private val documentAdapter = DocumentAdapter(
        onClicked = { document ->

        }
    )

    private val folderAdapter = FolderAdapter(
        onClicked = { folder ->

        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeViewModel()
    }

    private fun setUpRecyclerView() {
        binding.recyclerviewHomeCategory.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        binding.recyclerviewHomeRecentDocument.apply {
            adapter = documentAdapter
            layoutManager =
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.recyclerviewHomeFolder.apply {
            adapter = folderAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModel() {
        viewModel.categoryList.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }
        viewModel.documentList.observe(viewLifecycleOwner) {
            documentAdapter.submitList(it)
        }
        viewModel.folderList.observe(viewLifecycleOwner) {
            folderAdapter.submitList(it)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}