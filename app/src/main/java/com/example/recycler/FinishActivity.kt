package com.example.recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    companion object{
        val KEY = "FINISH_ACTIVITY_KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        textView.setText(intent.getStringExtra(KEY), TextView.BufferType.NORMAL)
    }
}
