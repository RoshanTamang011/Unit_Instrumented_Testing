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

class TestSumFragment {
    val a = 3

    @Rule
    //JUnit rules provide more flexibility and reduce the boilerplate code required in tests.
    @JvmField
    //The @JvmField annotation makes it possible to achieve compatibility between the two languages.
    var testRule = ActivityTestRule(LoadFragmentActivity::class.java)

    // Loading fragment
    @Before
    fun setUp() {
        testRule.activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.parentLayout, SumFragment())
            addToBackStack(null)
            commit()
        }
    }

    @Test
    fun testMultiply() {

        Espresso.onView(ViewMatchers.withId(R.id.etFirstF))
            .perform(ViewActions.typeText("12"))

        // Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.etSecondF))
            .perform(ViewActions.typeText("12"))

        Espresso.onView(ViewMatchers.withId(R.id.btnSumF))
            .perform(ViewActions.click())

        // Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.tvResultF))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}