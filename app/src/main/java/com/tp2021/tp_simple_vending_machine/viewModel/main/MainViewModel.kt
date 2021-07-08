package com.tp2021.tp_simple_vending_machine.viewModel.main

import androidx.lifecycle.MutableLiveData
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import com.tp2021.tp_simple_vending_machine.base.BaseViewModel
import com.tp2021.tp_simple_vending_machine.model.`object`.VendingMachine
import com.tp2021.tp_simple_vending_machine.model.`object`.VendingMachineLocation
import com.tp2021.tp_simple_vending_machine.model.`object`.VendingMachineStatus
import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel

class MainViewModel(private val model : MainDataModel) : BaseViewModel() {

    val myLocationPermissionLiveData = MutableLiveData<String>()

    val mapMarkerList = listOf(

        VendingMachine(vmName = "자판기1", vmStatus = VendingMachineStatus.AVAILABLE, vmLocation = VendingMachineLocation(37.543954, 127.047374)),
        VendingMachine(vmName = "자판기2", vmStatus = VendingMachineStatus.NOT_AVAILABLE, vmLocation = VendingMachineLocation(37.544635, 127.043866)),
        VendingMachine(vmName = "자판기3", vmStatus = VendingMachineStatus.AVAILABLE, vmLocation = VendingMachineLocation(37.541904, 127.044681)),
        VendingMachine(vmName = "자판기4", vmStatus = VendingMachineStatus.AVAILABLE, vmLocation = VendingMachineLocation(37.561099, 126.856071)),
        VendingMachine(vmName = "자판기4", vmStatus = VendingMachineStatus.AVAILABLE, vmLocation = VendingMachineLocation(37.559925, 126.856822))



    )


    fun findMarkerInfo(position : LatLng){

        if(mapMarkerList.map { it.vmLocation.mapLocation }.contains(position)){
            myLocationPermissionLiveData.postValue(mapMarkerList.first { it.vmLocation.mapLocation == position }.vmName)
        }



    }



}