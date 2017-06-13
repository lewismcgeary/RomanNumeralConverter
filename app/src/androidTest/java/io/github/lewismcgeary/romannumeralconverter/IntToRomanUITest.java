package io.github.lewismcgeary.romannumeralconverter;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class IntToRomanUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void oneToRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("1"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("I")));

    }

    @Test
    public void fortyTwoToRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("42"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("XLII")));

    }

    @Test
    public void twoThreeFourToRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("234"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("CCXXXIV")));

    }

    @Test
    public void threeNineNineNineToRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("3999"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("MMMCMXCIX")));

    }

    @Test
    public void negativeIntDisplaysError() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("-42"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText(R.string.conversion_error)));

    }

    @Test
    public void zeroIntDisplaysError() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("0"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText(R.string.conversion_error)));

    }

    @Test
    public void tooLargeIntDisplaysError() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("52000"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText(R.string.conversion_error)));

    }
}
