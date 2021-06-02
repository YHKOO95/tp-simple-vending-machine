package com.tp2021.tp_simple_vending_machine.view.main

import android.annotation.SuppressLint
import android.content.Intent
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.tp2021.tp_simple_vending_machine.R
import com.tp2021.tp_simple_vending_machine.base.BaseActivity
import com.tp2021.tp_simple_vending_machine.base.BaseFragment
import com.tp2021.tp_simple_vending_machine.databinding.ActivityMainBinding
import com.tp2021.tp_simple_vending_machine.utils.ViewUtils.setStatusbarColorCode
import com.tp2021.tp_simple_vending_machine.utils.delayClicks
import com.tp2021.tp_simple_vending_machine.view.common.ViewPagerAdapter
import com.tp2021.tp_simple_vending_machine.view.main.home.HomeFragment
import com.tp2021.tp_simple_vending_machine.view.main.search.SearchFragment
import com.tp2021.tp_simple_vending_machine.view.main.setting.SettingFragment
import com.tp2021.tp_simple_vending_machine.view.main.wallet.WalletFragment
import com.tp2021.tp_simple_vending_machine.view.manage.ManageActivity
import com.tp2021.tp_simple_vending_machine.viewModel.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    private val fragmentList =
        arrayListOf(HomeFragment(), SearchFragment(), WalletFragment(), SettingFragment())

    var drawerFlag = false

    override fun initStartView() {
        viewDataBinding.viewModel = viewModel

        viewDataBinding.run {
            viewModel = this@MainActivity.viewModel
            mainViewPager.run {
                isUserInputEnabled = false // 스와핑 제한
                offscreenPageLimit = 4
                adapter = ViewPagerAdapter(
                    fragmentActivity = this@MainActivity,
                    fragments = fragmentList as ArrayList<BaseFragment.FragmentExtension>)
            }
        }

        initDrawer()
        navigationChange(0)

    }

    override fun initDataBinding() {


    }

    override fun initAfterBinding() {
        with(viewModel){
            viewDataBinding.run {

                addDisposable(drawerView.homeLayout.delayClicks { navigationChange(0) })
                addDisposable(drawerView.searchLayout.delayClicks { navigationChange(1) })
                addDisposable(drawerView.walletLayout.delayClicks { navigationChange(2) })
                addDisposable(drawerView.settingLayout.delayClicks { navigationChange(3) })

                addDisposable(drawerView.purchaseLayout.delayClicks { startActivity(Intent (this@MainActivity, ManageActivity::class.java))})


            }
        }
    }

    private fun navigationChange(index : Int){
        viewDataBinding.run {
            mainViewPager.setCurrentItem(index, false)
            drawerLayout.closeDrawers()
        }
    }

    private fun initDrawer() {
        viewDataBinding.run {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            drawerLayout.setScrimColor(ContextCompat.getColor(this@MainActivity, R.color.black60))
            drawerLayout.addDrawerListener(object : ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    super.onDrawerSlide(drawerView, slideOffset)
                    val slideX = drawerView.width * slideOffset
                    mainContentLayout.translationX = -slideX
                    if (drawerLayout.isDrawerOpen(Gravity.RIGHT) && !drawerFlag) {
                        setStatusbarColorCode(this@MainActivity, R.color.white)
                        drawerFlag = true
                    } else if (!drawerFlag) {
                        setStatusbarColorCode(this@MainActivity, R.color.white)
                        drawerFlag = true
                    }
                }

                override fun onDrawerClosed(drawerView: View) {
                    super.onDrawerClosed(drawerView)
                    drawerFlag = false
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }

                override fun onDrawerOpened(drawerView: View) {
                    super.onDrawerOpened(drawerView)
                    drawerFlag = false
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
            })

        }
    }

    @SuppressLint("WrongConstant")
    fun openDrawer() {
        viewDataBinding.drawerLayout.openDrawer(GravityCompat.END)
    }

}