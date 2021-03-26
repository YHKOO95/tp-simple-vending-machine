package com.tp2021.tp_simple_vending_machine.model.network.service

import com.tp2021.tp_simple_vending_machine.model.network.response.VendingMachineListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MainService {

    @GET("vm/list")
    fun getVMIntegratedList() : Single<VendingMachineListResponse>

}