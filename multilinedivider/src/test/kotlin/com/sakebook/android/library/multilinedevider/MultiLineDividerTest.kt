package com.sakebook.android.library.multilinedevider

import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by sakemotoshinya on 2017/05/22.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class MultiLineDividerTest {

    val application = RuntimeEnvironment.application!!

    @Before
    @Throws(Exception::class)
    fun setup() {
    }

    @Test
    @Throws(Exception::class)
    fun test_sample() {
        val multiLineDivider = MultiLineDivider(application, LinearLayout.VERTICAL)
        val vh = Mockito.mock(RecyclerView.ViewHolder::class.java)
        Mockito.`when`(vh.adapterPosition).thenReturn(10)
        Assert.assertEquals(14, (2 + 2 + vh.adapterPosition).toLong())
    }
}