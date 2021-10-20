package com.jpetstore.tests;

import com.github.javafaker.Faker;
import com.jpetstore.steps.JPetStoreSteps;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.jpetstore.tags.JPetStoreTags.REGISTRATION;
import static com.jpetstore.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag(REGRESSION)
@DisplayName("Account Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)

public class RegistrationTest extends JPetStoreSteps {

    public RegistrationTest() throws IOException {
    }
    Faker faker = new Faker();
    String userId = "test8" + faker.number().randomNumber(10,false);
    String password = faker.internet().password();
    String repeatedPassword = faker.internet().password();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().phoneNumber();
    String addr1 = faker.address().buildingNumber();
    String addr2 = faker.address().streetAddress();
    String city = faker.address().city();
    String state = faker.address().state();
    String zip = faker.address().zipCode();
    String country = faker.address().country();

    @Tag(REGISTRATION)
    @Test
    @DisplayName("Account Page Test")
    public void registerAccount() throws IOException {
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
