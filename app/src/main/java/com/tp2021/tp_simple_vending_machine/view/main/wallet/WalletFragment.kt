package com.tp2021.tp_simple_vending_machine.view.main.wallet

import android.app.DatePickerDialog
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentWalletBinding
import com.tp2021.tp_simple_vending_machine.utils.delayClicks
import com.tp2021.tp_simple_vending_machine.viewModel.wallet.WalletViewModel
import org.joda.time.DateTime
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
        with(viewModel){
            viewDataBinding.run {
                addDisposable(timeStartView.delayClicks {
                    context?.let { context ->
                        DatePickerDialog(
                            context, R.style.datepicker, { p0, p1, p2, p3 ->
                                timeStartView.text = DateTime.now().withDate(p1, p2 + 1, p3).toString("yyyy-MM-dd")
                            }, DateTime.now().year, DateTime.now().monthOfYear - 1, DateTime.now().dayOfMonth
                        ).show()
                    }
                })

                addDisposable(timeEndView.delayClicks {
                    context?.let { context ->
                        DatePickerDialog(context, R.style.datepicker, { p0, p1, p2, p3 ->
                            timeEndView.text = DateTime.now().withDate(p1, p2 + 1, p3).toString("yyyy-MM-dd")
                        }, DateTime.now().year, DateTime.now().monthOfYear - 1, DateTime.now().dayOfMonth).show()
                    }
                })

            }


        }


    }
}