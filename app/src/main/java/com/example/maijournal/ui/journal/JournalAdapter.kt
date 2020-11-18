package com.example.maijournal.ui.journal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.maijournal.JournalItemLayoutBinding
import com.example.maijournal.R
import com.example.maijournal.data.model.Journal


class JournalAdapter : ListAdapter<Journal, JournalAdapter.JournalViewHolder>(JOURNAL_DIFFUTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val binding:JournalItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.journal_item_layout,parent,false)
        return JournalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
     holder.bind(getItem(position))
    }

    inner class JournalViewHolder(private val binding: JournalItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(journal: Journal){
            binding.item = journal
            binding.executePendingBindings()
        }

    }

    object JOURNAL_DIFFUTIL : DiffUtil.ItemCallback<Journal>() {
        override fun areItemsTheSame(oldItem: Journal, newItem: Journal): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Journal, newItem: Journal): Boolean {
            return oldItem == newItem
        }
    }
}