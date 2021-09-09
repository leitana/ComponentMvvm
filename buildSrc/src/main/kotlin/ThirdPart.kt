/**
 * @author linxiao
 * @desciption 第三方依赖包
 */
object ThirdPart {
    /*******************************网络请求S***********************************/
    //网路请求库retrofit
    private const val retrofit_version = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
    //gson转换器
    const val convertGson = "com.squareup.retrofit2:converter-gson:$retrofit_version"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:2.9.0"
    //scalars转换器
    const val convertScalars = "com.squareup.retrofit2:converter-scalars:2.9.0"
    const val adapterRxjava = "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"

    //okhttp
    private const val okhttp_version = "4.9.1"
    const val okhttp = "com.squareup.okhttp3:okhttp:$okhttp_version"
    const val urlConnection = "com.squareup.okhttp3:okhttp-urlconnection:$okhttp_version"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okhttp_version"

    //用于持久化cookie
    //const val persistentCookieJar = "com.github.franmontiel:PersistentCookieJar:v1.0.1"

    //用于动态替换BaseUrl
    //const val retrofit_url_manager = "me.jessyan:retrofit-url-manager:1.4.0"

    //监听上传下载进度
    //const val progressmanager = "me.jessyan:progressmanager:1.5.0"

    /*******************************网络请求E***********************************/

    /*******************************图片S***********************************/
    //图片加载框架
    private const val glide_version = "4.11.0"
    const val glide = "com.github.bumptech.glide:glide:$glide_version"
    const val compiler = "com.github.bumptech.glide:compiler:$glide_version"
    /*******************************图片E***********************************/

    /*******************************窗口、控件和相关工具***********************************/
    //顶部SnackBar
//    const val topSnackBar = "com.github.PengHaiZhuo:TSnackBar:1.1.1"

    //插入即用的dialog
    //项目地址：https://github.com/afollestad/material-dialogs
    private const val MaterialDialogsversion = "3.3.0"
    const val MaterialDialogscore = "com.afollestad.material-dialogs:core:$MaterialDialogsversion"
    const val MaterialDialoginput = "com.afollestad.material-dialogs:input:$MaterialDialogsversion"
    const val MaterialDialogcolor = "com.afollestad.material-dialogs:color:$MaterialDialogsversion"
    const val MaterialDialogfiles = "com.afollestad.material-dialogs:files:$MaterialDialogsversion"
    const val MaterialDialogdatetime = "com.afollestad.material-dialogs:datetime:$MaterialDialogsversion"
    const val MaterialDialogbottomsheets = "com.afollestad.material-dialogs:bottomsheets:$MaterialDialogsversion"
    const val MaterialDialoglifecycle = "com.afollestad.material-dialogs:lifecycle:$MaterialDialogsversion"

    //轮播图
    const val bannerVp = "com.github.zhpanvip:BannerViewPager:3.1.5"

    //状态栏
    //const val immersionbar = "com.gyf.immersionbar:immersionbar:3.0.0"
    const val immersionbarKtx = "com.gyf.immersionbar:immersionbar-ktx:3.0.0"

    //上下拉刷新
    const val refreshLayoutKernel = "com.scwang.smart:refresh-layout-kernel:2.0.1"
    const val refreshHeader = "com.scwang.smart:refresh-header-classics:2.0.1"

    //RecycleView适配器工具
    const val baseRecycleViewHelper = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.4"
    //官方下拉刷新
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    //带侧滑菜单的列表
    const val xRecycleView = "com.yanzhenjie.recyclerview:x:1.3.2"

    //好用的指示器indicator
    const val magicIndicator = "com.github.hackware1993:MagicIndicator:1.7.0"

    //屏幕适配方案
    const val autoSize = "me.jessyan:autosize:1.2.1"

    //界面ui状态管理
    const val loadSir = "com.kingja.loadsir:loadsir:1.3.8"

    //通过标签直接写shape
    const val backgroundLibrary ="com.noober.background:core:1.6.5"
    /*******************************窗口、控件和相关工具***********************************/

    /*******************************依赖注入***********************************/
    private const val koin_version = "2.2.2"
    val Koincore = "org.koin:koin-core:$koin_version}"
    val Koinandroid = "org.koin:koin-android:$koin_version"
    val KoinandroidxViewModel = "org.koin:koin-androidx-viewmodel:$koin_version"
    val KoinandroidScope = "org.koin:koin-android-scope:$$koin_version"
    val Koinfragment = "org.koin:koin-androidx-fragment:$koin_version"

    /*******************************依赖注入***********************************/

    //常用运行时权限请求管理库
    const val rxPermission="com.github.tbruyelle:rxpermissions:0.12"

    private const val PermissionDispatcherversion= "4.8.0"
    val permissionsdispatcher="com.github.permissions-dispatcher:permissionsdispatcher:$PermissionDispatcherversion"
    //use kapt，not api or implementation
    val PermissionDispatcherprocessor="com.github.permissions-dispatcher:permissionsdispatcher-processor:$PermissionDispatcherversion"

    //常用的工具类
    const val utilcodex = "com.blankj:utilcodex:1.26.0"

    const val logger = "com.orhanobut:logger:2.2.0"

    //微信开源项目，替代SP
    const val mmkv = "com.tencent:mmkv:1.0.22"

    //rxjava3配合RxAndroid
    const val rxjava3 = "io.reactivex.rxjava3:rxjava:3.0.13"
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:3.0.0"

    //用于解决数据倒灌等问题的LiveData
    const val unPeekLivedata = "com.kunminx.arch:unpeek-livedata:6.0.0-beta1"

    //启动优化异步加载
    //const val anchors="com.effective.android:anchors:1.1.1"

    //腾讯bug上报收集
    const val bugly ="com.tencent.bugly:crashreport_upgrade:latest.release"
}