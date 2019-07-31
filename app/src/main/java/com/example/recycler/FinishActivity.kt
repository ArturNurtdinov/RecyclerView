package com.example.recycler

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    companion object {
        val KEY = "FINISH_ACTIVITY_KEY"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        textView.setText(
            "Entry was made with element ${intent.getStringExtra(KEY)}",
            TextView.BufferType.NORMAL
        )
    }
}
