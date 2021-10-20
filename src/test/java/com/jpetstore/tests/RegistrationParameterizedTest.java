package com.jpetstore.tests;

import com.jpetstore.steps.JPetStoreSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static com.jpetstore.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)

public class RegistrationParameterizedTest extends JPetStoreSteps {

    public RegistrationParameterizedTest() throws IOException {
    }

    @ParameterizedTest()
    @Tag(REGRESSION)
    @Test
    @DisplayName("Register multiple users to the jpetstore & verify" +
                 " if new user can login")
    @CsvFileSource(resources = "/data/registration-test.csv",numLinesToSkip = 1)
     void registerAccount(String userId,
                                String password,
                                String repeatedPassword,
                                String firstName,
                                String lastName,
                                String email,
                                String phone,
                                String addr1,
                                String addr2,
                                String city,
                                String state,
                                String zip,
                                String country) throws IOException {
        navigateToApp();
        navigateToSignOnPage();
        navigateToRegistrationPage();
        // Create account
        fillUserInfo(userId,password,repeatedPassword);
        fillAccountInformation(firstName,lastName,email,phone,addr1,addr2,city,state,zip,country);
        fillProfileInfo("english", "FISH", true,true);
        clickSaveAccountInformation();

        //Login & verify
        doLogin(userId,password);

        String greetingMsg = getWelcomeText();

        assertEquals("Welcome " + firstName +  "!",greetingMsg);

    }
}
