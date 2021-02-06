package com.tp2021.tp_simple_vending_machine.model.datamodel.impl

import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel
import com.tp2021.tp_simple_vending_machine.model.network.response.VendingMachineListResponse
import com.tp2021.tp_simple_vending_machine.model.network.service.MainService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainDataModelImpl(private val service: MainService) : MainDataModel {

    override fun getVMIntegratedList() = service.getVMIntegratedList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}