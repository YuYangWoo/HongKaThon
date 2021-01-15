package com.cookandroid.social_distance.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.AreaItem
import com.cookandroid.social_distance.databinding.HolderListBinding
import com.cookandroid.social_distance.dialog.ItemDialog
import java.util.Currency.getInstance


class ItemAdapter constructor(): RecyclerView.Adapter<ItemAdapter.ListViewHolder>() {
    var data = ArrayList<AreaItem>()
    var context:Context ?= null
    lateinit var su:FragmentManager

    constructor(context: Context, su: FragmentManager): this() {
        this.context = context
        this.su = su
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = HolderListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListViewHolder(binding,su)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ListViewHolder(private val binding: HolderListBinding,su:FragmentManager) : RecyclerView.ViewHolder(binding.root) {

            fun onBind(data: AreaItem) {
                binding.main = data
            }

        init {

            binding.root.setOnClickListener {
            ItemDialog(itemView.context, binding.main!!.name).show(su,"Dialog")
            }
        }
    }
}