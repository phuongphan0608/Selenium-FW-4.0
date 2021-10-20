package com.jpetstore.steps;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.pages.AccountPage;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.DashBoardPage;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.util.Helper;
import io.qameta.allure.Step;

import java.io.IOException;

public class JPetStoreSteps extends DriverManager {


    private BasePage basePage = new BasePage(getDriver());
    private LoginPage loginPage = new LoginPage(getDriver());
    private DashBoardPage dashBoardPage = new DashBoardPage(getDriver());
    private AccountPage accountPage = new AccountPage(getDriver());


    public JPetStoreSteps() throws IOException {
    }

    /*****************************************
     ****************************************
     *
     * BASE PAGE STEPS
     * ****************************************
     * ****************************************
     */

    @Step("Navigating to JPetStore")
    public void navigateToApp() throws IOException {
        basePage.navigateToApp();
    }

    @Step("Navigating to Sign on page")
    public  LoginPage clickSignInLink() throws IOException {
        return basePage.clickSignInLink();
    }

        /*****************************************
         ****************************************
         *
         * LOGIN PAGE STEPS
         * ****************************************
         * ****************************************
         */


    @Step("Navigating to Login Page")
    public LoginPage navigateToSignOnPage() throws IOException {
        return loginPage.navigateToSignOnPage();
    }

    @Step("Logging in with username: {0} & password: {1}")
    public DashBoardPage doLogin(String username, String password) throws IOException {
        basePage.clickSignInLink();
        Helper.takeScreenshot(driver,"doLogin");
        return loginPage.doLogin(username, password);
    }

    @Step("Getting invalid login message")
    public String getMessageOnInvalidLogin() throws IOException {
        return loginPage.getMessageOnInvalidLogin();
    }

    @Step("Going to registration page")
    public AccountPage navigateToRegistrationPage() throws IOException {
        return loginPage.navigateToRegistrationPage();
    }
        /*****************************************
         ****************************************
         *
         * DASHBOARD PAGE STEPS
         * ****************************************
         * ****************************************
         */

    @Step("Getting Welcome text")
    public String getWelcomeText() throws IOException {
        return dashBoardPage.getWelcomeText();
    }

    /*****************************************
     ****************************************
     *
     * MYACCOUNT PAGE STEPS
     * ****************************************
     * ****************************************
     */

    @Step("Filling user information")
    public AccountPage fillUserInfo(String userId,
                             String newPassword,
                             String repeatPassword
    ) throws IOException {
        return accountPage.fillUserInfo(userId,newPassword,repeatPassword);
    }

    @Step("Filling account information")
    public AccountPage fillAccountInformation(String firstName,
                                       String lastName,
                                       String email,
                                       String phone,
                                       String address1,
                                       String address2,
                                       String city,
                                       String state,
                                       String zip,
                                       String country) throws IOException {
        return accountPage.fillAccountInformation(firstName,lastName,email,phone,address1,address2,city,state,zip,country);
    }

    @Step("Filling profile information")
    public AccountPage fillProfileInfo(String language,
                                String favoriteCategory,
                                boolean checkMyList,
                                boolean checkMyBanner) throws IOException {

        return accountPage.fillProfileInfo(language,favoriteCategory,checkMyList,checkMyBanner);

    }


    @Step("Saving account information")
    public DashBoardPage clickSaveAccountInformation () throws IOException {
        Helper.takeScreenshot(driver, "clickSaveAccountInformation");
        return accountPage.clickSaveAccountInformation();
    }
}