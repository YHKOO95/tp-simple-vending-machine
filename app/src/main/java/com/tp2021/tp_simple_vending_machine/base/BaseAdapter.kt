package com.tp2021.tp_simple_vending_machine.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Any> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    var list = arrayListOf<T>()

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) { holder.onBind(list[position]) }

    lateinit var adapterViewModel: BaseViewModel

    abstract fun updateListItems(list: List<T>)

}