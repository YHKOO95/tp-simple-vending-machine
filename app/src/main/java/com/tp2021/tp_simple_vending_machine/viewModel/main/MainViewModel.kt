package com.tp2021.tp_simple_vending_machine.viewModel.main

import androidx.lifecycle.MutableLiveData
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import com.tp2021.tp_simple_vending_machine.base.BaseViewModel
import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel

class MainViewModel(private val model : MainDataModel) : BaseViewModel() {

    val myLocationPermissionLiveData = MutableLiveData<String>()

    val mapMarkerList = listOf(
        Marker( LatLng(37.543954, 127.047374) ),
        Marker( LatLng(37.544635, 127.043866) ),
        Marker( LatLng(37.541904, 127.044681) )



    )

    val markerInfoList = listOf(
        Pair(LatLng(37.543954, 127.047374), "1"),
        Pair(LatLng(37.544635, 127.043866), "2"),
        Pair(LatLng(37.541904, 127.044681), "3")


    )

    fun findMarkerInfo(position : LatLng){

        if(markerInfoList.map { it.first }.contains(position)){
            myLocationPermissionLiveData.postValue(markerInfoList.first { it.first == position }.second)
        }



    }



}