package com.jpetstore.tests;

import com.jpetstore.steps.JPetStoreSteps;
import com.jpetstore.util.ExcelDataReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;

import static com.jpetstore.tags.JPetStoreTags.DRAFT;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)

public class LoginDataDrivenTest extends JPetStoreSteps {


    public LoginDataDrivenTest() throws IOException {
    }

    static Object[][] getDatadoLogin(){
        return ExcelDataReader.getData("src/test/resources/data/LoginDDTest copy 2.xlsx","doLogin");
    }

    @ParameterizedTest()
    @Tag(DRAFT)
    @DisplayName("Login in application with multiple users & verify greeting message")
    @MethodSource("getDatadoLogin")
     void registerAccount(String userId,
                                String password,
                                String expected) throws IOException {
        navigateToApp();
        navigateToSignOnPage();

        //Login & verify
        doLogin(userId,password);

        String greetingMsg = getWelcomeText();

        assertEquals(expected,greetingMsg);

    }

}
