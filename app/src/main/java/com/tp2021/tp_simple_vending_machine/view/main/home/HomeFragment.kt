package com.tp2021.tp_simple_vending_machine.view.main.home

import androidx.lifecycle.Observer
import com.naver.maps.map.util.FusedLocationSource
import com.tp2021.tp_simple_vending_machine.utils.MapUtil
import com.tp2021.tp_simple_vending_machine.utils.ShowToast

class HomeFragment : BaseHomeFragment(){

    override fun initStartView() {

        viewDataBinding.mapView.getMapAsync(this)

        mLocationSource = FusedLocationSource(this, 100)

        context?.let { ShowToast(context, "현재 위치 : ${MapUtil.getLocation(it).latitude},${MapUtil.getLocation(it).longitude}") }

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