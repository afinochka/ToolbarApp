package com.animation.app.toolbarapp

import android.os.Parcelable
import flow.KeyParceler

/**
 *Created by Dasha on 29.07.2017
 */
class BasicKeyParceler : KeyParceler {
    override fun toParcelable(key: Any): Parcelable = key as Parcelable

    override fun toKey(parcelable: Parcelable): Any = parcelable
}