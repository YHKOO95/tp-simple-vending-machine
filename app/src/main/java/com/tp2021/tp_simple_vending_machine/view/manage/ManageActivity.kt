package com.tp2021.tp_simple_vending_machine.view.manage

import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseActivity
import com.tp2021.tp_simple_vending_machine.databinding.ActivityManageBinding
import com.tp2021.tp_simple_vending_machine.viewModel.manage.ManageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ManageActivity : BaseActivity<ActivityManageBinding, ManageViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_manage

    override val viewModel: ManageViewModel by viewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }
}