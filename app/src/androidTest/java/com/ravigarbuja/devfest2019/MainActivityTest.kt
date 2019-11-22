package com.ravigarbuja.devfest2019

import androidx.test.espresso.Espresso.onView
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

    val invalidEmail1 = "test@tes"
    val invalidEmail2 = "test@tes."
    val invalidEmail3 = "test"
    val validEmail = "test@test.com"
    
    val shortPassword = "short"
    val validPassword = "not_so_short_now"

    @get:Rule
    val activityRule =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun noInput_activityLaunched_LoginButtonDisabled(){
        //not is actually from Hamcrest
        onView(withId(R.id.btn_login)).check(matches(not(isEnabled())))
    }

    @Test
    fun emptyEmail_startWritingEmail_invalidateEmailField(){
        onView(withId(R.id.et_email))
            .perform(typeText(invalidEmail1))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_email))))
    }

    @Test
    fun noInputs_writeInvalidEmail2_invalidateEmailField(){
        onView(withId(R.id.et_email))
            .perform(typeText(invalidEmail2))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_email))))
    }

    @Test
    fun noInputs_writeInvalidEmail3_invalidateEmailField(){
        onView(withId(R.id.et_email))
            .perform(typeText(invalidEmail3))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_email))))
    }

    @Test
    fun noEmail_typeValidEmail_validateEmailField(){
        onView(withId(R.id.et_email))
            .perform(typeText(validEmail))
            .check(matches(not(hasErrorText(activityRule.activity.getString(R.string.invalid_email)))))
    }

    @Test
    fun noInput_typeInvalidPassword_invalidatePasswordField(){
        onView(withId(R.id.et_password))
            .perform(typeText(shortPassword))
            .check(matches(hasErrorText(activityRule.activity.getString(R.string.invalid_password))))
    }

    @Test
    fun noInput_typeValidPassword_validatePasswordField(){
        onView(withId(R.id.et_password))
            .perform(typeText(validPassword))
            .check(matches(not(hasErrorText(activityRule.activity.getString(R.string.invalid_password)))))
    }

    /**
     * Test for login button state on different inputs
     */
    @Test
    fun validEmail_InvalidPassword_loginButtonDisabled(){
        onView(withId(R.id.et_email))
            .perform(typeText(validEmail))
        
        onView(withId(R.id.et_password))
            .perform(typeText(shortPassword))
        
        onView(withId(R.id.btn_login))
            .check(matches(not(isEnabled())))
    }

    @Test
    fun inValidEmail_ValidPassword_loginButtonDisabled(){
        onView(withId(R.id.et_email))
            .perform(typeText(invalidEmail1))

        onView(withId(R.id.et_password))
            .perform(typeText(validPassword))
            .check(matches(not(hasErrorText(activityRule.activity.getString(R.string.invalid_password)))))

        onView(withId(R.id.btn_login))
            .check(matches(not(isEnabled())))
    }

    /**
     * Finally
     * Check if the login button is enabled if email and password are both validated
     */
    @Test
    fun validEmail_validPassword_loginButtonEnabled(){
        onView(withId(R.id.et_email))
            .perform(typeText(validEmail))

        onView(withId(R.id.et_password))
            .perform(typeText(validPassword))

        onView(withId(R.id.btn_login))
            .check(matches(isEnabled()))
    }
}