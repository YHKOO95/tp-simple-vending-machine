package com.tp2021.tp_simple_vending_machine.model.`object`

import com.google.gson.annotations.SerializedName
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import java.io.Serializable

data class VendingMachineLocation(

    @SerializedName("x") var x : Double? = null,
    @SerializedName("y") var y : Double? = null

) : Serializable {

    val mapLocation : LatLng
        get() = LatLng(x ?: 37.543954, y ?: 127.047374)

    val mapMarker : Marker
        get() = Marker(mapLocation)

}
