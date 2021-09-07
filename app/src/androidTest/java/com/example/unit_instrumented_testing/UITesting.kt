package com.example.unit_instrumented_testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class UITesting {
    val a = 3
    @Rule
    @JvmField
    val mainActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkArithmeticUI(){
        onView(withId(R.id.etFirst))
            .perform(typeText("8"))

        onView(withId(R.id.etSecond))
            .perform(typeText("2"))

        onView(withId(R.id.btnSum))
            .perform(click())

        Thread.sleep(1000)
        onView(withId(R.id.tvOutput))
//            .check(matches(withText("Result is : 4.0")))
            .check(matches(isDisplayed()))


    }
}