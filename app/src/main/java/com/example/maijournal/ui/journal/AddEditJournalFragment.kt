package com.example.maijournal.ui.journal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.maijournal.app.JournalApp
import com.example.maijournal.databinding.FragmentAddEditJournalBinding
import com.example.maijournal.ui.category.CategoryViewModel
import com.example.maijournal.ui.category.CategoryViewModelFactory
import com.example.maijournal.utils.CategoryAdapter

class AddEditJournalFragment : Fragment() {
    private var binding: FragmentAddEditJournalBinding? = null
    private val viewModel: CategoryViewModel by viewModels {
        CategoryViewModelFactory((requireContext().applicationContext as JournalApp).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddEditJournalBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchCategory().observe(requireActivity(), Observer {
            val adapter = CategoryAdapter(
                requireContext(), it)
            binding?.categoriesTv?.setAdapter(adapter)

        })


        //actv.setTextColor(Color.RED)
    }

}