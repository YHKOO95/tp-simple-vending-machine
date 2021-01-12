package com.tp2021.tp_simple_vending_machine.model.network.response

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("result") var result : String
)