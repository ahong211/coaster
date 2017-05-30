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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class InstrumentedTests {

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
    public void instrumentedTests() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageView = onView(
                allOf(withId(R.id.vodka_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.rum_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.gin_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                2),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.tequila_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        3),
                                0),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.whiskey_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        3),
                                1),
                        isDisplayed()));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction imageView6 = onView(
                allOf(withId(R.id.mixed_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        3),
                                2),
                        isDisplayed()));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction button = onView(
                allOf(withId(R.id.custom_drinks_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        5),
                                0),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.custom_drinks_button),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        5),
                                0),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.vodka_button), isDisplayed()));
        appCompatImageView.perform(click());

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
                        1),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));

        ViewInteraction cardView = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView.perform(click());

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout4.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView2 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView2.perform(click());

        ViewInteraction linearLayout5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout5.check(matches(isDisplayed()));

        pressBack();

        pressBack();

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.whiskey_button), isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction linearLayout6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout6.check(matches(isDisplayed()));

        ViewInteraction linearLayout7 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout7.check(matches(isDisplayed()));

        ViewInteraction linearLayout8 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
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
                        0),
                        isDisplayed()));
        linearLayout12.check(matches(isDisplayed()));

        ViewInteraction linearLayout13 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout13.check(matches(isDisplayed()));

        ViewInteraction linearLayout14 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout14.check(matches(isDisplayed()));

        ViewInteraction linearLayout15 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
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
                        3),
                        isDisplayed()));
        linearLayout17.check(matches(isDisplayed()));

        ViewInteraction linearLayout18 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        3),
                        isDisplayed()));
        linearLayout18.check(matches(isDisplayed()));

        ViewInteraction linearLayout19 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout19.check(matches(isDisplayed()));

        ViewInteraction cardView3 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView3.perform(click());

        ViewInteraction linearLayout20 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout20.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView4 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView4.perform(click());

        ViewInteraction linearLayout21 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout21.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView5 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView5.perform(click());

        ViewInteraction linearLayout22 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout22.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView6 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView6.perform(click());

        ViewInteraction linearLayout23 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout23.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView7 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView7.perform(click());

        ViewInteraction linearLayout24 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout24.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView8 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView8.perform(click());

        ViewInteraction linearLayout25 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout25.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView9 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView9.perform(click());

        ViewInteraction linearLayout26 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout26.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView10 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView10.perform(click());

        ViewInteraction linearLayout27 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout27.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView11 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView11.perform(click());

        ViewInteraction linearLayout28 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout28.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView12 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView12.perform(click());

        ViewInteraction linearLayout29 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout29.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView13 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView13.perform(click());

        ViewInteraction linearLayout30 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout30.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView14 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView14.perform(click());

        ViewInteraction linearLayout31 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout31.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction cardView15 = onView(
                allOf(withId(R.id.cardView), isDisplayed()));
        cardView15.perform(click());

        ViewInteraction linearLayout32 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fragment_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout32.check(matches(isDisplayed()));

    }
}