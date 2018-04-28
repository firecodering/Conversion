package com.example.nebalbarhoome.home4;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MultiConversionActivityTest {

    @Rule
    public ActivityTestRule<MultiConversionActivity> mainActivityActivityTestRule = new ActivityTestRule<MultiConversionActivity>(MultiConversionActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Intent intent = new Intent(InstrumentationRegistry.getTargetContext(),MultiConversionActivity.class);
            intent.putExtra("DIM", "0");
            intent.putExtra("VAL", "12");
            intent.putExtra("SPINNER_FROM_POS" , "0");
            return intent;
        }
    };

    @Test
    public void canEnter(){
        onView(withId(R.id.number_input)).perform(typeText("12"));
    }

    @Test
    public void checkSpinnerFrom(){
        onView(withId(R.id.spinner_from)).perform(click());
        onData(anything()).atPosition(1).perform(click());
    }

    @Test
    public void RecyclerView(){
        RecyclerView rv = new RecyclerView(InstrumentationRegistry.getTargetContext());
        rv.setLayoutManager(new LinearLayoutManager(InstrumentationRegistry.getTargetContext()));
        rv.measure(View.MeasureSpec.AT_MOST, View.MeasureSpec.AT_MOST);
        rv.layout(0,0, 800, 480);
    }
}