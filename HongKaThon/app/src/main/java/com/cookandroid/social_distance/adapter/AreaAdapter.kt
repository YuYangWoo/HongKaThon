package com.cookandroid.social_distance.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.item.AreaItem
import com.cookandroid.social_distance.databinding.HolderListBinding
import com.cookandroid.social_distance.fragment.MainFragmentDirections
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.singleton.CoronaData


class AreaAdapter : RecyclerView.Adapter<AreaAdapter.ListViewHolder>() {
    var data = ArrayList<AreaItem>()

    // 홀더 만들기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = HolderListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    // 홀더에 데이터 Bind
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    // 데이터 크기 return
    override fun getItemCount(): Int {
        return data.size
    }

    // 홀더 클래스 정의
    class ListViewHolder(private val binding: HolderListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: AreaItem) {
            binding.main = data
        }

        init {
            binding.root.setOnClickListener {
                var item: AreaItem =binding.main!!
                var level = CoronaData.getLevel(GpsTracker(itemView.context).getArea())
                var action = MainFragmentDirections.actionMainFragmentToInformationFragment(item, level)
                itemView.findNavController().navigate(action)
            }
        }
    }
}