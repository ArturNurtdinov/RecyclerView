package com.example.recycler

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_view.view.*

class Adapter(private val elements: ArrayList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val LOG_TAG = "MY_RECYCLER"

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.list_item_view, null, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        Log.d(LOG_TAG, "On bind view holder called at position $p1")
        p0.bind(elements[p1])
    }

    fun removeItem(position: Int) {
        Log.d(LOG_TAG, "Item deleted at position $position")
        elements.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, elements.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            itemView.textView.text = text
        }
    }

}