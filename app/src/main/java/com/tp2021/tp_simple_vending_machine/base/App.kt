package com.tp2021.tp_simple_vending_machine.base

import android.app.Application
import com.tp2021.tp_simple_vending_machine.base.module.diModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {

        super.onCreate()
        startKoin(this, diModule)
    }


}