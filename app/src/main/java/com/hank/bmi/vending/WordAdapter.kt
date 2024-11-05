package com.hank.bmi.vending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hank.bmi.Word
import com.hank.bmi.databinding.RowWordBinding

class WordAdapter(var words: List<Word>) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    class WordViewHolder(var view: RowWordBinding) : RecyclerView.ViewHolder(view.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = RowWordBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WordViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val list = words.get(position)
        holder.view.name.text = list.name
        holder.view.diff.text = list.difficulty.toString()
    }


}