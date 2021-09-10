package com.monsterlud.groovestock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) : View {
    return android.view.LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}