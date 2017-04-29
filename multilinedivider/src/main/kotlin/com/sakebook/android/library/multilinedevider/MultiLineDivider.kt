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
import com.sakebook.android.library.multilinedevider.divider.HorizontalDivider
import com.sakebook.android.library.multilinedevider.divider.NoDivider
import com.sakebook.android.library.multilinedevider.divider.VerticalDivider

/**
 * Created by sakemotoshinya on 2017/04/24.
 */
class MultiLineDivider(val context: Context, val orientation: Int = VERTICAL): RecyclerView.ItemDecoration() {

    private var drawable: Drawable? = null
    private val defaultDivider: Drawable by lazy { createDivider(context, divider = drawable) }
    private val dividerMap: SimpleArrayMap<Divider, Drawable> = SimpleArrayMap()
    private val bounds = Rect()

    constructor(context: Context, orientation: Int = VERTICAL, divider: Drawable) : this(context, orientation) {
        drawable = divider
    }

    private fun createDivider(context: Context, divider: Drawable?): Drawable {
        return divider?.let {
            it
        }?: context.obtainStyledAttributes(ATTRS).run {
            this.getDrawable(0).apply {
                this@run.recycle()
            }
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        parent.layoutManager ?: return
        when(orientation) {
            VERTICAL -> drawVertical(c, parent)
            HORIZONTAL -> drawHorizontal(c, parent)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val vh = parent.getChildViewHolder(view)
        when(orientation) {
            VERTICAL -> {
                when(vh) {
                    is NoDivider -> outRect.set(0, 0, 0, 0)
                    is VerticalDivider -> outRect.set(0, 0, 0, vh.height)
                    else -> outRect.set(0, 0, 0, defaultDivider.intrinsicHeight)
                }
            }
            HORIZONTAL -> {
                when(vh) {
                    is NoDivider -> outRect.set(0, 0, 0, 0)
                    is HorizontalDivider -> outRect.set(0, 0, vh.width, 0)
                    else -> outRect.set(0, 0, defaultDivider.intrinsicWidth, 0)
                }
            }
        }
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

    @SuppressLint("NewApi")
    private fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {
        val top: Int
        val bottom: Int
        if (parent.clipToPadding) {
            top = parent.paddingTop
            bottom = parent.height - parent.paddingBottom
            canvas.clipRect(parent.paddingLeft, top,
                    parent.width - parent.paddingRight, bottom)
        } else {
            top = 0
            bottom = parent.height
        }

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            parent.layoutManager.getDecoratedBoundsWithMargins(child, bounds)
            val right = bounds.right + Math.round(ViewCompat.getTranslationX(child))

            val vh = parent.getChildViewHolder(child)
            when(vh) {
                is NoDivider -> {}
                is HorizontalDivider -> {
                    val drawable = dividerMap[vh]?: // Reuse divider
                            ResourcesCompat.getDrawable(context.resources, vh.drawableRes, null)?.let {
                                dividerMap.put(vh, it)
                            }
                    val left = right - (vh.width + 1) // Line width < Bounds width
                    drawable?.setBounds(left, top, right, bottom)
                    drawable?.draw(canvas)
                }
                else -> {
                    val left = right - defaultDivider.intrinsicWidth
                    defaultDivider.setBounds(left, top, right, bottom)
                    defaultDivider.draw(canvas)
                }
            }
        }
    }

    companion object {
        val HORIZONTAL = LinearLayout.HORIZONTAL
        val VERTICAL = LinearLayout.VERTICAL

        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }

}