package com.cookandroid.social_distance.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.item.AreaItem
import com.cookandroid.social_distance.databinding.HolderCheckItemBinding

class InformationAdapter : RecyclerView.Adapter<InformationAdapter.CheckHolder>() {
   lateinit var data : AreaItem
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckHolder {
        val binding = HolderCheckItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CheckHolder(binding)
    }

    override fun onBindViewHolder(holder: CheckHolder, position: Int) {
        holder.onBind(data.information[position])
    }

    override fun getItemCount(): Int {
        return data.information.size
    }

    class CheckHolder(var binding: HolderCheckItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data:String) {
            binding.data = data
        }
        }
}