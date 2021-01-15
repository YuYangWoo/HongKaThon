package com.cookandroid.social_distance.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.AreaItem
import com.cookandroid.social_distance.databinding.HolderListBinding
import com.cookandroid.social_distance.dialog.ItemDialog
import com.cookandroid.social_distance.fragment.MainFragmentDirections
import java.util.Currency.getInstance


class ItemAdapter constructor(): RecyclerView.Adapter<ItemAdapter.ListViewHolder>() {
    var data = ArrayList<AreaItem>()
    var context:Context ?= null

    constructor(context: Context): this() {
        this.context = context
    }
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
                var name = binding.main!!.name
                var action = MainFragmentDirections.actionMainFragmentToItemDialog(name)
                itemView.findNavController().navigate(action)
            }
        }
    }
}