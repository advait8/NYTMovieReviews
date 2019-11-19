package com.advait.opentableproject.nytmoviereviews

import com.advait.opentableproject.nytmoviereviews.view.ui.MainActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class MainActivityTest {
    private lateinit var mainActivity: MainActivity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mainActivity = Robolectric.buildActivity<MainActivity>(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun shouldNotBeNull() {
        Assert.assertNotNull(mainActivity)
    }
}