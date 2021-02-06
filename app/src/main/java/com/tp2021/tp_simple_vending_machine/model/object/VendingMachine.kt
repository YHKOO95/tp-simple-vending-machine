package com.tp2021.tp_simple_vending_machine.model.`object`

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VendingMachine(

    @SerializedName("vmId") var vmId : String,
    @SerializedName("vmName") var vmName : String,
    @SerializedName("vmStatus") var vmStatus : String,
    @SerializedName("vmChanges") var vmChanges : Int,
    @SerializedName("vmItemList") var vmItemList : List<VendingMachineItem>,
    @SerializedName("vmLocation") var vmLocation : VendingMachineLocation

) : Serializable