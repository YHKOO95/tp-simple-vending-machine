package com.tp2021.tp_simple_vending_machine.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) { compositeDisposable.add(disposable) }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}