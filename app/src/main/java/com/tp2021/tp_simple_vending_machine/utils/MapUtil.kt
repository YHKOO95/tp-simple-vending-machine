package com.tp2021.tp_simple_vending_machine.utils

import android.Manifest
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.naver.maps.geometry.LatLng

object MapUtil {

    fun getLocation(context: Context) : LatLng{
        val locationManager =context.getSystemService(LOCATION_SERVICE) as LocationManager?
        val userLocation: Location? = getLatLng(context, locationManager)
        return if(userLocation != null){
            LatLng(userLocation.latitude, userLocation.longitude)
        } else LatLng(37.543954, 127.047374)
    }

    private fun getLatLng(context: Context, locationManager : LocationManager?): Location? {
        val currentLatLng: Location?
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(context,
            Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(context,
            Manifest.permission.ACCESS_COARSE_LOCATION)

        currentLatLng = if(hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
            hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED){
            val locationProvider = LocationManager.GPS_PROVIDER
            locationManager?.getLastKnownLocation(locationProvider)
        } else getLatLng(context, locationManager)

        return currentLatLng
    }
}