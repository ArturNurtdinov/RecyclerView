package com.example.recycler

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class DragManageAdapter(var adapter: Adapter, dragDirs: Int, swipeDirs: Int) :
        ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        adapter.swapItems(p1.adapterPosition, p2.adapterPosition)
        return true
    }

    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p1 == ItemTouchHelper.LEFT) {
            adapter.removeItem(p0.adapterPosition)
        } else {
            adapter.entry(p0.adapterPosition)
        }
    }

}