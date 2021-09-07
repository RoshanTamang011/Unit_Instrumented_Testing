package com.example.unit_instrumented_testing

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.example.unit_instrumented_testing.fragment.MultiplyFragment
import com.example.unit_instrumented_testing.fragment.SumFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FragmentTest {
    val a = 3

    @Rule
    @JvmField
    var testRule = ActivityTestRule(LoadFragmentActivity::class.java)

    // Loading fragment
    @Before
    fun setUp() {
        testRule.activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.parentLayout, MultiplyFragment())
            addToBackStack(null)
            commit()
        }
    }

    @Test
    fun testMultiply() {

        Espresso.onView(ViewMatchers.withId(R.id.etFirstM))
            .perform(ViewActions.typeText("12"))

        // Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.etSecondM))
            .perform(ViewActions.typeText("12"))

        Espresso.onView(ViewMatchers.withId(R.id.btnMultiplyM))
            .perform(ViewActions.click())

        // Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.tvResultM))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}