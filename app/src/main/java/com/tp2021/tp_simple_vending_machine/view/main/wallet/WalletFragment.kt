package com.tp2021.tp_simple_vending_machine.view.main.wallet

import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentWalletBinding
import com.tp2021.tp_simple_vending_machine.viewModel.wallet.WalletViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WalletFragment : BaseFragment<FragmentWalletBinding, WalletViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_wallet

    override val viewModel: WalletViewModel by viewModel()

    override fun initStartView() {


    }

    override fun initDataBinding() {


    }

    override fun initAfterBinding() {


    }
}