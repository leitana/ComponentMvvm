package com.lx.common.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.lx.common.R

/**
 * @title：ImageLoader
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */
object ImageLoader {
    // 1.开启无图模式 2.非WiFi环境 不加载图片
//    private val isLoadImage = !SettingUtil.getIsNoPhotoMode() || NetWorkUtil.isWifi(App.context)
//    private val isLoadImage = NetworkUtils.isAvailable()

    fun load(context: Context?, url: String?, iv: ImageView) {
        iv.apply {
            Glide.with(context!!).clear(iv)
            val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .placeholder(R.drawable.shape_bg_placeholder)

            Glide.with(context!!)
                .load(url)
                .transition(DrawableTransitionOptions().crossFade())
                .apply(options)
                .into(iv)
        }
    }


    /**
     * 带token的glide
     */
    fun load(context: Context?, url: String?, iv: ImageView, mToken: String) {
        val glideUrl: GlideUrl = GlideUrl(
            url,
            LazyHeaders.Builder()
                .addHeader("token", mToken)
                .build()
        )

        iv.apply {
            Glide.with(context!!).clear(iv)
            val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .placeholder(R.drawable.shape_bg_placeholder)

            Glide.with(context!!)
                .load(glideUrl)
                .transition(DrawableTransitionOptions().crossFade())
                .apply(options)
                .into(iv)
        }
    }
}