package com.tp2021.tp_simple_vending_machine.base

import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import com.tp2021.tp_simple_vending_machine.base.module.diModule
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.android.startKoin

class App : Application() {

    @SuppressLint("ShowToast")
    override fun onCreate() {

        super.onCreate()
        startKoin(this, diModule)

        RxJavaPlugins.setErrorHandler {
            Toast.makeText(this, "오류가 발생했습니다. 다시 시도해 주세요.", Toast.LENGTH_SHORT).show()
        }
    }


}