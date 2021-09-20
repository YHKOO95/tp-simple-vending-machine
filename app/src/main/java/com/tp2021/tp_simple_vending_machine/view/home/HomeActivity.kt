package com.tp2021.tp_simple_vending_machine.view.home

import android.Manifest
import android.content.Intent
import com.gun0912.tedpermission.rx3.TedPermission
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseActivity
import com.tp2021.tp_simple_vending_machine.databinding.ActivityHomeBinding
import com.tp2021.tp_simple_vending_machine.utils.AnimateUtils
import com.tp2021.tp_simple_vending_machine.utils.showToast
import com.tp2021.tp_simple_vending_machine.utils.ViewUtils
import com.tp2021.tp_simple_vending_machine.utils.delayClicks
import com.tp2021.tp_simple_vending_machine.view.main.MainActivity
import com.tp2021.tp_simple_vending_machine.viewModel.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(){

    override val layoutId: Int
        get() = R.layout.activity_home
    override val viewModel: HomeViewModel by viewModel()

    override fun initStartView() {
        ViewUtils.setStatusBarColorCode(this, R.color.black)
        AnimateUtils.slideDownToVisible(viewDataBinding.logoView)

//        checkPermission()

    }

    override fun initDataBinding() {


    }

    override fun initAfterBinding() {
        with(viewModel){

            addDisposable(viewDataBinding.startBtnView.delayClicks {
                checkPermission()
            })


        }
    }


    fun checkPermission(){
        TedPermission.create()
            .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
            .request()
            .subscribe { tedPermissionResult ->
                if (tedPermissionResult.isGranted) {
                    showToast("Permission Granted")
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                   showToast("Permission Denied${tedPermissionResult.deniedPermissions}".trimIndent())
                }
            }

    }
}