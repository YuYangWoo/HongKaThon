package com.cookandroid.social_distance

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.view.*
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.social_distance.base.BaseActivity
import com.cookandroid.social_distance.base.BaseAdapter
import com.cookandroid.social_distance.base.BaseHolder
import com.cookandroid.social_distance.databinding.ActivityWidgetBinding
import com.cookandroid.social_distance.databinding.HolderRegionBinding
import com.cookandroid.social_distance.gps.Region

class WidgetActivity : BaseActivity<ActivityWidgetBinding>(R.layout.activity_widget) {
    private val id by lazy { intent.extras!!.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID) }
    private val regionAdapter by lazy { RegionAdapter() }

    override fun init() {
        super.init()
        initSupportActionBar()
        initRecyclerView()
    }

    private fun initSupportActionBar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            adapter = regionAdapter
        }
    }

    inner class RegionAdapter : BaseAdapter<Region>(RegionItemCallback()) {
        init {
            setHasStableIds(true)
            submitList(Region.values().toMutableList())
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<out ViewDataBinding, Region> {
            return RegionHolder(HolderRegionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun getItemId(position: Int): Long {
            return getItem(position).ordinal.toLong()
        }

        inner class RegionHolder(binding: HolderRegionBinding) : BaseHolder<HolderRegionBinding, Region>(binding) {
            init {
                itemView.setOnClickListener {
                    getSharedPreferences("Widget", MODE_PRIVATE).edit().putInt(id.toString(), element.ordinal).apply()
                    setResult(RESULT_OK, Intent().putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id))
                    finish()
                }
            }

            override fun bind(element: Region) {
                super.bind(element)
                binding.region = element
            }
        }
    }

    class RegionItemCallback : DiffUtil.ItemCallback<Region>() {
        override fun areItemsTheSame(oldItem: Region, newItem: Region): Boolean {
            return oldItem.ordinal == newItem.ordinal
        }

        override fun areContentsTheSame(oldItem: Region, newItem: Region): Boolean {
            return true
        }
    }
}