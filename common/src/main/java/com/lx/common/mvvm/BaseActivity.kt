package com.lx.common.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @title：BaseActivity
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLaytouResId())
        initView()
        initData()
    }

    abstract fun getLaytouResId(): Int
    abstract fun initView()
    abstract fun initData()
}