package com.tp2021.tp_simple_vending_machine.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutId : Int

    lateinit var viewBinding: T

    abstract fun onActivityCreate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, layoutId)

        onActivityCreate()

    }
}