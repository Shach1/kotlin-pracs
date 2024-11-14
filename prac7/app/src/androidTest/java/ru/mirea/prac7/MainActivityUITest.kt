package ru.mirea.prac7

import android.widget.ImageView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Првоеряем что все эллпменты отрисованы
    @Test
    fun elementsAreDisplayed() {
        onView(withId(R.id.etUrl)).check(matches(isDisplayed()))
        onView(withId(R.id.etFileName)).check(matches(isDisplayed()))
        onView(withId(R.id.btSave)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
    }

    @Test
    fun testSaveSuccessful() {
        // Ввод текста в поля EditText
        onView(withId(R.id.etUrl)).perform(replaceText("https://random-image-pepebigotes.vercel.app/api/skeleton-random-image"))
        onView(withId(R.id.etFileName)).perform(typeText("test_image"))

        // Нажатие на кнопку сохранения
        onView(withId(R.id.btSave)).perform(click())

        // Проверка, что ImageView обновлен
        Thread.sleep(2000)
        onView(withId(R.id.imageView))
            .check { view, _ ->
                // Проверяем, что View (ImageView) не пустой
                val imageView = view as ImageView
                assertNotNull("Image is not updated", imageView.drawable)
            }
    }
}