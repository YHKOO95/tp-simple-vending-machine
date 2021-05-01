package com.tp2021.tp_simple_vending_machine.view.main.setting

import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentSettingBinding
import com.tp2021.tp_simple_vending_machine.viewModel.setting.SettingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_setting

    override val viewModel: SettingViewModel by viewModel()

    override fun initStartView() {


    }

    override fun initDataBinding() {


    }

    override fun initAfterBinding() {


    }
}