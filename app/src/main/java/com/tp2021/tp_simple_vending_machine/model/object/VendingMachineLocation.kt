package com.tp2021.tp_simple_vending_machine.model.`object`

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VendingMachineLocation(

    @SerializedName("x") var x : Int,
    @SerializedName("y") var y : Int

) : Serializable