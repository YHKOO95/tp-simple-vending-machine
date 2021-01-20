package com.tp2021.tp_simple_vending_machine.model.network.service

import io.reactivex.Single
import retrofit2.http.GET

interface MainService {

    @GET("/mapperTest")
    fun mapperTest() : Single<String>

}