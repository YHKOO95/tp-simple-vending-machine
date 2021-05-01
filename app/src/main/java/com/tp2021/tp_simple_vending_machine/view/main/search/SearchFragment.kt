package com.tp2021.tp_simple_vending_machine.view.main.search

import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.FragmentSearchBinding
import com.tp2021.tp_simple_vending_machine.viewModel.search.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_search

    override val viewModel: SearchViewModel by viewModel()

    override fun initStartView() {


    }

    override fun initDataBinding() {


    }

    override fun initAfterBinding() {


    }
}