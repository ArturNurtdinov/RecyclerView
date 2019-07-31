package com.example.recycler

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_view.view.*

class Adapter(private val elements: ArrayList<String>, private val context: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val LOG_TAG = "MY_RECYCLER"


    @SuppressLint("InflateParams")
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

    fun swapItems(fromPosition: Int, toPosition: Int) {
        val list = mutableListOf<String>()
        elements.forEach {
            list.add(it)
        }
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                elements[i] = list.set(i + 1, elements[i])
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                elements[i] = list.set(i - 1, elements[i])
            }
        }
        Log.d(LOG_TAG, "Moving from $fromPosition to $toPosition")
        notifyItemMoved(fromPosition, toPosition)
    }

    fun entry(position: Int) {
        val intent = Intent(context, FinishActivity::class.java)
        intent.putExtra(FinishActivity.KEY, elements[position])
        context.startActivity(intent)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            itemView.textView.text = text
        }
    }

}