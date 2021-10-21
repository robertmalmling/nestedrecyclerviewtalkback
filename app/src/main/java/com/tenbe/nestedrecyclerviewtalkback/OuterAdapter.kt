package com.tenbe.nestedrecyclerviewtalkback

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tenbe.nestedrecyclerviewtalkback.databinding.ItemViewholderBinding

class OuterAdapter : RecyclerView.Adapter<OuterAdapter.ViewHolder>() {

    private val items = mutableListOf<OuterItem>().apply {
        var count = 0
        repeat(30) { i ->
            val innerItems = mutableListOf<InnerItem>().apply {
                repeat(10) { j ->
                    count++
                    add(InnerItem("$count"))
                }
            }

            add(OuterItem(innerItems))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemViewholderBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemViewholderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OuterItem) {
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = NestedAdapter(item.items)
            }
        }
    }
}

data class OuterItem(val items: List<InnerItem>)