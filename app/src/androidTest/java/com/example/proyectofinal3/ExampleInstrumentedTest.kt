package com.example.proyectofinal3

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCompareButton() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        // Realiza acciones de la interfaz de usuario usando Espresso
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
            .perform(ViewActions.typeText("Hello"))
        Espresso.onView(ViewMatchers.withId(R.id.editText2))
            .perform(ViewActions.typeText("Hello"))
        Espresso.onView(ViewMatchers.withId(R.id.compareButton))
            .perform(ViewActions.click())

        // Verifica el resultado en el TextView
        Espresso.onView(ViewMatchers.withId(R.id.resultText))
            .check(ViewAssertions.matches(ViewMatchers.withText(appContext.getString(R.string.same_text))))
    }
}