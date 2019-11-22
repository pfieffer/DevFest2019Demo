package com.ravigarbuja.devfest2019

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
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

    val invalidEmail = "test@tes"

    @get:Rule
    val activityRule =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun noInput_activityLaunched_LoginButtonDisabled(){
        //not is actually from Hamcrest
        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())))
    }

    @Test
    fun emptyEmail_startWritingEmail_validateEmailField(){
        onView(withId(R.id.et_email))
            .perform(replaceText(invalidEmail))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_email))))
    }

}