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

    internal fun determineVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
        when(vh) {
            is NoDivider -> outRect.set(0, 0, 0, 0)
            is GridDivider -> gridVerticalOffsets(outRect, vh, spanCount, itemCount)
            is VerticalDivider -> dividerVerticalOffsets(outRect, vh)
            is PositionDivider -> positionVerticalOffsets(outRect, vh)
            else -> outRect.set(0, 0, 0, divider.intrinsicHeight)
        }
    }

    internal fun determineHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
        when(vh) {
            is NoDivider -> outRect.set(0, 0, 0, 0)
            is GridDivider -> gridHorizontalOffsets(outRect, vh, spanCount, itemCount)
            is HorizontalDivider -> dividerHorizontalOffsets(outRect, vh)
            is PositionDivider -> positionHorizontalOffsets(outRect, vh)
            else -> outRect.set(0, 0, divider.intrinsicWidth, 0)
        }
    }

    private fun gridVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
        vh as GridDivider
        val padding = vh.padding / 2
        val lastGridCount = if (itemCount % spanCount == 0) spanCount else itemCount % spanCount
        val cornerPadding = if (vh.fullBleed) 0 else vh.padding
        val position = vh.adapterPosition
        when(position) {
            in 0 until spanCount -> {
                // first grid
                when(position % spanCount) {
                    0 -> outRect.set(cornerPadding, cornerPadding, padding, padding) // left top
                    spanCount - 1 -> outRect.set(padding, cornerPadding, cornerPadding, padding) // right top, top bottom
                    else -> outRect.set(padding, cornerPadding, padding, padding) // other
                }
            }
            in (itemCount - lastGridCount until itemCount) -> {
                // last grid
                when(position % spanCount) {
                    0 -> outRect.set(cornerPadding, padding, padding, cornerPadding) // left bottom
                    spanCount - 1 -> outRect.set(padding, padding, cornerPadding, cornerPadding) // right bottom, bottom right
                    else -> outRect.set(padding, padding, padding, cornerPadding) // other
                }
            }
            else -> {
                when(position % spanCount) {
                    0 -> outRect.set(cornerPadding, padding, padding, padding) // left
                    spanCount - 1 -> outRect.set(padding, padding, cornerPadding, padding) // right
                    else -> outRect.set(padding, padding, padding, padding) // other
                }
            }
        }
    }

    private fun gridHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder, spanCount: Int, itemCount: Int) {
        vh as GridDivider
        val padding = vh.padding / 2
        val lastGridCount = if (itemCount % spanCount == 0) spanCount else itemCount % spanCount
        val cornerPadding = if (vh.fullBleed) 0 else vh.padding
        val position = vh.adapterPosition
        when(position) {
            in 0 until spanCount -> {
                // first grid
                when(position % spanCount) {
                    0 -> outRect.set(cornerPadding, cornerPadding, padding, padding) // top left
                    spanCount - 1 -> outRect.set(cornerPadding, padding, padding, cornerPadding) // right top, top bottom
                    else -> outRect.set(cornerPadding, padding, padding, padding) // other
                }
            }
            in (itemCount - lastGridCount until itemCount) -> {
                // last grid
                when(position % spanCount) {
                    0 -> outRect.set(padding, cornerPadding, cornerPadding, padding) // bottom left
                    spanCount - 1 -> outRect.set(padding, padding, cornerPadding, cornerPadding) // right bottom, bottom right
                    else -> outRect.set(padding, padding, cornerPadding, padding) // other
                }
            }
            else -> {
                when(position % spanCount) {
                    0 -> outRect.set(padding, cornerPadding, padding, padding) // top
                    spanCount - 1 -> outRect.set(padding, padding, padding, cornerPadding) // bottom
                    else -> outRect.set(padding, padding, padding, padding) // other
                }
            }
        }
    }

    private fun dividerVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
        vh as VerticalDivider
        val position = vh.adapterPosition
        when(vh is PositionDivider){
            true -> {
                vh as PositionDivider
                when(vh.positions.any { it == position }) {
                    true -> outRect.set(0, 0, 0, if (vh.inverted) vh.height else 0)
                    false -> outRect.set(0, 0, 0, if (vh.inverted) 0 else vh.height)
                }
            }
            false -> outRect.set(0, 0, 0, vh.height)
        }
    }

    private fun dividerHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
        vh as HorizontalDivider
        val position = vh.adapterPosition
        when(vh is PositionDivider){
            true -> {
                vh as PositionDivider
                when(vh.positions.any { it == position }) {
                    true -> outRect.set(0, 0, if (vh.inverted) vh.width else 0, 0)
                    false -> outRect.set(0, 0, if (vh.inverted) 0 else vh.width, 0)
                }
            }
            false -> outRect.set(0, 0, vh.width, 0)
        }
    }

    private fun positionVerticalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
        vh as PositionDivider
        val position = vh.adapterPosition
        when(vh.positions.any { it == position }) {
            true -> outRect.set(0, 0, 0, if (vh.inverted) divider.intrinsicHeight else 0)
            false -> outRect.set(0, 0, 0, if (vh.inverted) 0 else divider.intrinsicHeight)
        }
    }

    private fun positionHorizontalOffsets(outRect: Rect, vh: RecyclerView.ViewHolder) {
        vh as PositionDivider
        val position = vh.adapterPosition
        when(vh.positions.any { it == position }) {
            true -> outRect.set(0, 0, if (vh.inverted) divider.intrinsicWidth else 0, 0)
            false -> outRect.set(0, 0, if (vh.inverted) 0 else divider.intrinsicWidth, 0)
        }
    }
}