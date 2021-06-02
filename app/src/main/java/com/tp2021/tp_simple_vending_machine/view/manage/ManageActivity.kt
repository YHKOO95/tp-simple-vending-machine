package com.tp2021.tp_simple_vending_machine.view.manage

import android.app.DatePickerDialog
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseActivity
import com.tp2021.tp_simple_vending_machine.databinding.ActivityManageBinding
import com.tp2021.tp_simple_vending_machine.utils.delayClicks
import com.tp2021.tp_simple_vending_machine.viewModel.manage.ManageViewModel
import org.joda.time.DateTime
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
        with(viewModel){
            viewDataBinding.run {
                addDisposable(timeStartView.delayClicks {
                    DatePickerDialog(this@ManageActivity, R.style.datepicker, { p0, p1, p2, p3 ->
                        timeStartView.text = DateTime.now().withDate(p1, p2 + 1, p3).toString("yyyy-MM-dd")
                    }, DateTime.now().year, DateTime.now().monthOfYear - 1, DateTime.now().dayOfMonth).show()
                })

                addDisposable(timeEndView.delayClicks {
                    DatePickerDialog(this@ManageActivity, R.style.datepicker, { p0, p1, p2, p3 ->
                        timeEndView.text = DateTime.now().withDate(p1, p2 + 1, p3).toString("yyyy-MM-dd")
                    }, DateTime.now().year, DateTime.now().monthOfYear - 1, DateTime.now().dayOfMonth).show()
                })

            }


        }

    }
}