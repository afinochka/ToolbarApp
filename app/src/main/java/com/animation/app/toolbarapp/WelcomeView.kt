package com.animation.app.toolbarapp

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import flow.Flow

/**
 *Created by Dasha on 29.07.2017
 */
class WelcomeView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
        orientation = VERTICAL
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        val nameView = findViewById(R.id.welcome_screen_name) as EditText


        nameView.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(view: TextView, actionId: Int, event: KeyEvent): Boolean {
                Flow.get(view).set(HelloScreen(view.text.toString()))
                return true
            }
        })


    }
}