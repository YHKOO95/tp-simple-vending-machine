package com.tp2021.tp_simple_vending_machine.model.`object`

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class VendingMachineItem(

    @SerializedName("itemId") var itemId : String,
    @SerializedName("itemName") var itemName : String,
    @SerializedName("itemQuantity") var itemQuantity : Int,
    @SerializedName("itemVolume") var itemVolume : Int,
    @SerializedName("itemVolumeUnit") var itemVolumeUnit : String,
    @SerializedName("itemExpireDate") var itemExpireDate : String

) : Serializable