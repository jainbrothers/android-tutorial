package com.example.tipcalculator

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class MainActivityTest {
    @Test
    fun test_calculateTip_without_roundup() {
        val amount = "50".toDouble()
        val tipPercent = "10".toDouble()

        val tipAmount = calculateTip(amount, tipPercent)

        assertEquals(tipAmount, NumberFormat.getCurrencyInstance().format("5".toDouble()))
    }

    @Test
    fun test_calculateTip_roundup() {
        val amount = "50".toDouble()
        val tipPercent = "5".toDouble()

        val tipAmount = calculateTip(amount, tipPercent, isRoundUp = true)

        assertEquals(tipAmount, NumberFormat.getCurrencyInstance().format("3".toDouble()))
    }


}