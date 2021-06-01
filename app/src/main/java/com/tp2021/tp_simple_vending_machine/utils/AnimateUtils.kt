package com.tp2021.tp_simple_vending_machine.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

object AnimateUtils {

    fun slideDownToGone(view: View) {
        view.animate()
            .translationY(10f)
            .alpha(0f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    // superfluous restoration
                    view.visibility = View.GONE
                    view.alpha = 1f
                    view.translationY = 0f
                }
            })
    }

    fun slideUpToVisible(view: View) {
        view.visibility = View.VISIBLE
        view.alpha = 0f
        if (view.height > 0) {
            slideUpNowToVisible(view)
        } else {
            // wait till height is measured
            view.post { slideUpNowToVisible(view) }
        }
    }

    private fun slideUpNowToVisible(view: View) {
        view.translationY = 10f
        view.animate()
            .translationY(0f)
            .alpha(1f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    view.visibility = View.VISIBLE
                    view.alpha = 1f
                }
            })
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////


    fun slideDownToVisible(view: View) {
        view.visibility = View.VISIBLE
        view.alpha = 0f
        if (view.height > 0) {
            slideDownNowToVisible(view)
        } else {
            view.post { slideDownNowToVisible(view) }
        }
    }

    private fun slideDownNowToVisible(view: View) {
        view.translationY = -10f
        view.animate()
            .translationY(0f)
            .alpha(1f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    view.visibility = View.VISIBLE
                    view.alpha = 1f
                }
            })
    }

    fun slideUpToGone(view: View) {
        view.animate()
            .translationY(-10f)
            .alpha(0f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    // superfluous restoration
                    view.visibility = View.GONE
                    view.alpha = 1f
                    view.translationY = 0f
                }
            })
    }



}