package com.animation.app.toolbarapp

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import flow.Flow

/**
 *Created by Dasha on 29.07.2017
 */
class HelloView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
        orientation = VERTICAL
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        val screen = Flow.getKey<HelloScreen>(this)
        val txtView = findViewById(R.id.hello_name) as TextView
        txtView.text = "Hello" + screen?.name

        val counter = findViewById(R.id.hello_counter) as TextView
        val btn = findViewById(R.id.hello_increment) as Button
        btn.setOnClickListener { v ->
            var text = counter.text.toString()
            if (text.isEmpty()) text = "0"
            counter.text = text + 1
        }
    }

}