package com.cookandroid.social_distance.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.databinding.HolderOptionBinding

class OptionAdapter :RecyclerView.Adapter<OptionAdapter.OptionHolder>() {
    var data = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionHolder {
        val binding = HolderOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OptionHolder(binding)
    }

    override fun onBindViewHolder(holder: OptionHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class OptionHolder(private val binding: HolderOptionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: String) {
            binding.list = data
        }
    }
}