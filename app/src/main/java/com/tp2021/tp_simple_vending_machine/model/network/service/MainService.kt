package com.tp2021.tp_simple_vending_machine.model.network.service

import com.tp2021.tp_simple_vending_machine.model.network.response.BaseResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MainService {

    @FormUrlEncoded
    @POST("register")
    fun addVendingMachine(
        @Field("coord") coord: String
    ): Call<BaseResponse>

}