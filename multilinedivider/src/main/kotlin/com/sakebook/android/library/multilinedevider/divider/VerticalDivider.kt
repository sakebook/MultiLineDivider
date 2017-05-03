package com.sakebook.android.library.multilinedevider.divider

import android.support.v4.util.Pair

/**
 * Created by sakemotoshinya on 2017/04/24.
 */
interface VerticalDivider: Divider {
    val height: Int
    val drawableRes: Int
    val verticalInset: Pair<Int, Int>?
}