package com.tp2021.tp_simple_vending_machine.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment<T : ViewDataBinding, L : BaseViewModel> : BottomSheetDialogFragment() {

    lateinit var viewDataBinding: T

    abstract val layoutId: Int

    abstract val viewModel: L

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    lateinit var listenerObserver: (PopupResponse) -> Unit
    open val isListenerInitialized: Boolean
        get() = this::listenerObserver.isInitialized

    val self: BaseBottomSheetDialogFragment<T, L>
        get() = this

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initStartView()
        initDataBinding()
        initAfterBinding()

    }
}

data class PopupResponse(val popupBtnType: PopupBtnType, val data: Any? = null)

enum class PopupBtnType { CONFIRM, CANCEL, CLOSE }
