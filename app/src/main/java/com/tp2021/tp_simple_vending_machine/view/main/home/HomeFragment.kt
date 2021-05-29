package com.tp2021.tp_simple_vending_machine.view.main.home

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentHomeBinding
import com.tp2021.tp_simple_vending_machine.view.main.MainActivity
import com.tp2021.tp_simple_vending_machine.viewModel.main.MainViewModel
import net.daum.mf.map.api.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>(){

    override val layoutId: Int
        get() = R.layout.fragment_home

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

//        val mapView = MapView(activity)
//
//        val mapViewContainer = viewDataBinding.mapContainer as ViewGroup
//
//        mapViewContainer.addView(mapView)
    }

    override fun initDataBinding() {



    }

    override fun initAfterBinding() {



    }

//    // CalloutBalloonAdapter 인터페이스 구현
//    inner class CustomCalloutBalloonAdapter : CalloutBalloonAdapter {
//        private val mCalloutBalloon: View = layoutInflater.inflate(R.layout.layout_custom_callout_balloon, null)
//
//        override fun getCalloutBalloon(poiItem: MapPOIItem): View {
//            (mCalloutBalloon.findViewById<View>(R.id.badge) as ImageView).setImageResource(R.drawable.ic_launcher)
//            (mCalloutBalloon.findViewById<View>(R.id.title) as TextView).text = poiItem.itemName
//            (mCalloutBalloon.findViewById<View>(R.id.desc) as TextView).text =
//                "Custom CalloutBalloon"
//            return mCalloutBalloon
//        }
//
//        override fun getPressedCalloutBalloon(poiItem: MapPOIItem): View? { return null }
//
//    }

}