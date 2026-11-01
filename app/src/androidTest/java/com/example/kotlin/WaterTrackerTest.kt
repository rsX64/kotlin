package com.example.kotlin

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAddWaterButton() {
        composeTestRule.setContent { WaterTracker() }
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()
    }

    @Test
    fun testEndDayButton() {
        composeTestRule.setContent { WaterTracker() }
        repeat(6) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (1500+ мл): 1").assertExists()
        composeTestRule.onNodeWithText("0 мл").assertExists()
    }
}