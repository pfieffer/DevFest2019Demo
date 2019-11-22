package com.ravigarbuja.devfest2019

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get:Rule
    val activityRule =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun noInput_activityLaunched_LoginButtonDisabled(){
        //not is actually from Hamcrest
        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())))
    }

}