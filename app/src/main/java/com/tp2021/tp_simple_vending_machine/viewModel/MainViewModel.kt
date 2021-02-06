package com.tp2021.tp_simple_vending_machine.viewModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.tp2021.tp_simple_vending_machine.base.BaseViewModel
import com.tp2021.tp_simple_vending_machine.model.`object`.VendingMachine
import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel
import com.tp2021.tp_simple_vending_machine.model.network.response.VendingMachineListResponse

class MainViewModel(private val model : MainDataModel) : BaseViewModel() {

    val vmList = ObservableArrayList<VendingMachine>()

    val vmAllListResponse = MutableLiveData<VendingMachineListResponse>()

    fun getVMIntegratedList(){
        addDisposable(model.getVMIntegratedList()
            .subscribe{ it ->
                vmAllListResponse.postValue(it)
            })

    }




}