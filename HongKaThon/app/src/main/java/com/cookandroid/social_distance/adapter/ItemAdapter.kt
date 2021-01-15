package com.cookandroid.social_distance.adapter

import android.app.ProgressDialog.show
import android.content.ClipData
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.AreaItem
import com.cookandroid.social_distance.databinding.HolderListBinding
import com.cookandroid.social_distance.dialog.ItemDialog

class ItemAdapter(private val context: Context) : RecyclerView.Adapter<ItemAdapter.ListViewHolder>() {
    var data = ArrayList<AreaItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = HolderListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ListViewHolder(private val binding: HolderListBinding) : RecyclerView.ViewHolder(binding.root) {
            fun onBind(data: AreaItem) {
                binding.main = data
            }

        init {
            binding.root.setOnClickListener {
            ItemDialog(itemView.context).show()
            }
        }
    }
}