package com.cookandroid.social_distance

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
        initSelectionTracker()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.activity_widget_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.cancel -> {
                setResult(RESULT_CANCELED)
                finish()
            }
            R.id.finish -> {
                if (regionAdapter.tracker?.selection?.isEmpty == true) {
                    Toast.makeText(this, "지역을 선택해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    getSharedPreferences("Widget", MODE_PRIVATE).edit().putInt(id.toString(),
                        regionAdapter.tracker?.selection?.first()!!.toInt()
                    ).apply()
                    setResult(RESULT_OK, Intent().putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id))
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initSupportActionBar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            adapter = regionAdapter
        }
    }

    private fun initSelectionTracker() {
        with(binding.recyclerView) {
            regionAdapter.tracker = SelectionTracker.Builder(
                "Selection",
                this,
                StableIdKeyProvider(this),
                RegionAdapter.RegionDetailsLookup(this),
                StorageStrategy.createLongStorage()
            ).withSelectionPredicate(
                SelectionPredicates.createSelectSingleAnything()
            ).build()
        }
    }

    class RegionAdapter : BaseAdapter<Region>(RegionItemCallback()) {
        var tracker: SelectionTracker<Long>? = null

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
                    tracker?.select(itemId)
                }
            }

            override fun bind(element: Region) {
                super.bind(element)
                binding.region = element

                itemView.isActivated = tracker?.isSelected(itemId) ?: false
            }
        }

        class RegionDetailsLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<Long>() {
            override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
                val view = recyclerView.findChildViewUnder(e.x, e.y) ?: return null

                val holder = recyclerView.getChildViewHolder(view)
                return if (holder is RegionHolder) {
                    object : ItemDetails<Long>() {
                        override fun getPosition(): Int {
                            return holder.adapterPosition
                        }

                        override fun getSelectionKey(): Long {
                            return holder.itemId
                        }
                    }
                } else {
                    null
                }
            }
        }

        class RegionItemCallback() : DiffUtil.ItemCallback<Region>() {
            override fun areItemsTheSame(oldItem: Region, newItem: Region): Boolean {
                return oldItem.ordinal == newItem.ordinal
            }

            override fun areContentsTheSame(oldItem: Region, newItem: Region): Boolean {
                return true
            }
        }
    }
}