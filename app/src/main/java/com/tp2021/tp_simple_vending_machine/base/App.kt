package com.tp2021.tp_simple_vending_machine.base

import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import com.tp2021.tp_simple_vending_machine.di.diModule
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    @SuppressLint("ShowToast")
    override fun onCreate() {

        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(diModule)
        }

        RxJavaPlugins.setErrorHandler {
            Toast.makeText(this, "오류가 발생했습니다. 다시 시도해 주세요.", Toast.LENGTH_SHORT).show()
        }
    }


}