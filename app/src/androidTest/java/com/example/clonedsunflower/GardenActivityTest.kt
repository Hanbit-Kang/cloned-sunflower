package com.example.clonedsunflower

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class GardenActivityTest {
    private val hiltRule = HiltAndroidRule(this)
    private val activityTestRule = ActivityTestRule(GardenActivity::class.java)

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(activityTestRule)

    @Test
    fun clickAddPlant_OpensPlantList() {
        onView(withId(R.id.add_plant)).perform(click())
        onView(withId(R.id.recyclerview_plantlist)).check(matches(isDisplayed()))
    }
}