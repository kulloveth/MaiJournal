package com.example.maijournal.ui.journal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.maijournal.R
import com.example.maijournal.app.JournalApp
import com.example.maijournal.databinding.FragmentJournalBinding

class JournalFragment : Fragment() {

    private var binding: FragmentJournalBinding? = null
    private val jViewModel: JournalViewModel by viewModels {
        JournalViewModelFactory((requireContext().applicationContext as JournalApp).repository)
    }
    val adapter = JournalAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJournalBinding.inflate(inflater,container,false)
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.vm = jViewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.journalRv?.adapter = adapter
      binding?.addJournalFab?.setOnClickListener {
          requireView().findNavController().navigate(R.id.action_journalFragment_to_addEditJournalFragment)
      }
        jViewModel.fetchJournal().observe(requireActivity(), Observer {
            adapter.submitList(it)
            Log.d("j","jorn $it")
        })
    }


}