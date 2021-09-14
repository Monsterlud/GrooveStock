package com.monsterlud.groovestock

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) : View {
    return android.view.LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun hideSoftKeyBoard(context: Context, view: View) {
    try {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}