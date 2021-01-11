package com.tp2021.tp_simple_vending_machine.view

import android.annotation.SuppressLint
import android.widget.Toast
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseActivity

class MainActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_main

    @SuppressLint("ShowToast")
    override fun onActivityCreate() {

        Toast.makeText(this, "test", Toast.LENGTH_SHORT)



    }
}