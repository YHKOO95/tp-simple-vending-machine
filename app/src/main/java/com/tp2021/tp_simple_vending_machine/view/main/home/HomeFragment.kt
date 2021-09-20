package com.tp2021.tp_simple_vending_machine.view.main.home

import androidx.lifecycle.Observer
import com.naver.maps.map.util.FusedLocationSource
import com.tp2021.tp_simple_vending_machine.utils.MapUtil
import com.tp2021.tp_simple_vending_machine.utils.showToast

class HomeFragment : BaseHomeFragment(){

    override fun initStartView() {

        viewDataBinding.mapView.getMapAsync(this)

        mLocationSource = FusedLocationSource(this, 100)

        context?.run { showToast("현재 위치 : ${MapUtil.getLocation(this).latitude},${MapUtil.getLocation(this).longitude}") }

    }

    override fun initDataBinding() {
        with(viewModel){
            myLocationPermissionLiveData.observe(this@HomeFragment, Observer { vmName ->
                activity?.supportFragmentManager?.let {
                    VendingMachineDetailBottomSheetFragment(mapMarkerList.first { it.vmName == vmName}).show(it, null)
                }
            })

        }
    }

    override fun initAfterBinding() {





    }



}