package com.codingapps.newsarticle.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingapps.newsarticle.R
import com.codingapps.newsarticle.model.Fact
import kotlinx.android.synthetic.main.layout_fact_list_item.view.*

class FactAdapter : RecyclerView.Adapter<FactAdapter.FactViewHolder>() {
    private val TAG = "FactAdapter"

    private val differCallBack = object : DiffUtil.ItemCallback<Fact>() {
        override fun areItemsTheSame(oldItem: Fact, newItem: Fact): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Fact, newItem: Fact): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        return FactViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_fact_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        when (holder) {
            is FactViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${differ.currentList.size}")
        return differ.currentList.size
    }

    fun submitList(list: List<Fact>) {
        differ.submitList(list)
    }

    inner class FactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Fact) = with(itemView) {
            fact_title.text = item.title
            fact_description.text = item.description
            Glide.with(itemView.context).load(item.imageHref).into(fact_image)
        }
    }
}
