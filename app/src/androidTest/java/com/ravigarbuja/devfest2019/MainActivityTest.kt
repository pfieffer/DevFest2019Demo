package com.ravigarbuja.devfest2019

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
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

    val invalidEmail1 = "test@tes"
    val invalidEmail2 = "test@tes."
    val invalidEmail3 = "test"
    val validEmail = "test@test.com"

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
            .perform(replaceText(invalidEmail1))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_email))))
    }

    @Test
    fun invalidEmail_writeEmail_invalidateEmailField(){
        onView(withId(R.id.et_email))
            .perform(replaceText(invalidEmail2))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_email))))
        onView(withId(R.id.et_email))
            .perform(replaceText(invalidEmail3))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_email))))
    }

    @Test
    fun noEmail_typeValidEmail_validateEmailField(){
        onView(withId(R.id.et_email))
            .perform(replaceText(validEmail))
            .check(matches(not(hasErrorText(activityRule.activity.getString(R.string.invalid_email)))))
    }

}