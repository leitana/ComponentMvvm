/**
 * @author linxiao
 * @introduction 协程等kotlin内部使用类
 */
@SuppressWarnings("SpellCheckingInspection")
object Kotlin {
    //Kotlin 1.4 以后，您不再需要在 gradle 上声明 stdlib
    var stdlib ="org.jetbrains.kotlin:kotlin-stdlib:${BuildConfig.kotlin_version}"
    val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildConfig.kotlin_version}"
    val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${BuildConfig.kotlin_version}"
    val test = "org.jetbrains.kotlin:kotlin-test-junit:${BuildConfig.kotlin_version}"
    val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildConfig.kotlin_version}"

    //协程
    private const val Coroutinesversion = "1.4.3"
    const val Coroutinescore ="org.jetbrains.kotlinx:kotlinx-coroutines-core:$Coroutinesversion"
    const val Coroutinesandroid ="org.jetbrains.kotlinx:kotlinx-coroutines-android:$Coroutinesversion"
}