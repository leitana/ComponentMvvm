package com.lx.componentmvvm

import com.hjq.permissions.XXPermissions
import com.lx.common.BaseApplication

/**
 * @title：AppApplication
 * @projectName ComponentMvvm
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/09/09
 */
class AppApplication: BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        XXPermissions.setScopedStorage(true)
    }
}