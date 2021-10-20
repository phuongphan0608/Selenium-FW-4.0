package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.URL;

import static com.jpetstore.util.Helper.getAppUrl;

public class BasePage extends HtmlPageObject {
    private WebDriver driver;

    public BasePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Webelments of Base Page
    private static final String ENTER_STORE_LINK_CSS = "div[id='Content'] a[href$='.action']";

    private static final String SIGN_ON_LINK_CSS = "div[id='MenuContent'] a[href$='?signonForm=']";

    private static final String LOGO_LINK_CSS = "div[id='LogoContent'] img[src$='../images/logo-topbar.gif']";

    private static final String ADDTOCART_LINK_CSS = "div[id='MenuContent'] a[href$='?signonForm=']";

    private static final String SEARCH_TEXTBOX_XPATH  = "//input[@name='keyword']";

    private static final String SEARCH_BUTTON_XPATH = "searchProducts";

    private static final String HELP_ICON_CSS = "div[id='MenuContent'] a[href$='help.html']";

    private static final String FISH_NAV_CSS = "div[id='QuickLinks'] a[href$='FISH']";

    private static final String DODS_NAV_CSS = "div[id='QuickLinks'] a[href$='DOGS']";

    private static final String REPTILES_NAV_CSS = "div[id='QuickLinks'] a[href$='REPTILES']";

    private static final String CATS_NAV_CSS = "div[id='QuickLinks'] a[href$='CATS']";

    private static final String BIRDS_NAV_CSS = "div[id='QuickLinks'] a[href$='BIRDS']";

    private static final String SIGNOUT_LINK_CSS = "div[id='MenuContent'] a[href$='signoff=']";

    private static final String MYACCOUNT_LINK_CSS = "div[id='MenuContent'] a[href$='editAccountForm =']";

    @FindBy(css = ENTER_STORE_LINK_CSS)
    private WebElement enterStoreLink;

    @FindBy(css = SIGN_ON_LINK_CSS)
    private WebElement signOnLink;

    @FindBy(css = LOGO_LINK_CSS)
    private WebElement logoLink;

    @FindBy (css = ADDTOCART_LINK_CSS)
    private WebElement addToCartLink;

    @FindBy (css = SEARCH_TEXTBOX_XPATH)
    private WebElement searchTextbox;

    @FindBy (css = SEARCH_BUTTON_XPATH)
    private WebElement searchButton;

    @FindBy (css = HELP_ICON_CSS)
    private WebElement helpIcon;

    @FindBy (css = FISH_NAV_CSS)
    private WebElement fishNav;

    @FindBy (css = DODS_NAV_CSS)
    private WebElement dogsNav;

    @FindBy (css = REPTILES_NAV_CSS)
    private WebElement reptilesNav;

    @FindBy (css = CATS_NAV_CSS)
    private WebElement catsNav;

    @FindBy (css = BIRDS_NAV_CSS)
    private WebElement birdsNav;

    /**
     * Navigate to app
     */
    public void navigateToApp() throws IOException {
        driver.navigate().to(new URL(getAppUrl()));
    }

    /**
     * Method to navigate sign in page
     * @return
     * @throws IOException
     */
    public LoginPage navigateToSignOnPage() throws IOException {
        isTextPresentOnPage("Welcome to JPetStore 6");
        clickLinkOrBtn(enterStoreLink);
        clickLinkOrBtn(signOnLink);
        return new LoginPage(driver);
    }

    /**
     * Method to click on Sign on link
     * @return
     * @throws IOException
     */
    public  LoginPage clickSignInLink() throws IOException {
        clickLinkOrBtn(By.cssSelector(SIGN_ON_LINK_CSS));
        return new LoginPage(driver);
    }

    /**
     * Method to navigate to DashBoard
     * @return
     * @throws IOException
     */
    public DashBoardPage navigateToDashBoard() throws IOException {
        clickLinkOrBtn(By.cssSelector(LOGO_LINK_CSS));
        return new DashBoardPage(driver);
    }

    /**
     * Method to navigate to ProductPage
     * @return
     * @throws IOException
     */
    public ProductPage navigateToShoppingCart() throws IOException {
        clickLinkOrBtn(addToCartLink);
        return new ProductPage(driver);
    }

    /**
     * Method to navigate to Help Page
     * @return
     * @throws IOException
     */
    public HelpPage navigateToHelpPage() throws IOException {
        clickLinkOrBtn(By.cssSelector(HELP_ICON_CSS));
        return new HelpPage(driver);
    }

    /**
     * Method to search for a product
     * @param searchValue
     * @return
     * @throws IOException
     */
    public ProductPage searchForProduct(String searchValue) throws IOException {
        enterTextIntoTextBox(By.xpath(SEARCH_TEXTBOX_XPATH),searchValue);
        clickLinkOrBtn(By.cssSelector(SEARCH_TEXTBOX_XPATH));
        return new ProductPage(driver);
    }

    /**
     * Method to Sign Out
     * @return
     * @throws IOException
     */
    public DashBoardPage signOut() throws IOException {
        clickLinkOrBtn(By.cssSelector(SIGNOUT_LINK_CSS));
        return new DashBoardPage(driver);
    }

    /**
     * Navigate to accounts page
     * @return
     * @throws IOException
     */
    public AccountPage navigatetoAccountPage() throws IOException {
        clickLinkOrBtn(By.cssSelector(MYACCOUNT_LINK_CSS));
        return new AccountPage(driver);
    }

    public ProductPage navigateToProductCategory(ProductCategory productCategory) throws IOException {
        switch(productCategory){
            case FISH:
                clickLinkOrBtn(By.cssSelector(FISH_NAV_CSS));
                return new ProductPage(driver);
            case DOGS:
                clickLinkOrBtn(By.cssSelector(DODS_NAV_CSS));
                return new ProductPage(driver);
            case REPTILES:
                clickLinkOrBtn(By.cssSelector(REPTILES_NAV_CSS));
                return new ProductPage(driver);
            case CATS:
                clickLinkOrBtn(By.cssSelector(CATS_NAV_CSS));
                return new ProductPage(driver);
            case BIRDS:
                clickLinkOrBtn(By.cssSelector(BIRDS_NAV_CSS));
                return new ProductPage(driver);

        }
        return null;
    }
}

