package com.sakebook.android.library.multilinedevider.divider

import android.support.v4.util.Pair

/**
 * Created by sakemotoshinya on 2017/04/24.
 */
interface HorizontalDivider: Divider {
    val width: Int
    val drawableRes: Int
    val offset: Pair<Int, Int>?
}