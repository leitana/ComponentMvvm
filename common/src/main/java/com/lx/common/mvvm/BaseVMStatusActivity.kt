package com.lx.common.mvvm

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lx.common.R
import com.lx.common.statusView.MultiStatusView
import com.lx.common.utils.StatusBarUtil

/**
 * @title：BaseVMActivity
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */
abstract class BaseVMStatusActivity : AppCompatActivity(){

    protected inline fun <reified T: ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> = lazy {
        DataBindingUtil.setContentView<T>(this, resId).apply {
            lifecycleOwner = this@BaseVMStatusActivity
        }
    }
    /**
     * 多状态View
     */
    protected var mLayoutStatusView: MultiStatusView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        initColor()
        initActionBar()
        startObserve()
        initView()
        start()
    }

    override fun onResume() {
        super.onResume()
        initListener()
    }

    abstract fun initView()
    //请求接口
    abstract fun start()
    abstract fun startObserve()

    fun initActionBar() {
        StatusBarUtil.setColor(this, resources.getColor(R.color.white),0)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//状态栏为白色 图标显示深色
    }

    private fun initListener() {
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        start()
    }

}