package com.animation.app.toolbarapp

import android.view.LayoutInflater
import android.view.ViewGroup
import flow.*

/**
 *Created by Dasha on 29.07.2017
 */
class BasicDispatcher(private val activity: MainActivity) : Dispatcher {

    override fun dispatch(traversal: Traversal, callback: TraversalCallback) {
        val destination = traversal.destination.top<Any>()

        val layoutRes = when (destination) {
            is HelloScreen -> R.layout.hello_screen
            is WelcomeScreen -> R.layout.welcome_screen
            else -> throw IllegalStateException("Unknown screen $destination")
        }


        val container = activity.findViewById(R.id.basic_activity_frame) as ViewGroup

        if (traversal.origin != null && container.childCount > 0) {
            val currentScreen = container.getChildAt(0)

            traversal.getState((traversal.origin as History).top()).save(currentScreen)
            container.removeAllViews()

            val currKey = Flow.getKey<Any>(currentScreen)
            when (destination) {
                currKey -> callback.onTraversalCompleted()
                else -> return
            }
        }

        val newView = LayoutInflater.from(traversal.createContext(destination, activity))
                .inflate(layoutRes, container, false)

        container.addView(newView)

        traversal.getState(traversal.destination.top()).restore(newView)

        callback.onTraversalCompleted()
    }
}
