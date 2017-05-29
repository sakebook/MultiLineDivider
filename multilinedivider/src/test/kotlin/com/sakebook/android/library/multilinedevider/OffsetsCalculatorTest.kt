package com.sakebook.android.library.multilinedevider

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import com.sakebook.android.library.multilinedevider.divider.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by sakemotoshinya on 2017/05/24.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
class OffsetsCalculatorTest {

    val PADDING = 8
    val PADDINGx2 = PADDING * 2
    val PADDINGx3 = PADDING * 3
    val PADDINGx4 = PADDING * 4
    val PADDINGx5 = PADDING * 5
    val PADDINGx6 = PADDING * 6

    val mockDrawable = Mockito.mock(Drawable::class.java).also {
        Mockito.`when`(it.intrinsicHeight).thenReturn(PADDING)
        Mockito.`when`(it.intrinsicWidth).thenReturn(PADDING)
    }
    val context = RuntimeEnvironment.application

    @Before
    @Throws(Exception::class)
    fun setup() {
    }

    // GridDivider

    @Test
    @Throws(Exception::class)
    fun testVerticalGridFirst() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.VERTICAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, false)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1, 2, 3, 4, 5)
        val expectTopLeft = Rect(PADDINGx6, PADDINGx6, PADDINGx3, PADDINGx3)
        val expectTopCenter = Rect(PADDINGx3, PADDINGx6, PADDINGx3, PADDINGx3)
        val expectTopRight = Rect(PADDINGx3, PADDINGx6, PADDINGx6, PADDINGx3)
        val expectLeft = Rect(PADDINGx6, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectRight = Rect(PADDINGx3, PADDINGx3, PADDINGx6, PADDINGx3)
        val actual = Rect()

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTopLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTopCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTopRight, actual)

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRight, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testVerticalGridLast() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.VERTICAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, false)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(114, 115, 116, 117, 118, 119)
        val expectLeft = Rect(PADDINGx6, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectRight = Rect(PADDINGx3, PADDINGx3, PADDINGx6, PADDINGx3)
        val expectBottomLeft = Rect(PADDINGx6, PADDINGx3, PADDINGx3, PADDINGx6)
        val expectBottomCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx6)
        val expectBottomRight = Rect(PADDINGx3, PADDINGx3, PADDINGx6, PADDINGx6)
        val actual = Rect()

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRight, actual)

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottomLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottomCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottomRight, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testHorizontalGridFirst() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.HORIZONTAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, false)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1, 2, 3, 4, 5)
        val expectLeftTop = Rect(PADDINGx6, PADDINGx6, PADDINGx3, PADDINGx3)
        val expectLeftCenter = Rect(PADDINGx6, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectLeftBottom = Rect(PADDINGx6, PADDINGx3, PADDINGx3, PADDINGx6)
        val expectTop = Rect(PADDINGx3, PADDINGx6, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectBottom = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx6)
        val actual = Rect()

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeftTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeftCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeftBottom, actual)

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottom, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testHorizontalGridLast() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.HORIZONTAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, false)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(114, 115, 116, 117, 118, 119)
        val expectTop = Rect(PADDINGx3, PADDINGx6, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectBottom = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx6)
        val expectRightTop = Rect(PADDINGx3, PADDINGx6, PADDINGx6, PADDINGx3)
        val expectRightCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx6, PADDINGx3)
        val expectRightBottom = Rect(PADDINGx3, PADDINGx3, PADDINGx6, PADDINGx6)
        val actual = Rect()

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottom, actual)

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRightTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRightCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRightBottom, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testVerticalFullBleedGridFirst() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.VERTICAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, true)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1, 2, 3, 4, 5)
        val expectTopLeft = Rect(0, 0, PADDINGx3, PADDINGx3)
        val expectTopCenter = Rect(PADDINGx3, 0, PADDINGx3, PADDINGx3)
        val expectTopRight = Rect(PADDINGx3, 0, 0, PADDINGx3)
        val expectLeft = Rect(0, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectRight = Rect(PADDINGx3, PADDINGx3, 0, PADDINGx3)
        val actual = Rect()

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTopLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTopCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTopRight, actual)

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRight, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testVerticalFullBleedGridLast() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.VERTICAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, true)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(114, 115, 116, 117, 118, 119)
        val expectLeft = Rect(0, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectRight = Rect(PADDINGx3, PADDINGx3, 0, PADDINGx3)
        val expectBottomLeft = Rect(0, PADDINGx3, PADDINGx3, 0)
        val expectBottomCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, 0)
        val expectBottomRight = Rect(PADDINGx3, PADDINGx3, 0, 0)
        val actual = Rect()

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRight, actual)

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottomLeft, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottomCenter, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottomRight, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testHorizontalFullBleedGridFirst() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.HORIZONTAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, true)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1, 2, 3, 4, 5)
        val expectLeftTop = Rect(0, 0, PADDINGx3, PADDINGx3)
        val expectLeftCenter = Rect(0, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectLeftBottom = Rect(0, PADDINGx3, PADDINGx3, 0)
        val expectTop = Rect(PADDINGx3, 0, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectBottom = Rect(PADDINGx3, PADDINGx3, PADDINGx3, 0)
        val actual = Rect()

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeftTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeftCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectLeftBottom, actual)

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottom, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testHorizontalFullBleedGridLast() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.HORIZONTAL)
        val view = View(context)
        val vh = GridViewHolder(view, PADDINGx6, true)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(114, 115, 116, 117, 118, 119)
        val expectTop = Rect(PADDINGx3, 0, PADDINGx3, PADDINGx3)
        val expectCenter = Rect(PADDINGx3, PADDINGx3, PADDINGx3, PADDINGx3)
        val expectBottom = Rect(PADDINGx3, PADDINGx3, PADDINGx3, 0)
        val expectRightTop = Rect(PADDINGx3, 0, 0, PADDINGx3)
        val expectRightCenter = Rect(PADDINGx3, PADDINGx3, 0, PADDINGx3)
        val expectRightBottom = Rect(PADDINGx3, PADDINGx3, 0, 0)
        val actual = Rect()

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectBottom, actual)

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRightTop, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRightCenter, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, 3, 120)
        Assert.assertEquals(expectRightBottom, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testVerticalPosition() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.VERTICAL)
        val view = View(context)
        val vh = PositionViewHolder(view, listOf(2, 3, 5), false)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1 ,2 ,3, 4, 5)
        val expectDivider = Rect(0, 0, 0, PADDING)
        val expectNoDivider = Rect(0, 0, 0, 0)
        val actual = Rect()

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testHorizontalPosition() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.HORIZONTAL)
        val view = View(context)
        val vh = PositionViewHolder(view, listOf(2, 3, 5), false)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1 ,2 ,3, 4, 5)
        val expectDivider = Rect(0, 0, PADDING, 0)
        val expectNoDivider = Rect(0, 0, 0, 0)
        val actual = Rect()

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testVerticalPositionInverted() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.VERTICAL)
        val view = View(context)
        val vh = PositionViewHolder(view, listOf(2, 3, 5), true)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1 ,2 ,3, 4, 5)
        val expectDivider = Rect(0, 0, 0, PADDING)
        val expectNoDivider = Rect(0, 0, 0, 0)
        val actual = Rect()

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testHorizontalPositionInverted() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.HORIZONTAL)
        val view = View(context)
        val vh = PositionViewHolder(view, listOf(2, 3, 5), true)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1 ,2 ,3, 4, 5)
        val expectDivider = Rect(0, 0, PADDING, 0)
        val expectNoDivider = Rect(0, 0, 0, 0)
        val actual = Rect()

        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectNoDivider, actual)
        offsetCalculator.determineHorizontalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
    }

    @Test
    @Throws(Exception::class)
    fun testVertical() {
        val offsetCalculator = OffsetsCalculator(mockDrawable, MultiLineDivider.VERTICAL)
        val view = View(context)
        val vh = VerticalViewHolder(view, PADDINGx3, R.drawable.simple_divider, null)
        val mockViewHolder = Mockito.spy(vh)
        Mockito.`when`(mockViewHolder.adapterPosition).thenReturn(0, 1 ,2)
        val expectDivider = Rect(0, 0, 0, PADDINGx3)
        val actual = Rect()

        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)
        offsetCalculator.determineVerticalOffsets(actual, mockViewHolder, -1, 120)
        Assert.assertEquals(expectDivider, actual)

    }

    class GridViewHolder(view: View, override val padding: Int, override val fullBleed: Boolean) : RecyclerView.ViewHolder(view), GridDivider
    class PositionViewHolder(view: View, override val positions: List<Int>, override val inverted: Boolean) : RecyclerView.ViewHolder(view), PositionDivider
    class VerticalViewHolder(view: View, override val height: Int, override val drawableRes: Int, override val verticalInset: Pair<Int, Int>?) : RecyclerView.ViewHolder(view), VerticalDivider
    class HorizontalViewHolder(view: View, override val width: Int, override val drawableRes: Int, override val horizontalInset: Pair<Int, Int>?) : RecyclerView.ViewHolder(view), HorizontalDivider
    class NoDividerViewHolder(view: View): RecyclerView.ViewHolder(view), NoDivider
}