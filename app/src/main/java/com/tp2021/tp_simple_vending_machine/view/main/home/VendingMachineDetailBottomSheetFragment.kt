package com.tp2021.tp_simple_vending_machine.view.main.home

import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseBottomSheetDialogFragment
import com.tp2021.tp_simple_vending_machine.databinding.LayoutBsVmInfoBinding
import com.tp2021.tp_simple_vending_machine.model.`object`.VendingMachine
import com.tp2021.tp_simple_vending_machine.utils.ViewUtils.pxFromDp
import com.tp2021.tp_simple_vending_machine.viewModel.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VendingMachineDetailBottomSheetFragment(val vmInfo : VendingMachine) : BaseBottomSheetDialogFragment<LayoutBsVmInfoBinding, MainViewModel>(){

    override val layoutId: Int
        get() = R.layout.layout_bs_vm_info

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {
        viewDataBinding.viewModel = viewModel
        viewDataBinding.item = vmInfo

        (dialog as BottomSheetDialog).run {
            behavior.isFitToContents = true
            behavior.expandedOffset = context.pxFromDp(65)
            behavior.setPeekHeight(resources.displayMetrics.heightPixels, true)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.skipCollapsed = false
        }


    }

    override fun initDataBinding() {


    }

    override fun initAfterBinding() {


    }
}