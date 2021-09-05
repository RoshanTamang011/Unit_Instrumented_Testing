package com.example.unit_instrumented_testing

import junit.framework.TestCase
import org.junit.Test

class ArithmeticTest {

    @Test
    fun testAddition() {
        val arithmetic = Arithmetic()
        val expectedResult = 10f
        val actualResult = arithmetic.add(4F, 6F)
        TestCase.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun testAddition1() {
        val arithmetic = Arithmetic()
        val expectedResult = 10f
        val actualResult = arithmetic.add(4F, 6F)
        TestCase.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun testSubtraction() {
        val arithmetic = Arithmetic()
        val expectedResult = 10f
        val actualResult = arithmetic.subtract(4F, 6F)
        TestCase.assertEquals(expectedResult, actualResult)
    }
}