package com.lx.common.utils

/**
 * @title：Unbox
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/06
 */
object Unbox {

    fun unBox(byte: Byte?): Byte {
        return byte ?: 0
    }

    fun unBox(short: Short?): Short {
        return short ?: 0
    }

    fun unBox(box: Int?): Int{
        return box ?: 0
    }

    fun unBox(box: Long?): Long {
        return box ?: 0
    }

    fun unBox(box: Float?): Float {
        return box ?: 0f
    }

    fun unBox(box: Double?): Double {
        return box ?: 0.0
    }

    fun unBox(box: Char?): Char {
        return box ?: ("" as Char)
    }

    fun unBox(box: Boolean?): Boolean {
        return box ?: false
    }

    fun unBox(box: String?): String {
        return box ?: ""
    }

    fun unBoxtoString(box: Int?): String {
        return box.toString()
    }
}