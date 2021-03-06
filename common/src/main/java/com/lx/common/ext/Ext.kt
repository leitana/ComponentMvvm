package com.lx.common.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.lx.common.R
import kotlin.reflect.KClass

/**
 * @title：Ext
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */

fun <T : Activity> Activity.startActivity(clazz: KClass<T>, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(this, clazz.java).apply {
        block?.invoke(this)
    }
    startActivity(intent)
}

fun <T : Activity> Fragment.startActivity(clazz: KClass<T>, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(activity, clazz.java).apply {
        block?.invoke(this)
    }
    startActivity(intent)
}
fun Fragment.showToast(string: String){
    Toast.makeText(this.activity, string, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

fun Activity.showSnackMsg(msg: String){
    val snackbar = Snackbar.make(this.window.decorView, msg, Snackbar.LENGTH_SHORT)
    val view = snackbar.view
    view.findViewById<TextView>(R.id.snackbar_text).setTextColor(ContextCompat.getColor(this, R.color.white))
    snackbar.show()
}

fun Fragment.showSnackMsg(msg: String) {
    this.activity ?: return
    val snackbar = Snackbar.make(this.requireActivity().window.decorView, msg, Snackbar.LENGTH_SHORT)
    val view = snackbar.view
    view.findViewById<TextView>(R.id.snackbar_text).setTextColor(ContextCompat.getColor(this.requireActivity(), R.color.white))
    snackbar.show()
}

fun Int.getTime(): String {
    var min = 0
    var second = 0
    var minStr: StringBuilder = StringBuilder("00")
    var secondStr: StringBuilder = StringBuilder("00")
    min = this / 1000 / 60
    second = this / 1000 % 60
    minStr = if (min < 10) {
        StringBuilder("0").append(min)
    } else {
        StringBuilder(min.toString())
    }
    secondStr = if (second < 10) {
        StringBuilder("0").append(second)
    } else {
        StringBuilder(second.toString())
    }
    return minStr.append(":").append(secondStr).toString()
}

/**
 * 截取前面的路径
 */
fun String.getPrefixPath(): String{
    val lastIndex = this.lastIndexOf("/")
    return this.substring(0, lastIndex + 1)
}