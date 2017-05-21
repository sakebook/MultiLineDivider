package com.sakebook.android.library.multilinedevider.divider

/**
 * Created by sakemotoshinya on 2017/05/21.
 */
interface PositionDivider: Divider {
    val positions: List<Int>
    val inverted: Boolean
}