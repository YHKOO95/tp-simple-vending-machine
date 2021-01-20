package com.tp2021.tp_simple_vending_machine.model.datamodel.impl

import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel
import com.tp2021.tp_simple_vending_machine.model.network.service.MainService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainDataModelImpl(private val service: MainService) : MainDataModel {

    override fun getTime() = service.mapperTest()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}