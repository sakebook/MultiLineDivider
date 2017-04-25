package com.sakebook.android.library.multilinedevider

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.util.SimpleArrayMap
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.sakebook.android.library.multilinedevider.divider.Divider
import com.sakebook.android.library.multilinedevider.divider.NoDivider
import com.sakebook.android.library.multilinedevider.divider.VerticalDivider

/**
 * Created by sakemotoshinya on 2017/04/24.
 */
class MultiLineDivider(val context: Context, val orientation: Int): RecyclerView.ItemDecoration() {

    private val defaultDivider: Drawable
    private val dividerMap: SimpleArrayMap<Divider, Drawable> = SimpleArrayMap()
    private val bounds = Rect()

    init {
        val a = context.obtainStyledAttributes(ATTRS)
        defaultDivider = a.getDrawable(0)
        a.recycle()
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        parent.layoutManager ?: return
        when(orientation) {
            VERTICAL -> drawVertical(c, parent)
            HORIZONTAL -> drawHorizontal(c, parent)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        when(orientation) {
            VERTICAL -> {}
            HORIZONTAL -> {}
        }
        // TODO
    }

    @SuppressLint("NewApi")
    private fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        val left: Int
        val right: Int
        if (parent.clipToPadding) {
            left = parent.paddingLeft
            right = parent.width - parent.paddingRight
            canvas.clipRect(left, parent.paddingTop, right,
                    parent.height - parent.paddingBottom)
        } else {
            left = 0
            right = parent.width
        }

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            parent.getDecoratedBoundsWithMargins(child, bounds)
            val bottom = bounds.bottom + Math.round(ViewCompat.getTranslationY(child))

            val vh = parent.getChildViewHolder(child)
            when(vh) {
                is NoDivider -> {}
                is VerticalDivider -> {
                    val drawable = dividerMap[vh]?: // Reuse divider
                            ResourcesCompat.getDrawable(context.resources, vh.drawableRes, null)?.let {
                                dividerMap.put(vh, it)
                            }
                    val top = bottom - (vh.height + 1) // Line height < Bounds height
                    drawable?.setBounds(left, top, right, bottom)
                    drawable?.draw(canvas)
                }
                else -> {
                    val top = bottom - defaultDivider.intrinsicHeight
                    defaultDivider.setBounds(left, top, right, bottom)
                    defaultDivider.draw(canvas)
                }
            }
        }
    }

    private fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {
        // TODO
    }

    companion object {
        val HORIZONTAL = LinearLayout.HORIZONTAL
        val VERTICAL = LinearLayout.VERTICAL

        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }

}