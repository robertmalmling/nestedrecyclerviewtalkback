package com.tenbe.nestedrecyclerviewtalkback

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tenbe.nestedrecyclerviewtalkback.databinding.NestedItemViewholderBinding

class NestedAdapter(private val items: List<InnerItem>) : RecyclerView.Adapter<NestedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(NestedItemViewholderBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: NestedItemViewholderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InnerItem) {
            binding.cardText.text = item.text
        }

    }
}

data class InnerItem(val text: String)
