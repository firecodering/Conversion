package com.example.nebalbarhoome.home4;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class SingleConversionActivityTest {

    @Rule
    public ActivityTestRule<SingleConversionAtivity> mActivityRule =
            new ActivityTestRule(SingleConversionAtivity.class);

    @Test
    public void canEnter(){
        onView(withId(R.id.editText_from)).perform(typeText("45"));
    }

    @Test
    public void canEnters(){
        onView(withId(R.id.editText_to)).perform(typeText("2.1"));
    }

    @Test
    public void checkSpinnerDimension(){
        onView(withId(R.id.spinner_dimension)).perform(click());
    }

    @Test
    public void checkSpinnerFrom(){
        onView(withId(R.id.spinner_from)).perform(click());
        onData(anything()).atPosition(1).perform(click());
    }

    @Test
    public void checkSpinnerTo(){
        onView(withId(R.id.spinner_to)).perform(click());
        onData(anything()).atPosition(2).perform(click());
    }

    /*@Test
    public void checkSpinner(){
        onView(withId(R.id.spinner_dimension)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(1))).perform(click());
    }*/

    @Test
    public void button(){
       // onView(withId(R.id.button_all)).perform(click());
       onView(withText("All")).perform(click());
    }

}