package com.tp2021.tp_simple_vending_machine.model.datamodel

import io.reactivex.Single

interface MainDataModel {
    fun getTime() : Single<String>
}