package com.tp2021.tp_simple_vending_machine.utils

import android.app.Activity
import android.view.WindowManager
import androidx.core.content.ContextCompat

object ViewUtils {

    fun setStatusbarColorCode(activity : Activity, colorCode: Int) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, colorCode)

    }

}