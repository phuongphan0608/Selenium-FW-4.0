package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String USERNAME_TEXTBOX_XPATH = "//input[@name='username']";

    private static final String PASSWORD_TEXTBOX_XPATH = "//input[@name='password']";

    private static final String LOGIN_BUTTON_CSS = "input[name='signon']";

    private static final String REGISTERNOW_LINK_XPATH = "//a[contains(text(),'Register Now!')]";

    private static final String INVALIDLOGIN_TEXT_XPATH = "//li[contains(text(),'Signon failed.')]";

    @FindBy (xpath = USERNAME_TEXTBOX_XPATH)
    private WebElement username;

    @FindBy (xpath = PASSWORD_TEXTBOX_XPATH)
    private WebElement password;

    @FindBy (css = LOGIN_BUTTON_CSS)
    private WebElement loginBtn;

    @FindBy (xpath = REGISTERNOW_LINK_XPATH)
    private WebElement registerNowLink;

    @FindBy (xpath = INVALIDLOGIN_TEXT_XPATH)
    private WebElement invalidLoginText;

    /**
     * Method to login to the application
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    public DashBoardPage doLogin(String username, String password) throws IOException {
        enterTextIntoTextBox(By.xpath(USERNAME_TEXTBOX_XPATH), username);
        enterTextIntoTextBox(By.xpath(PASSWORD_TEXTBOX_XPATH),password);
        clickLinkOrBtn(loginBtn);

        return new DashBoardPage(driver);
    }

    /**
     * Method to navigate to registration page
     * @return
     * @throws IOException
     */
    public AccountPage navigateToRegistrationPage() throws IOException {
        clickLinkOrBtn(By.xpath(REGISTERNOW_LINK_XPATH));
        return new AccountPage(driver);
    }


        /**
         * Method to return invalid login message
         * @return
         * @throws IOException
         */
    public String getMessageOnInvalidLogin() throws IOException {
        return getTextFromElement(By.xpath(INVALIDLOGIN_TEXT_XPATH));
    }


}
