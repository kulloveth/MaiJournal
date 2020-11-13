package com.example.maijournal.ui.journal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.maijournal.R
import com.example.maijournal.databinding.FragmentJournalBinding

class JournalFragment : Fragment() {

    private var binding: FragmentJournalBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJournalBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding?.addJournalFab?.setOnClickListener {
          requireView().findNavController().navigate(R.id.action_journalFragment_to_addEditJournalFragment)
      }
    }


}