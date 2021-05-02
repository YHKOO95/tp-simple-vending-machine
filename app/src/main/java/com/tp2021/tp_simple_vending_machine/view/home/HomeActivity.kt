package com.tp2021.tp_simple_vending_machine.view.home

import android.Manifest
import android.content.Intent
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseActivity
import com.tp2021.tp_simple_vending_machine.databinding.ActivityHomeBinding
import com.tp2021.tp_simple_vending_machine.utils.delayClicks
import com.tp2021.tp_simple_vending_machine.view.main.MainActivity
import com.tp2021.tp_simple_vending_machine.viewModel.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(){

    override val layoutId: Int
        get() = R.layout.activity_home
    override val viewModel: HomeViewModel by viewModel()

    override fun initStartView() {

        checkPermission()

    }

    override fun initDataBinding() {


    }

    override fun initAfterBinding() {
        with(viewModel){

            addDisposable(viewDataBinding.startBtnView.delayClicks {
                finishAffinity()
                startActivity(Intent(this@HomeActivity, MainActivity::class.java))
            })


        }
    }

    private var permissionlistener: PermissionListener = object : PermissionListener {
        override fun onPermissionGranted() {
//            Toast.makeText(this@HomeActivity, "Permission Granted", Toast.LENGTH_SHORT).show()
            finishAffinity()
            startActivity(Intent(this@HomeActivity, MainActivity::class.java))
        }

        override fun onPermissionDenied(deniedPermissions: List<String>) {
            Toast.makeText(this@HomeActivity, "Permission Denied\n$deniedPermissions", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun checkPermission(){
        TedPermission.with(this)
            .setPermissionListener(permissionlistener)
            .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
            .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
            .check()
    }
}