package com.tp2021.tp_simple_vending_machine.base.module

import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel
import com.tp2021.tp_simple_vending_machine.model.datamodel.impl.MainDataModelImpl
import com.tp2021.tp_simple_vending_machine.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


var networkModule = module {
    factory<MainDataModel> { MainDataModelImpl() }


}


var viewModelModule = module {
    viewModel { MainViewModel() }
}

var diModule = listOf(networkModule, viewModelModule)