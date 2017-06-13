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
public class RomanToIntUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void oneFromRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("I"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("1")));

    }

    @Test
    public void fortyTwoFromRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("XLII"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("42")));

    }

    @Test
    public void twoThreeFourFromRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("CCXXXIV"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("234")));

    }

    @Test
    public void threeNineNineNineFromRoman() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("MMMCMXCIX"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText("3999")));

    }

    @Test
    public void invalidCharacterDisplaysError() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("MMZ"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText(R.string.conversion_error)));

    }

    @Test
    public void blankDisplaysError() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText(" "), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText(R.string.conversion_error)));

    }

    @Test
    public void overLimitMmmmDisplaysError() {

        onView(withId(R.id.input_edit_text)).perform(click());

        onView(withId(R.id.input_edit_text)).perform(typeText("mmmm"), closeSoftKeyboard());

        onView(withId(R.id.convert_button)).perform(click());

        onView(withId(R.id.output_text_view)).check(matches(withText(R.string.conversion_error)));

    }
}
