package com.tp2021.tp_simple_vending_machine.base

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding, R : BaseViewModel> : AppCompatActivity() {

    abstract val layoutId : Int

    abstract val viewModel : R

    lateinit var viewDataBinding: T

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewDataBinding.lifecycleOwner = this

        findViewById<ImageView>(com.tp2021.tp_simple_vending_machine.R.id.backBtnView)?.let { it.setOnClickListener { finish() } }

        initStartView()

        initDataBinding()
        
        initAfterBinding()

    }
}