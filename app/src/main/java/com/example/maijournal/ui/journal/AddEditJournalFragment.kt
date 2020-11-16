package com.example.maijournal.ui.journal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.maijournal.app.JournalApp
import com.example.maijournal.data.model.CategoryX
import com.example.maijournal.data.model.Journal
import com.example.maijournal.databinding.FragmentAddEditJournalBinding
import com.example.maijournal.ui.category.CategoryAdapter
import com.example.maijournal.ui.category.CategoryViewModel
import com.example.maijournal.ui.category.CategoryViewModelFactory
import java.util.*

class AddEditJournalFragment : Fragment() {
    private var binding: FragmentAddEditJournalBinding? = null
    private val viewModel: CategoryViewModel by viewModels {
        CategoryViewModelFactory((requireContext().applicationContext as JournalApp).repository)
    }
    private val jViewModel: JournalViewModel by viewModels {
        JournalViewModelFactory((requireContext().applicationContext as JournalApp).repository)
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
                requireContext(), it
            )
            binding?.categoriesTv?.setAdapter(adapter)
            binding?.categoriesTv?.setOnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position)
                if (item is CategoryX) {
                    binding?.categoriesTv?.setText(item.name)
                    val res = requireContext().resources.getIdentifier(item.icon,"drawable",requireContext().packageName)
                    val drawable = ContextCompat.getDrawable(requireContext(),res)
                    Log.d("TAG", "onViewCreated: $drawable")
                    binding?.categoriesTv?.setCompoundDrawablesRelativeWithIntrinsicBounds(res,0,0,0)
                }
            } })
        binding?.saveJournal?.setOnClickListener {
            saveJournal()
        }
    }

    fun saveJournal(){
        val date = Date().toString()
        binding?.currentTime?.text=date
      val journal = Journal(category = binding?.categoriesTv?.text?.toString(),title = binding?.titleTv?.text?.toString(),
          desc = binding?.descTv?.text?.toString(),detail = binding?.detailTv?.text?.toString(),updatedAt = date)

        jViewModel.saveJournal(journal)

    }

}