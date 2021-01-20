package com.tp2021.tp_simple_vending_machine.viewModel

import androidx.lifecycle.MutableLiveData
import com.tp2021.tp_simple_vending_machine.base.BaseViewModel
import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel

class MainViewModel(private val model : MainDataModel) : BaseViewModel() {

    val timeLiveData = MutableLiveData<String>()

    fun getTime(){
        addDisposable(model.getTime()
            .subscribe{ it ->
                timeLiveData.postValue(it)
            })
    }




}