package com.cookandroid.social_distance.adapter

import android.app.ProgressDialog.show
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.databinding.HolderOptionBinding
import com.cookandroid.social_distance.dialog.OptionDialog
import com.cookandroid.social_distance.item.OptionItem

class OptionAdapter :RecyclerView.Adapter<OptionAdapter.OptionHolder>() {
    var data = ArrayList<OptionItem>()
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
        fun onBind(data: OptionItem) {
            binding.list = data
        }
        init {
            binding.root.setOnClickListener {
              OptionDialog(itemView.context, binding.list!!).show()
            }
        }
    }
}