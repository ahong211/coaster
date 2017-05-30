package com.coaster.android.coaster;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WhiskeyCategoryTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void whiskeyTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.whiskey_button), isDisplayed()));
        appCompatImageView.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout2.check(matches(isDisplayed()));

        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout4.check(matches(isDisplayed()));

        ViewInteraction linearLayout5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout5.check(matches(isDisplayed()));

        ViewInteraction linearLayout6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout6.check(matches(isDisplayed()));

        ViewInteraction linearLayout7 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        3),
                        isDisplayed()));
        linearLayout7.check(matches(isDisplayed()));

        ViewInteraction linearLayout8 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        3),
                        isDisplayed()));
        linearLayout8.check(matches(isDisplayed()));

        ViewInteraction linearLayout9 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout9.check(matches(isDisplayed()));

        ViewInteraction linearLayout10 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout10.check(matches(isDisplayed()));

        ViewInteraction linearLayout11 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout11.check(matches(isDisplayed()));

        ViewInteraction linearLayout12 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout12.check(matches(isDisplayed()));

        ViewInteraction linearLayout13 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout13.check(matches(isDisplayed()));

        ViewInteraction linearLayout14 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout14.check(matches(isDisplayed()));

        ViewInteraction linearLayout15 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout15.check(matches(isDisplayed()));

        ViewInteraction linearLayout16 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout16.check(matches(isDisplayed()));

        ViewInteraction linearLayout17 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout17.check(matches(isDisplayed()));

    }
}