package com.tp2021.tp_simple_vending_machine.view.main.search

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tp2021.tp_simple_vending_machine.base.BaseAdapter
import com.tp2021.tp_simple_vending_machine.base.BaseViewHolder
import com.tp2021.tp_simple_vending_machine.databinding.ElementSearchListBinding
import com.tp2021.tp_simple_vending_machine.model.`object`.VendingMachine

class SearchAdapter : BaseAdapter<VendingMachine>() {

    override fun updateListItems(list: List<VendingMachine>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ElementSearchListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    inner class ViewHolder(val binding : ElementSearchListBinding) : BaseViewHolder<VendingMachine>(binding){
        override fun onBind(item: VendingMachine) {


        }
    }
}

