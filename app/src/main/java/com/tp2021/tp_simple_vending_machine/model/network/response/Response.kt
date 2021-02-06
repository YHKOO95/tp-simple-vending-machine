package com.tp2021.tp_simple_vending_machine.model.network.response

import com.google.gson.annotations.SerializedName
import com.tp2021.tp_simple_vending_machine.model.`object`.VendingMachine

open class BaseResponse(
    @SerializedName("statusCode") var statusCode: Int = 0
    , @SerializedName("msg") var msg: String = "오류가 발생하였습니다. 잠시 후 다시 시도해주세요."
)

open class BaseDataResponse<T>(
    @SerializedName("data") var data: T? = null
) : BaseResponse()

open class BaseListResponse<T>(
    @SerializedName("data") var data: Data<T> = Data()
) : BaseResponse() {
    class Data<T>(
        @SerializedName("count") var count: Int = 0,
        @SerializedName("list") var list: List<T> = listOf()
    )
}

class VendingMachineListResponse : BaseListResponse<VendingMachine>()