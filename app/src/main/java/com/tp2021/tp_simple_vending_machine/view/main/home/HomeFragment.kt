package com.tp2021.tp_simple_vending_machine.view.main.home

import androidx.lifecycle.Observer
import com.naver.maps.map.util.FusedLocationSource
import com.tp2021.tp_simple_vending_machine.utils.ShowToast

class HomeFragment : BaseHomeFragment(){

    override fun initStartView() {

        viewDataBinding.mapView.getMapAsync(this)

        mLocationSource = FusedLocationSource(this, 100)



    }

    override fun initDataBinding() {
        with(viewModel){
            myLocationPermissionLiveData.observe(this@HomeFragment, Observer {



            })

        }
    }

    override fun initAfterBinding() {



    }



}