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
        get() = if(x != null && y != null) LatLng(x ?: 0.0, y ?: 0.0) else LatLng(37.543954, 127.047374)

    val mapMarker : Marker
        get() = if(x != null && y != null) Marker(mapLocation) else Marker(LatLng(37.543954, 127.047374))

}
