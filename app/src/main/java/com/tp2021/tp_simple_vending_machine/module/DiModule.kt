package com.tp2021.tp_simple_vending_machine.module

import com.tp2021.tp_simple_vending_machine.model.datamodel.MainDataModel
import com.tp2021.tp_simple_vending_machine.model.datamodel.impl.MainDataModelImpl
import com.tp2021.tp_simple_vending_machine.model.network.RestAPI
import com.tp2021.tp_simple_vending_machine.model.network.service.MainService
import com.tp2021.tp_simple_vending_machine.viewModel.home.HomeViewModel
import com.tp2021.tp_simple_vending_machine.viewModel.main.MainViewModel
import com.tp2021.tp_simple_vending_machine.viewModel.manage.ManageViewModel
import com.tp2021.tp_simple_vending_machine.viewModel.search.SearchViewModel
import com.tp2021.tp_simple_vending_machine.viewModel.setting.SettingViewModel
import com.tp2021.tp_simple_vending_machine.viewModel.wallet.WalletViewModel
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

    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { SettingViewModel(get()) }
    viewModel { WalletViewModel(get()) }
    viewModel { ManageViewModel(get()) }
}

var diModule = listOf(modelModule, networkModule, viewModelModule)