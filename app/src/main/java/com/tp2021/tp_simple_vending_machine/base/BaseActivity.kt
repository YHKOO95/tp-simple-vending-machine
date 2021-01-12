package com.tp2021.tp_simple_vending_machine.base

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding, R : BaseViewModel> : AppCompatActivity() {

    abstract val layoutId : Int

    abstract val viewModel : R

    lateinit var viewBinding: T

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.lifecycleOwner = this

        findViewById<ImageView>(com.tp2021.tp_simple_vending_machine.R.id.backBtnView)?.let { it.setOnClickListener { finish() } }

        initStartView()

        initDataBinding()
        
        initAfterBinding()

    }
}