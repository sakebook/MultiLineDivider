package com.sakebook.android.library.multilinedevider

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.util.SimpleArrayMap
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.sakebook.android.library.multilinedevider.divider.Divider

/**
 * Created by sakemotoshinya on 2017/04/24.
 */
class MultiLineDivider(context: Context, val orientation: Int): RecyclerView.ItemDecoration() {

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

    private fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        // TODO
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