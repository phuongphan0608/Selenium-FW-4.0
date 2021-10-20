package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) throws IOException {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public static final String USER_INFO_TEXT_XPATH = "//h3[contains(text(),'User Information')]";

    public static final String USERID_TEXTBOX_CSS = "input[name='username']";

    public static final String NEWPASSWORD_TEXTBOX_CSS= "input[name='password']";

    public static final String REPEATPASSWORD_TEXTBOX_CSS= "input[name='repeatedPassword']";

    public static final String ACCOUNT_INFO_TEXT_XPATH = "//h3[contains(text(),'Account Information')]";

    public static final String FIRSTNAME_TEXTBOX_CSS = "input[name='account.firstName']";

    public static final String LASTNAME_TEXTBOX_CSS = "input[name='account.lastName']";

    public static final String EMAIL_TEXTBOX_CSS = "input[name='account.email']";

    public static final String PHONE_TEXTBOX_CSS = "input[name='account.phone']";

    public static final String ADDRESS1_TEXTBOX_CSS = "input[name='account.address1']";

    public static final String ADDRESS2_TEXTBOX_CSS = "input[name='account.address2']";

    public static final String CITY_TEXTBOX_CSS = "input[name='account.city']";

    public static final String STATE_TEXTBOX_CSS = "input[name='account.state']";

    public static final String ZIP_TEXTBOX_CSS = "input[name='account.zip']";

    public static final String COUNTRY_TEXTBOX_CSS = "input[name='account.country']";

    public static final String PROFILE_INFO_TEXT_XPATH = "//h3[contains(text(),'Profile Information')]";

    public static final String LANGUAGE_DROPDOWN_CSS = "select[name$='.languagePreference']";

    public static final String FAVORITE_CATEGORY_DROPDOWN_CSS = "select[name$='.favouriteCategoryId']";

    public static final String MYLIST_CHECKBOX_CSS = "input[name$='.listOption']";

    public static final String MYBANNER_CHECKBOX_CSS = "input[name$='.bannerOption']";

    public static final String SAVE_ACCOUNT_BUTTON_CSS = "input[name='newAccount']";

    @FindBy(xpath = USER_INFO_TEXT_XPATH )
    WebElement userInfoText;

    @FindBy(css = USERID_TEXTBOX_CSS )
    WebElement userIdTextbox;

    @FindBy(css = NEWPASSWORD_TEXTBOX_CSS )
    WebElement newPasswordTextbox;

    @FindBy(css = REPEATPASSWORD_TEXTBOX_CSS )
    WebElement repeatPasswordTextbox;

    @FindBy(xpath = ACCOUNT_INFO_TEXT_XPATH )
    WebElement accountInfoText;

    @FindBy(css = FIRSTNAME_TEXTBOX_CSS )
    WebElement firstNameTextbox;

    @FindBy(css = LASTNAME_TEXTBOX_CSS )
    WebElement lastNameTextbox;

    @FindBy(css = EMAIL_TEXTBOX_CSS )
    WebElement emailTextbox;

    @FindBy(css = PHONE_TEXTBOX_CSS )
    WebElement phoneTextbox;

    @FindBy(css = ADDRESS1_TEXTBOX_CSS )
    WebElement address1Textbox;

    @FindBy(css = ADDRESS2_TEXTBOX_CSS )
    WebElement address2Textbox;

    @FindBy(css = CITY_TEXTBOX_CSS )
    WebElement cityTextbox;

    @FindBy(css = STATE_TEXTBOX_CSS )
    WebElement stateTextbox;

    @FindBy(css = ZIP_TEXTBOX_CSS )
    WebElement zipTextbox;

    @FindBy(css = COUNTRY_TEXTBOX_CSS )
    WebElement countryTextbox;

    @FindBy(xpath = PROFILE_INFO_TEXT_XPATH )
    WebElement profileInfoText;

    @FindBy(css = LANGUAGE_DROPDOWN_CSS )
    WebElement languageDropdown;

    @FindBy(css = FAVORITE_CATEGORY_DROPDOWN_CSS )
    WebElement favouriteCategoryDropdown;

    @FindBy(css = MYLIST_CHECKBOX_CSS )
    WebElement myListCheckbox;

    @FindBy(css = MYBANNER_CHECKBOX_CSS )
    WebElement myBannerCheckbox;

    @FindBy(css = SAVE_ACCOUNT_BUTTON_CSS )
    WebElement saveAccountButton;

    public AccountPage fillUserInfo(String userId,
                             String newPassword,
                             String repeatPassword
                             ) throws IOException {
        isTextPresentOnPage("User Information");
        enterTextIntoTextBox(By.cssSelector(USERID_TEXTBOX_CSS),userId);
        enterTextIntoTextBox(By.cssSelector(NEWPASSWORD_TEXTBOX_CSS),newPassword);
        enterTextIntoTextBox(By.cssSelector(REPEATPASSWORD_TEXTBOX_CSS), repeatPassword);

        return this;

    }

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
        isTextPresentOnPage("Account Information");
        enterTextIntoTextBox(By.cssSelector(FIRSTNAME_TEXTBOX_CSS), firstName);
        enterTextIntoTextBox(By.cssSelector(LASTNAME_TEXTBOX_CSS), lastName);
        enterTextIntoTextBox(By.cssSelector(EMAIL_TEXTBOX_CSS),email);
        enterTextIntoTextBox(By.cssSelector(PHONE_TEXTBOX_CSS),phone);
        enterTextIntoTextBox(By.cssSelector(ADDRESS1_TEXTBOX_CSS),address1);
        enterTextIntoTextBox(By.cssSelector(ADDRESS2_TEXTBOX_CSS),address2);
        enterTextIntoTextBox(By.cssSelector(CITY_TEXTBOX_CSS),city);
        enterTextIntoTextBox(By.cssSelector(STATE_TEXTBOX_CSS),state);
        enterTextIntoTextBox(By.cssSelector(ZIP_TEXTBOX_CSS),zip);
        enterTextIntoTextBox(By.cssSelector(COUNTRY_TEXTBOX_CSS),country);
        return this;
    }

    public AccountPage fillProfileInfo(String language,
                                String favoriteCategory,
                                boolean checkMyList,
                                boolean checkMyBanner) throws IOException {
        isTextPresentOnPage("Profile Information");
        selectByVisibleText(By.cssSelector(LANGUAGE_DROPDOWN_CSS),language);
        selectByVisibleText(By.cssSelector(FAVORITE_CATEGORY_DROPDOWN_CSS),favoriteCategory);
        selectCheckBox(By.cssSelector(MYLIST_CHECKBOX_CSS));
        selectCheckBox(By.cssSelector(MYBANNER_CHECKBOX_CSS));
        return this;
    }

    public DashBoardPage clickSaveAccountInformation() throws IOException {
        clickLinkOrBtn(By.cssSelector(SAVE_ACCOUNT_BUTTON_CSS));
        return new DashBoardPage(getDriver());
    }
}
