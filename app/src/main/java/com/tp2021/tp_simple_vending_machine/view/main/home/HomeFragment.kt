package com.tp2021.tp_simple_vending_machine.view.main.home

import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback


class HomeFragment : BaseHomeFragment(), OnMapReadyCallback {


    override fun initStartView() {

        viewDataBinding.mapView.getMapAsync(this);


    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun onMapReady(p0: NaverMap) {
        naverMap = p0

        p0.cameraPosition = CameraPosition(LatLng(37.543954, 127.047374), ZOOM_VALUE)

        setMarkerList()

    }

    fun setMarkerList(){

        viewModel.mapMarkerList.forEach { setMark(it) }

    }

}