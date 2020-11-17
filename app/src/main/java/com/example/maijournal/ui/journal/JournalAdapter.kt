package com.example.maijournal.ui.journal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.maijournal.data.model.Journal
import com.example.maijournal.databinding.JournalItemLayoutBinding

class JournalAdapter : ListAdapter<Journal, JournalAdapter.JournalViewHolder>(JOURNAL_DIFFUTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val binding = JournalItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return JournalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
     holder.bind(getItem(position))
    }

    inner class JournalViewHolder(private val binding: JournalItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(journal: Journal){
            binding.titleTv.text = journal.category
            binding.categoryDescTv.text = journal.desc
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