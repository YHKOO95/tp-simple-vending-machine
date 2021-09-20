package com.tp2021.tp_simple_vending_machine.utils

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.view.longClicks
import com.jakewharton.rxbinding3.view.scrollChangeEvents
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

val Context?.showToast: (String?) -> Unit
    get() = { msg: String? ->
            Toast.makeText(this, msg ?: "오류가 발생했습니다. 다시 시도해 주세요.", Toast.LENGTH_LONG).show()
        }

fun View.delayClicks(subscribe: (t: Unit) -> Unit): Disposable =
    this.clicks().throttleFirst(350, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscribe)

fun View.delayLongClicks(subscribe: (t: Unit) -> Unit): Disposable =
    this.longClicks().throttleFirst(350, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscribe)

fun EditText.delayWatcher(subscribe: (t: CharSequence) -> Unit) = delayWatcher(subscribe, false)

fun EditText.delayWatcher(
    subscribe: (t: CharSequence) -> Unit,
    noFilter: Boolean = false,
    interval: Long = 500
): Disposable =
    this.textChanges().debounce(interval, TimeUnit.MILLISECONDS)
        .filter { s -> s.isNotEmpty() || noFilter }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscribe)


fun NestedScrollView.moreScrollChanges(subscribe: (t: ViewScrollChangeEvent) -> Unit): Disposable =
    this.scrollChangeEvents().throttleLatest(350, TimeUnit.MILLISECONDS).filter {
        (it.view as NestedScrollView).let { scrollView ->
            val view = scrollView.getChildAt(scrollView.childCount - 1) as View
            val diff = view.bottom - (scrollView.height + scrollView.scrollY)
            (diff <= 20)
        }
    }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscribe)

fun RecyclerView.morScrollChanges(subscribe: (t: ViewScrollChangeEvent) -> Unit): Disposable =
    this.scrollChangeEvents().throttleLatest(500, TimeUnit.MILLISECONDS).filter {
        if (it.view is RecyclerView) {
            val rview = it.view as RecyclerView
            val layoutManager = rview.layoutManager
            val lastPosition = when (layoutManager) {
                is LinearLayoutManager -> {
                    layoutManager.findLastVisibleItemPosition()
                }
                else -> 0
            }
            (lastPosition > layoutManager?.itemCount ?: 1000000 - 1)
        } else {
            false
        }
    }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscribe)

fun Context.setResult(code: Int, intent: Intent? = null) {
    when (this) {
        is AppCompatActivity -> {
            setResult(code, intent)
        }
        is Fragment -> {
            setResult(code, intent)
        }
    }
}

fun Context.finish() {
    when (this) {
        is AppCompatActivity -> {
            finish()
        }
        is Fragment -> {
            finish()
        }
    }
}
