package com.animation.app.toolbarapp

import android.os.Parcel
import android.os.Parcelable
import kotlin.reflect.KClass
import android.R.attr.name


/**
 *Created by Dasha on 29.07.2017
 */
class HelloScreen(val name: String) : Parcelable {

    private constructor(p: Parcel?) : this(p!!.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
    }

    override fun describeContents(): Int = 0

    companion object {
        val CREATOR = object : Parcelable.Creator<HelloScreen> {
            override fun newArray(size: Int): Array<out HelloScreen>? = Array(size,
                    { HelloScreen("") })

            override fun createFromParcel(source: Parcel?): HelloScreen = HelloScreen(source)
        }
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.getClass()) return false

        val that = other as HelloScreen

        return name == that.name
    }


    override fun hashCode(): Int {
        return name.hashCode()
    }
}

fun <T : Any> T.getClass(): KClass<T> {
    return javaClass.kotlin
}
