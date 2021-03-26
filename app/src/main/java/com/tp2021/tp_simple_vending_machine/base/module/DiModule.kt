package com.tp2021.tp_simple_vending_machine.base.module

import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel
import com.tp2021.tp_simple_vending_machine.model.datamodel.impl.MainDataModelImpl
import com.tp2021.tp_simple_vending_machine.model.network.RestAPI
import com.tp2021.tp_simple_vending_machine.model.network.service.MainService
import com.tp2021.tp_simple_vending_machine.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


var modelModule = module {
    factory<MainDataModel> { MainDataModelImpl(get()) }


} 

var networkModule = module {
    single<MainService> { RestAPI.getInstance().create( MainService::class.java ) }

}


var viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

var diModule = listOf(modelModule, networkModule, viewModelModule)