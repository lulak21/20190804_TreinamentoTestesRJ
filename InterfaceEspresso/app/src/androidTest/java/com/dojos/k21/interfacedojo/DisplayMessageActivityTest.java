package com.dojos.k21.interfacedojo;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static com.dojos.k21.interfacedojo.MainActivity.EXTRA_MESSAGE;


@RunWith(AndroidJUnit4.class)
public class DisplayMessageActivityTest {

    @Rule
    public ActivityTestRule<DisplayMessageActivity> intentsTestRule =
            new ActivityTestRule<>(DisplayMessageActivity.class, true, false);

    @Test
    public void displayCommissionMessage() {
        Intent intent = new Intent();
        String message = "Para uma venda de 6 o valor da comissão deve ser 0,30";
        intent.putExtra(EXTRA_MESSAGE, message);

        intentsTestRule.launchActivity(intent);

        onView(withId(R.id.textView)).check(matches(withText(message)));
    }

    @Test
    public void messageColorIsGrey() {
        Intent intent = new Intent();
        String message = "Esta mensagem é cinza";
        intent.putExtra(EXTRA_MESSAGE, message);

        intentsTestRule.launchActivity(intent);

        onView(withId(R.id.textView)).check(matches(hasTextColor(R.color.colorCinza)));
    }



}
