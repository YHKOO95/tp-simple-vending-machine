package com.tp2021.tp_simple_vending_machine.view.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tp2021.tp_simple_vending_machine.base.BaseFragment

// Adapter for Viewpager2
class ViewPagerAdapter(fragmentActivity: FragmentActivity, var fragments: ArrayList<BaseFragment.FragmentExtension>)
    : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position] as Fragment

//    fun addFragment(fragment: BaseFragment.MainFragmentListener) {
//        fragments.add(fragment)
//        notifyItemInserted(fragments.size-1)
//    }
//
//    fun removeFragment() {
//        fragments.removeLast()
//        notifyItemRemoved(fragments.size)
//    }

    fun refreshFragment(index : Int){ fragments[index].refreshFragment() }

}
