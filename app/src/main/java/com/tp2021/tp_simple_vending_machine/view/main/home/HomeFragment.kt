package com.tp2021.tp_simple_vending_machine.view.main.home

import android.view.ViewGroup
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentHomeBinding
import com.tp2021.tp_simple_vending_machine.viewModel.main.MainViewModel
import net.daum.mf.map.api.MapView

import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>(){

    override val layoutId: Int
        get() = R.layout.fragment_home

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

        val mapView = MapView(context)

        val mapViewContainer = view?.findViewById(R.id.mapLayout) as ViewGroup
        mapViewContainer.addView(mapView)



    }

    override fun initDataBinding() {



    }

    override fun initAfterBinding() {



    }

    fun initMap(){

    }
}