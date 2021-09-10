package com.lx.common.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.lx.common.statusView.MultiStatusView

/**
 * @title：BaseVMFragment
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */
abstract class BaseVMStatusFragment<T: ViewDataBinding>(@LayoutRes val layoutId: Int) : Fragment(layoutId){

    lateinit var binding: T
    /**
     * 多状态View
     */
    protected var mLayoutStatusView: MultiStatusView? = null
    private var isFirst = true // 是否为第一次加载


    protected fun <T: ViewDataBinding> binding(inflater: LayoutInflater, @LayoutRes res: Int, container: ViewGroup?): T =
        DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply {
            lifecycleOwner = this@BaseVMStatusFragment
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = binding(inflater, layoutId, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startObserve()
        initView()
        initData()
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }

    override fun onResume() {
        super.onResume()
        if (isFirst) {
            lazyLoad()
            isFirst = false
        }
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        lazyLoad()
    }

    abstract fun initView()
    abstract fun initData()
    abstract fun startObserve()
    abstract fun lazyLoad()
}