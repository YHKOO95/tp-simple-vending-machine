package com.tp2021.tp_simple_vending_machine.view

import android.widget.Toast
import androidx.lifecycle.Observer
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
        viewDataBinding.viewModel = viewModel

    }

    override fun initDataBinding() {
        with(viewModel){
            vmAllListResponse.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "${it.msg}", Toast.LENGTH_SHORT)
            })


        }

    }

    override fun initAfterBinding() {

        viewModel.getVMIntegratedList()


    }
}