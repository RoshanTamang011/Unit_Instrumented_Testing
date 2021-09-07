package com.example.unit_instrumented_testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith

class ArithmeticInstrumentedTest {

    val a = 3
    @Rule
    @JvmField
    val testRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testArithmetic(){
        onView(withId(R.id.etFirst))
            .perform(ViewActions.typeText("12"))

        Thread.sleep(1000)
        onView(withId(R.id.etSecond))
            .perform(ViewActions.typeText("12"))

        onView(withId(R.id.btnSum))
            .perform(click())

        Thread.sleep(1000)


        onView(withId(R.id.tvOutput))
            .check(matches(isDisplayed()))

    }

}