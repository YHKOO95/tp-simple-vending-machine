package com.tp2021.tp_simple_vending_machine.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<R> : RecyclerView.ViewHolder {
    constructor(parent: ViewGroup, layoutId: Int) : super(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))

    constructor(view: View) : super(view)

    constructor(binding : ViewBinding) : super(binding.root)

    abstract fun onBind(item: R)
}



