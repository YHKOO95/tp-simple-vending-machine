package com.tp2021.tp_simple_vending_machine.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.tp2021.tp_simple_vending_machine.utils.delayClicks
import com.tp2021.tp_simple_vending_machine.view.main.MainActivity

abstract class BaseFragment<T : ViewDataBinding, R : BaseViewModel> : Fragment() {

    abstract val layoutId: Int

    abstract val viewModel: R

    lateinit var viewDataBinding: T

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStartView()
        initDataBinding()
        initAfterBinding()

        view.findViewById<ImageView>(com.tp2021.tp_simple_vending_machine.R.id.menuView)?.let {
            viewModel.addDisposable(it.delayClicks {
                if (activity != null && activity is MainActivity) {
                    (activity as MainActivity).openDrawer()
                }
            })
        }

    }

    interface MainFragmentListener {
        fun refreshFragment()
    }

}