package cat.itb.testingitb;

import android.app.Activity;

import androidx.annotation.ContentView;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Test;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasImeAction;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void elements_on_activityMain_are_displayed() {

        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void elements_have_the_correct_text() {

        onView(withId(R.id.textView)).check(matches(withText(R.string.title)));
        onView(withId(R.id.button)).check(matches(withText(R.string.next)));
    }

    @Test
    public void nextButton_is_clickable_and_changes_text_to_back_when_clicked() {

        onView(withId(R.id.button)).check(matches(isClickable()))
                .perform(click()).check(matches(withText(R.string.Back)));


    }

    @Test

    public void insert_username_and_closes_keyboard() {

        onView(withId(R.id.username)).check(matches(isDisplayed())).perform(typeText("Juan"));


    }

    @Test

    public void insert_password_and_closes_keyboard() {

        onView(withId(R.id.password)).check(matches(isDisplayed())).perform(typeText("12345"));


    }

    @Test
    public void nextButton_is_clickable() {

        onView(withId(R.id.button)).check(matches(isClickable()))
                .perform(click()).check(matches(withText(R.string.logged)));


    }

    //No pots fer-ho amb R.string.*, perque el reconeix com un int i no un string.

    @Test
    public void nextButton_goes_to_SecondActivity() {

        onView(withId(R.id.button)).check(matches(isClickable()))
                .perform(click()).check(matches(withId(R.id.secondActivity)));
    }

    @Test
    public void backButton_goes_to_MainActivity() {

        onView(withId(R.id.button2)).check(matches(isClickable()))
                .perform(click()).check(matches(withId(R.id.mainActivity)));
    }

    @Test
    public void backButtonAndroid_goes_to_MainActivity() {

        onView(withId(R.id.secondActivity))
                .perform(ViewActions.pressBack()).check(matches(withId(R.id.mainActivity)));

    }

    @Test
    public void large_text_function(){

        onView(withId(R.id.username))
                .check(matches(not(withText(""))));
        onView(withId(R.id.password))
                .check(matches(not(withText(""))));
        onView(withId(R.id.button))
                .check(matches(isClickable()));
        onView(withId(R.id.button)).
                check(matches(isClickable()))
                .perform(click())
                .check(matches(withId(R.id.secondActivity)));
        onView(withId(R.id.textView2))
                .check(matches(withText("Werlcome back " + "Juan")));
        onView(isClickable()).perform(ViewActions.pressBack());
        onView(withId(R.id.button2))
                .perform(click())
                .check(matches(withId(R.id.mainActivity)));
        onView(withId(R.id.username))
                .check(matches(withText("")));
        onView(withId(R.id.password))
                .check(matches(withText("")));

    }
}
