package com.lx.common.mvvm

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lx.common.R
import com.lx.common.utils.StatusBarUtil

/**
 * @title：BaseVMActivity
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */
abstract class BaseVMActivity : AppCompatActivity(){


    protected inline fun <reified T: ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> = lazy {
        DataBindingUtil.setContentView<T>(this, resId).apply {
            lifecycleOwner = this@BaseVMActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        initColor()
        initActionBar()
        startObserve()
        initView()
        initData()
    }

    abstract fun initView()
    abstract fun initData()
    abstract fun startObserve()

    fun initActionBar() {
        StatusBarUtil.setColor(this, resources.getColor(R.color.white),0)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//状态栏为白色 图标显示深色
    }

//    open fun initColor(){
//        mThemeColor = if (!SettingUtil.isNightMode()) {
//            SettingUtil.getColor()
//        } else {
//            resources.getColor(R.color.colorPrimary)
//        }
//        StatusBarUtil.setColor(this, mThemeColor, 0)
//        if (this.supportActionBar != null) {
//            this.supportActionBar?.setBackgroundDrawable(ColorDrawable(mThemeColor))
//        }
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            if (SettingUtil.getNavBar()) {
//                window.navigationBarColor = CircleView.shiftColorDown(mThemeColor)
//            } else {
//                window.navigationBarColor = Color.BLACK
//            }
//        }
//
//    }
}