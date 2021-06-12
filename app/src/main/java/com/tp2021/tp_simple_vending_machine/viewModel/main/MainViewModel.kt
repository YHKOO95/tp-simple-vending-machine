package com.tp2021.tp_simple_vending_machine.viewModel.main

import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import com.tp2021.tp_simple_vending_machine.base.BaseViewModel
import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel

class MainViewModel(private val model : MainDataModel) : BaseViewModel() {

    val mapMarkerList = listOf(
        Marker( LatLng(37.543954, 127.047374) ),
        Marker( LatLng(37.544635, 127.043866) ),
        Marker( LatLng(37.541904, 127.044681) )



    )




}