package com.tp2021.tp_simple_vending_machine.view

import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseActivity
import com.tp2021.tp_simple_vending_machine.databinding.ActivityMainBinding
import com.tp2021.tp_simple_vending_machine.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }
}