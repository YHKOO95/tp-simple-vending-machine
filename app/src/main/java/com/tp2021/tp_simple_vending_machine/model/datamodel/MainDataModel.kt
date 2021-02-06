package com.tp2021.tp_simple_vending_machine.model.datamodel

import com.tp2021.tp_simple_vending_machine.model.network.response.VendingMachineListResponse
import io.reactivex.Single

interface MainDataModel {
    fun getVMIntegratedList() : Single<VendingMachineListResponse>
}