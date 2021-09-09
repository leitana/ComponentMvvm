package com.lx.common.ext

import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.lx.common.R

/**
 * @title：MaterialDialogExt
 * @projectName Szt
 * @description: <Description>
 * @author linxiao
 * @data Created in 2021/05/19
 */
fun MaterialDialog.getTitleView(): TextView{
    return view.titleLayout.findViewById(R.id.md_text_title)
}