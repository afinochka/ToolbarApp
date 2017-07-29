package com.animation.app.toolbarapp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import flow.Flow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun attachBaseContext(newBase: Context?) {
        val flowContextWrapper = Flow.configure(baseContext, this)
                .dispatcher(BasicDispatcher(this))
                .defaultKey(WelcomeScreen())
                .keyParceler(BasicKeyParceler())
                .install()
        super.attachBaseContext(flowContextWrapper)
    }

    override fun onBackPressed() {
        if (!Flow.get(this).goBack()) {
            super.onBackPressed()
        }
    }
}




