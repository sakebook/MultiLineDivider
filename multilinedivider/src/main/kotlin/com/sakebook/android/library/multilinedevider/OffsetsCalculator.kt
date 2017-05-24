package com.sakebook.android.library.multilinedevider

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.sakebook.android.library.multilinedevider.divider.*

/**
 * Created by sakemotoshinya on 2017/05/23.
 */
class OffsetsCalculator(val divider: Drawable, val orientation: Int) {

    fun determineOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, parent: RecyclerView) {
        val layoutManager = parent.layoutManager
        val spanCount = when(layoutManager) {
            is GridLayoutManager -> layoutManager.spanCount
            is StaggeredGridLayoutManager -> layoutManager.spanCount
            else -> -1
        }
        when(orientation) {
            MultiLineDivider.VERTICAL -> determineVerticalOffsets(outRect, vh, spanCount, layoutManager.itemCount)
            MultiLineDivider.HORIZONTAL -> determineHorizontalOffsets(outRect, vh, spanCount, layoutManager.itemCount)
        }
    }

    private fun determineVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
        when(vh) {
            is NoDivider -> outRect.set(0, 0, 0, 0)
            is GridDivider -> gridVerticalOffsets(outRect, vh, spanCount, itemCount)
            is VerticalDivider -> dividerVerticalOffsets(outRect, vh)
            is PositionDivider -> positionVerticalOffsets(outRect, vh)
            else -> outRect.set(0, 0, 0, divider.intrinsicHeight)
        }
    }

    private fun determineHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
        when(vh) {
            is NoDivider -> outRect.set(0, 0, 0, 0)
            is GridDivider -> gridHorizontalOffsets(outRect, vh, spanCount, itemCount)
            is HorizontalDivider -> dividerHorizontalOffsets(outRect, vh)
            is PositionDivider -> positionHorizontalOffsets(outRect, vh)
            else -> outRect.set(0, 0, divider.intrinsicWidth, 0)
        }
    }

    internal fun gridVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
    }

    internal fun gridHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
    }

    internal fun dividerVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
    }

    internal fun dividerHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
    }

    internal fun positionVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
        vh as PositionDivider
        when(vh.positions.any { it == vh.adapterPosition }) {
            true -> outRect.set(0, 0, 0, if (vh.inverted) divider.intrinsicHeight else 0)
            false -> outRect.set(0, 0, 0, if (vh.inverted) 0 else divider.intrinsicHeight)
        }
    }
    internal fun positionHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
        vh as PositionDivider
        when(vh.positions.any { it == vh.adapterPosition }) {
            true -> outRect.set(0, 0, if (vh.inverted) divider.intrinsicWidth else 0, 0)
            false -> outRect.set(0, 0, if (vh.inverted) 0 else divider.intrinsicWidth, 0)
        }
    }
}