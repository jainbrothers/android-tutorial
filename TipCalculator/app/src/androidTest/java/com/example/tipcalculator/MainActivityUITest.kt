package com.example.tipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class MainActivityUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_tip_page() {
        composeTestRule.setContent { 
            TipCalculatorTheme {
                TipCalculator()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("70")
        composeTestRule.onNodeWithText("Tip(%)").performTextInput("5")
        val expectedTip = NumberFormat.getCurrencyInstance().format("3.5".toDouble())
        composeTestRule.onNodeWithText("Tip amount is ${expectedTip}")
            .assertExists("Node with text does not exists")
    }
}