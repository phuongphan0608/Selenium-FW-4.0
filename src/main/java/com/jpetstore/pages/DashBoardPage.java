package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class DashBoardPage extends BasePage {
    public DashBoardPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public static final String WELCOME_TEXT_CSS = "div[id='WelcomeContent']";

    @FindBy (css = WELCOME_TEXT_CSS)
    WebElement welcomeText;

    public String getWelcomeText() throws IOException {
        return getTextFromElement(By.cssSelector(WELCOME_TEXT_CSS));
    }
}
