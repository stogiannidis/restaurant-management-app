package softeng.aueb.restaurant;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import softeng.aueb.restaurant.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void appTest() {
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.buttonSignUp), withText("Sign up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatButton.perform(click());
        
        ViewInteraction appCompatSpinner = onView(
allOf(withId(R.id.spinner),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatSpinner.perform(click());
        
        DataInteraction appCompatCheckedTextView = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(2);
        appCompatCheckedTextView.perform(click());
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.choice), withText("Register"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton2.perform(click());
        
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.editTextTextPersonName),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText.perform(replaceText("owner"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.editTextTextEmailAddressOwner),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatEditText2.perform(replaceText("owner@aueb.gr"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.editTextTextPasswordOwner),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText3.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.editTextNumber),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()));
        appCompatEditText4.perform(replaceText("30"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.editTextNumber), withText("30"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()));
        appCompatEditText5.perform(pressImeActionButton());
        
        ViewInteraction appCompatButton3 = onView(
allOf(withId(R.id.buttonSignUpOwner), withText("Sign Up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatButton3.perform(click());
        
        ViewInteraction appCompatButton4 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton4.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.itemName),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText6.perform(replaceText("pizza"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText7 = onView(
allOf(withId(R.id.itemPrice),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText7.perform(replaceText("5"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText8 = onView(
allOf(withId(R.id.itemQuantity),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText8.perform(replaceText("55"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton5 = onView(
allOf(withId(R.id.Add), withText("Add"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()));
        appCompatButton5.perform(click());
        
        ViewInteraction appCompatButton6 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton6.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton7 = onView(
allOf(withId(R.id.exit), withText("Exit"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
5),
isDisplayed()));
        appCompatButton7.perform(click());
        
        ViewInteraction appCompatButton8 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton8.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton9 = onView(
allOf(withId(R.id.buttonSignUp), withText("Sign up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatButton9.perform(click());
        
        ViewInteraction appCompatSpinner2 = onView(
allOf(withId(R.id.spinner),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatSpinner2.perform(click());
        
        DataInteraction appCompatCheckedTextView2 = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(1);
        appCompatCheckedTextView2.perform(click());
        
        ViewInteraction appCompatButton10 = onView(
allOf(withId(R.id.choice), withText("Register"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton10.perform(click());
        
        ViewInteraction appCompatEditText9 = onView(
allOf(withId(R.id.editTextTextPersonName),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText9.perform(replaceText("chef"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText10 = onView(
allOf(withId(R.id.editTextTextEmailAddressEmployee),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatEditText10.perform(replaceText("chef@aueb.gr"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText11 = onView(
allOf(withId(R.id.editTextTextPasswordEmployee),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText11.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton11 = onView(
allOf(withId(R.id.buttonSignUpEmployee), withText("Sign Up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatButton11.perform(click());
        
        ViewInteraction appCompatButton12 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton12.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton13 = onView(
allOf(withId(R.id.buttonSignUp), withText("Sign up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatButton13.perform(click());
        
        ViewInteraction appCompatSpinner3 = onView(
allOf(withId(R.id.spinner),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatSpinner3.perform(click());
        
        DataInteraction appCompatCheckedTextView3 = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(1);
        appCompatCheckedTextView3.perform(click());
        
        ViewInteraction appCompatButton14 = onView(
allOf(withId(R.id.choice), withText("Register"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton14.perform(click());
        
        ViewInteraction appCompatEditText12 = onView(
allOf(withId(R.id.editTextTextPersonName),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText12.perform(replaceText("waiter"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText13 = onView(
allOf(withId(R.id.editTextTextEmailAddressEmployee),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatEditText13.perform(replaceText("waiter@aueb.gr"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText14 = onView(
allOf(withId(R.id.editTextTextPasswordEmployee),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText14.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatSpinner4 = onView(
allOf(withId(R.id.spinner2),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()));
        appCompatSpinner4.perform(click());
        
        DataInteraction appCompatCheckedTextView4 = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(1);
        appCompatCheckedTextView4.perform(click());
        
        ViewInteraction appCompatButton15 = onView(
allOf(withId(R.id.buttonSignUpEmployee), withText("Sign Up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatButton15.perform(click());
        
        ViewInteraction appCompatButton16 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton16.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton17 = onView(
allOf(withId(R.id.buttonSignUp), withText("Sign up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatButton17.perform(click());
        
        ViewInteraction appCompatButton18 = onView(
allOf(withId(R.id.choice), withText("Register"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton18.perform(click());
        
        ViewInteraction appCompatEditText15 = onView(
allOf(withId(R.id.editTextTextPersonNameCustomer),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText15.perform(replaceText("cus"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText16 = onView(
allOf(withId(R.id.editTextTextEmailAddressCustomer),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatEditText16.perform(replaceText("cus@aueb.gr"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText17 = onView(
allOf(withId(R.id.editTextTextPasswordCustomer),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText17.perform(replaceText("12"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText18 = onView(
allOf(withId(R.id.editTextTextPasswordCustomer), withText("12"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText18.perform(click());
        
        ViewInteraction appCompatEditText19 = onView(
allOf(withId(R.id.editTextTextPasswordCustomer), withText("12"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText19.perform(replaceText("123"));
        
        ViewInteraction appCompatEditText20 = onView(
allOf(withId(R.id.editTextTextPasswordCustomer), withText("123"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText20.perform(closeSoftKeyboard());
        
        ViewInteraction appCompatButton19 = onView(
allOf(withId(R.id.buttonSignUpCustomer), withText("Sign Up"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatButton19.perform(click());
        
        ViewInteraction appCompatButton20 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton20.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText21 = onView(
allOf(withId(R.id.username),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()));
        appCompatEditText21.perform(replaceText("cus"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText22 = onView(
allOf(withId(R.id.password),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        appCompatEditText22.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton21 = onView(
allOf(withId(R.id.login), withText("Log In"),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
2),
isDisplayed()));
        appCompatButton21.perform(click());
        
        ViewInteraction appCompatButton22 = onView(
allOf(withId(android.R.id.button1), withText("Proceed"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton22.perform(scrollTo(), click());
        
        ViewInteraction appCompatSpinner5 = onView(
allOf(withId(R.id.spinner_option),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatSpinner5.perform(click());
        
        DataInteraction appCompatCheckedTextView5 = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(1);
        appCompatCheckedTextView5.perform(click());
        
        ViewInteraction appCompatButton23 = onView(
allOf(withId(R.id.option), withText("Continue"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton23.perform(click());
        
        ViewInteraction appCompatEditText23 = onView(
allOf(withId(R.id.tableNumber),
childAtPosition(
allOf(withId(R.id.flag),
childAtPosition(
withId(android.R.id.content),
0)),
6),
isDisplayed()));
        appCompatEditText23.perform(replaceText("3"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText24 = onView(
allOf(withId(R.id.itemToOrder),
childAtPosition(
allOf(withId(R.id.flag),
childAtPosition(
withId(android.R.id.content),
0)),
2),
isDisplayed()));
        appCompatEditText24.perform(replaceText("pizza"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText25 = onView(
allOf(withId(R.id.itemToOrderQuantity),
childAtPosition(
allOf(withId(R.id.flag),
childAtPosition(
withId(android.R.id.content),
0)),
3),
isDisplayed()));
        appCompatEditText25.perform(replaceText("3"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton24 = onView(
allOf(withId(R.id.buttonAdd), withText("Add"),
childAtPosition(
allOf(withId(R.id.flag),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        appCompatButton24.perform(click());
        
        ViewInteraction appCompatButton25 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton25.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton26 = onView(
allOf(withId(R.id.buttonOrder), withText("Place Order"),
childAtPosition(
allOf(withId(R.id.flag),
childAtPosition(
withId(android.R.id.content),
0)),
5),
isDisplayed()));
        appCompatButton26.perform(click());
        
        ViewInteraction appCompatButton27 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton27.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText26 = onView(
allOf(withId(R.id.username),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()));
        appCompatEditText26.perform(replaceText("chef"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText27 = onView(
allOf(withId(R.id.password),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        appCompatEditText27.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton28 = onView(
allOf(withId(R.id.login), withText("Log In"),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
2),
isDisplayed()));
        appCompatButton28.perform(click());
        
        ViewInteraction appCompatButton29 = onView(
allOf(withId(android.R.id.button1), withText("Cry"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton29.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText28 = onView(
allOf(withId(R.id.orderIdToVerify),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatEditText28.perform(replaceText("672"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText29 = onView(
allOf(withId(R.id.PREPARATIONTIME),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()));
        appCompatEditText29.perform(replaceText("35"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton30 = onView(
allOf(withId(R.id.verificationButton), withText("Verify"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatButton30.perform(click());
        
        ViewInteraction appCompatButton31 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton31.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton32 = onView(
allOf(withId(R.id.logoutButton), withText("Log out"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatButton32.perform(click());
        
        ViewInteraction appCompatButton33 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton33.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText30 = onView(
allOf(withId(R.id.username),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()));
        appCompatEditText30.perform(replaceText("cus"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText31 = onView(
allOf(withId(R.id.password),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        appCompatEditText31.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton34 = onView(
allOf(withId(R.id.login), withText("Log In"),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
2),
isDisplayed()));
        appCompatButton34.perform(click());
        
        ViewInteraction appCompatButton35 = onView(
allOf(withId(android.R.id.button1), withText("Proceed"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton35.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton36 = onView(
allOf(withId(R.id.option), withText("Continue"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton36.perform(click());
        
        ViewInteraction appCompatButton37 = onView(
allOf(withId(R.id.payButton), withText("Pay"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
7),
isDisplayed()));
        appCompatButton37.perform(click());
        
        ViewInteraction appCompatButton38 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton38.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton39 = onView(
allOf(withId(R.id.buttonLogoutC), withText("Logout"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
8),
isDisplayed()));
        appCompatButton39.perform(click());
        
        ViewInteraction appCompatEditText32 = onView(
allOf(withId(R.id.username),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()));
        appCompatEditText32.perform(replaceText("waiter"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText33 = onView(
allOf(withId(R.id.password),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        appCompatEditText33.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton40 = onView(
allOf(withId(R.id.login), withText("Log In"),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
2),
isDisplayed()));
        appCompatButton40.perform(click());
        
        ViewInteraction appCompatButton41 = onView(
allOf(withId(android.R.id.button1), withText("Cry"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton41.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText34 = onView(
allOf(withId(R.id.orderToBePaid),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText34.perform(replaceText("672"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton42 = onView(
allOf(withId(R.id.confirmationButton), withText("Confirm"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatButton42.perform(click());
        
        ViewInteraction appCompatButton43 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton43.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton44 = onView(
allOf(withId(R.id.waiterLogoutButton), withText("Logout"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        appCompatButton44.perform(click());
        
        ViewInteraction appCompatButton45 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton45.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText35 = onView(
allOf(withId(R.id.username),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()));
        appCompatEditText35.perform(replaceText("owner"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText36 = onView(
allOf(withId(R.id.password),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()));
        appCompatEditText36.perform(replaceText("123"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton46 = onView(
allOf(withId(R.id.login), withText("Log In"),
childAtPosition(
allOf(withId(R.id.container),
childAtPosition(
withId(android.R.id.content),
0)),
2),
isDisplayed()));
        appCompatButton46.perform(click());
        
        ViewInteraction appCompatButton47 = onView(
allOf(withId(android.R.id.button1), withText("Proceed"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton47.perform(scrollTo(), click());
        
        ViewInteraction appCompatButton48 = onView(
allOf(withId(R.id.calculateRevenue), withText("Revenue"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        appCompatButton48.perform(click());
        
        ViewInteraction appCompatButton49 = onView(
allOf(withId(android.R.id.button1), withText("OKAY"),
childAtPosition(
childAtPosition(
withId(R.id.buttonPanel),
0),
3)));
        appCompatButton49.perform(scrollTo(), click());
        }
    
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
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
