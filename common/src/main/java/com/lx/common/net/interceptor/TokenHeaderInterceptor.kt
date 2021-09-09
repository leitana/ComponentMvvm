package com.lx.common.net.interceptor

import com.lx.common.Constant
import com.lx.common.utils.Preference
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @title：TokenHeaderInterceptor
 * @projectName JM_TSG
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/08/05
 */
class TokenHeaderInterceptor: Interceptor {

    private var token: String by Preference(Constant.TOKEN_KEY, "")

    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().newBuilder().addHeader(
            "Content-type", "application/json; charset=utf-8")
        return if (token.isEmpty()) {
            val originalRequest = chain.request()
            chain.proceed(originalRequest)
        } else {
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder().addHeader("token", token).build()
            chain.proceed(newRequest)
        }
    }
}