package com.tp2021.tp_simple_vending_machine.utils

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import androidx.core.content.ContextCompat
import kotlin.math.round

object ViewUtils {

    fun setStatusBarColorCode(activity : Activity, colorCode: Int) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, colorCode)

    }

    fun Context.pxFromDp(dp: Int): Int {
        return round(dp * resources.displayMetrics.density).toInt()
    }

}