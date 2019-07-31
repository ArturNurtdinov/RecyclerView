package com.example.recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = Adapter(arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"), this)
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL))
        val dragHelper = ItemTouchHelper(DragManageAdapter(
                adapter,
                ItemTouchHelper.UP.or(ItemTouchHelper.DOWN),
                ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)
        ))
        dragHelper.attachToRecyclerView(recycler)

    }
}
