package com.animation.app.toolbarapp

import android.os.Parcel
import android.os.Parcelable

/**
 *Created by Dasha on 29.07.2017
 */
class WelcomeScreen : Parcelable {

    override fun writeToParcel(dest: Parcel?, flags: Int) {}

    override fun describeContents(): Int = 0

    companion object {
        val CREATOR = object : Parcelable.Creator<WelcomeScreen> {
            override fun newArray(size: Int): Array<out WelcomeScreen>? = Array(size,
                    { WelcomeScreen() })

            override fun createFromParcel(source: Parcel?): WelcomeScreen = WelcomeScreen()
        }
    }
}