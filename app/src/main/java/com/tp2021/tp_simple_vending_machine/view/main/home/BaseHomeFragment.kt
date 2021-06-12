package com.tp2021.tp_simple_vending_machine.view.main.home

import android.os.Bundle
import android.view.View
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentHomeBinding
import com.tp2021.tp_simple_vending_machine.viewModel.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseHomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_home
    
    override val viewModel: MainViewModel by viewModel()

    val ZOOM_VALUE = 16.0
    lateinit var naverMap: NaverMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.mapView.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        viewDataBinding.mapView.onStart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewDataBinding.mapView.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        viewDataBinding.mapView.onResume()
    }

    override fun onStop() {
        super.onStop()
        viewDataBinding.mapView.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        viewDataBinding.mapView.onLowMemory()
    }

    fun setMark(marker: Marker, lat: Double, lng: Double, resourceID: Int) {
        //원근감 표시
        marker.isIconPerspectiveEnabled = true
        //아이콘 지정
        marker.icon = OverlayImage.fromResource(resourceID)
        //마커의 투명도
        marker.alpha = 0.8f
        //마커 위치
        marker.position = LatLng(lat, lng)
        //마커 우선순위
        marker.zIndex = 10
        //마커 표시
        marker.map = naverMap
    }

    fun setMark(marker: Marker) {
        //원근감 표시
        marker.isIconPerspectiveEnabled = true
        //아이콘 지정
        marker.icon = OverlayImage.fromResource(R.drawable.icon_mark)
        //마커의 투명도
        marker.alpha = 0.8f
        //마커 위치
        //마커 우선순위
        marker.zIndex = 10
        //마커 표시
        marker.map = naverMap
    }

}