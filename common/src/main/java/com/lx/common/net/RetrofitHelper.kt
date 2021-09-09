package com.lx.common.net

import com.blankj.utilcode.util.LogUtils
import com.lx.common.Constant
import com.lx.common.net.interceptor.TokenHeaderInterceptor
import com.lx.common.utils.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @title：RetrofitHelper
 * @projectName LinWanAndroid-mvvm
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */
object RetrofitHelper {

    /**Cookie*/
//    private val cookiePersistor = SharedPrefsCookiePersistor(App.context)
//    private val cookieJar = PersistentCookieJar(SetCookieCache(), cookiePersistor)


    private const val DEFAULT_TIMEOUT: Long = 120

    private var retrofit: Retrofit? = null

    val service: ApiService by lazy {
        getRetrofit()!!.create(ApiService::class.java)
    }

    fun getRetrofit(): Retrofit?{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(MoshiConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return retrofit
    }

    private val logger = HttpLoggingInterceptor.Logger {
        LogUtils.d(it)
    }
    private val logInterceptor = HttpLoggingInterceptor(logger).apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun getOkHttpClient(): OkHttpClient {
//        if (BuildConfig.DEBUG) {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        } else {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
//        }

        val cacheFile = File(context().cacheDir, "cache")
        val cache = Cache(cacheFile, 1024 * 1024 * 50)

        val builder = OkHttpClient().newBuilder()
        builder.run {
            addNetworkInterceptor(logInterceptor)
            addInterceptor(TokenHeaderInterceptor())
//            addInterceptor(SaveCookieInterceptor())
//            addInterceptor(CacheInterceptor())
//            cookieJar(cookieJar)
            cache(cache)
            connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }
        return builder.build()
    }

//    /**清除Cookie*/
//    fun clearCookie() = cookieJar.clear()

//    /**是否有Cookie*/
//    fun hasCookie() = cookiePersistor.loadAll().isNotEmpty()

}