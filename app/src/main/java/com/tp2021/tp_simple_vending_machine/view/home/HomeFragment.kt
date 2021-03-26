package com.tp2021.tp_simple_vending_machine.view.home

import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentHomeBinding
import com.tp2021.tp_simple_vending_machine.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>(){

    override val layoutId: Int
        get() = R.layout.fragment_home

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

        val name = "Administrator"

        viewDataBinding.introTextView.text = "Hello, $name !!"




    }

    override fun initDataBinding() {



    }

    override fun initAfterBinding() {



    }
}