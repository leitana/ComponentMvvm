package com.lx.common.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lx.common.exception.ApiException
import com.lx.common.exception.ApiStatus
import com.lx.common.exception.ExceptionHandle
import com.lx.common.ext.showToast
import com.lx.common.utils.context
import kotlinx.coroutines.*

/**
 * @title：BaseViewModel
 * @projectName JM_TSG
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/17
 */
typealias Block<T> = suspend (CoroutineScope) -> T
typealias Error = suspend (Exception) -> Unit
typealias Cancel = suspend (Exception) -> Unit

abstract class BaseViewModel: ViewModel() {
    enum class StateView{
        SUCCESS, ERROR, EMPTY, NETWORK_ERROR, LODING
    }

    val uiState = MutableLiveData<StateView>()

    // UI
    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    // IO
    suspend fun<T> launchOnIO(block: suspend CoroutineScope.() -> T) {
        withContext(Dispatchers.IO){
            viewModelScope.launch { block() }
        }
    }

    protected fun launch(
        block: Block<Unit>,
        error: Error? = null,
        cancel: Cancel? = null,
        showErrorToast: Boolean = true
    ): Job {
        return viewModelScope.launch {
            try {
                block.invoke(this)
            } catch (e: Exception) {
                when(e) {
                    is CancellationException -> {
                        cancel?.invoke(e)
                    }
                    else -> {
                        onError(e, showErrorToast)
                        error?.invoke(e)
                    }
                }
            }
        }
    }

    private fun onError(e: Exception, showErrorToast: Boolean){
        when(e) {
            is ApiException -> {
                when(e.code){
                    ApiStatus.TOKEN_GENERATOR_ERROR -> {
//                        Preference.clearPreference(Constant.USERNAME_KEY)
//                        Preference.clearPreference(Constant.PASSWORD_KEY)
//                        ActivityHelper.startActivityWithClear(LoginActivity::class.java)
//                        context().showToast("token过期，请重新登录")
//                        RetrofitHelper.clearCookie()
                    }
                    // 其他错误
                    else -> if (showErrorToast) context().showToast(ExceptionHandle.handleException(e))
                }
            }

            else ->
                if (showErrorToast) context().showToast(ExceptionHandle.handleException(e))
        }
    }
}