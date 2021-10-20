package com.jpetstore.tests;

import com.jpetstore.steps.JPetStoreSteps;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static com.jpetstore.tags.JPetStoreTags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@Disabled
@ExtendWith(TestListener.class)
@DisplayName("Login Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)

public class LoginTest extends JPetStoreSteps {

    public LoginTest() throws IOException {
    }

    @RepeatedIfExceptionsTest(repeats = 3)
    @Tag(SMOKE)
    @Test
    @DisplayName("As a valid user, a user must be able to login with valid username and password.")
    @Description("Logging into the app via sign on page")
    void doLogin() throws IOException {
        navigateToApp();
        navigateToSignOnPage();
        doLogin("test1","123456");

        //Assertion
        assertEquals("Welcome Test!",getWelcomeText());

        //Soft assertion
//        assertAll(
//                () ->         assertEquals("Welcome Test1!",getWelcomeText()),
////                () ->         assertEquals("Welcome Test 456!",getWelcomeText())
//        );
    }



    @Nested
    @DisplayName("Negative Login Test")
    class negativeTestLogin{
        @Test
        @DisplayName("User must not be able to login with invalid credentials")
        void invalidLogin() throws IOException {
            navigateToApp();
            navigateToSignOnPage();
            doLogin("j2ee","j123456");

            assertEquals("Invalid username or password. Signon failed.",getMessageOnInvalidLogin());
        }
    }


}
