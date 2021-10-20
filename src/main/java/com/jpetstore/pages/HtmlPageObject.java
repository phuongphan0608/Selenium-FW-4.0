package com.jpetstore.pages;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.util.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static com.jpetstore.util.TimeUtil.getExplicitWait;

public class HtmlPageObject extends DriverManager {

    private WebDriver driver = getDriver();

    public HtmlPageObject() throws IOException {
    }

    /**
     * Method to find element by css
     * @param cssLocator
     * @return
     */
    public WebElement findElementByCss(String cssLocator) throws IOException {
        try {
            By by = By.cssSelector(cssLocator);
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(getExplicitWait()));
            WebDriverWait wait = new WebDriverWait(driver,getExplicitWait());
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to find element by xpath
     * @param xPathLocator
     * @return
     */
    public WebElement findElementByxPath(String xPathLocator) throws IOException {
        try {
            By by = By.xpath(xPathLocator);
            WebDriverWait wait = new WebDriverWait(driver,getExplicitWait());
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(getExplicitWait()));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to find element by Id
     * @param IdLocator
     * @return
     */
    public WebElement findElementById(String IdLocator) throws IOException {
        try {
            By by = By.id(IdLocator);
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(getExplicitWait()));
            WebDriverWait wait = new WebDriverWait(driver,getExplicitWait());
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to find an element by using By locator
     * @param by
     * @return
     */
    public WebElement findElementBy(By by) throws IOException {
        try {
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(getExplicitWait()));
            WebDriverWait wait = new WebDriverWait(driver,getExplicitWait());
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }


    /**
     * Method to find an element by using By locator
     * @param by
     * @return
     */
    public List<WebElement> findElementsBy(By by) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver,getExplicitWait());
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to enter text inside textbox
     * @param by
     * @param text
     * @throws IOException
     */
    public void enterTextIntoTextBox(By by, String text) throws IOException {
        WebElement textBox = findElementBy(by);
        textBox.clear();
        textBox.sendKeys(text);
//        Helper.takeElementScreenshot(textBox, "textbox");
        LogHelper.logToReport("Typing text: " + text + "inside textbox" + " with locator: "
                             + by);
    }

    /**
     * Method to enter text inside textbox
     * @param webElement
     * @param text
     * @throws IOException
     */
    public void enterTextIntoTextBox(WebElement webElement, String text) throws IOException {
        webElement.clear();
        webElement.sendKeys(text);
        LogHelper.logToReport("Typing text: " + text + "inside textbox" + " with locator: "
                + webElement);
    }

    /**
     * Method to click a link or button
     * @param by
     * @throws IOException
     */
    public void clickLinkOrBtn(By by) throws IOException {
        WebElement btnOrLink = findElementBy(by);
        btnOrLink.click();
    }

    /**
     * Method to click a link or button
     * @param webElement
     * @throws IOException
     */
    public void clickLinkOrBtn(WebElement webElement) throws IOException {
        webElement.click();
    }

    /**
     * Method to return text
     * @param by
     * @return
     * @throws IOException
     */
    public String getTextFromElement(By by) throws IOException {
        WebElement element = findElementBy(by);
        return  element.getText();
    }

    /**
     * Method to return text
     * @param webElement
     * @return
     * @throws IOException
     */
    public String getTextFromElement(WebElement webElement) throws IOException {
        return  webElement.getText();
    }

    /**
     * Method to return attribute
     * @param by
     * @param attr
     * @return
     * @throws IOException
     */
    public String getAttribute(By by, String attr) throws IOException {
        WebElement webElement = findElementBy(by);
        return  webElement.getAttribute(attr);
    }

    /**
     * Method to return attribute
     * @param webElement
     * @param attr
     * @return
     * @throws IOException
     */
    public String getAttribute(WebElement webElement, String attr) throws IOException {
        return  webElement.getAttribute(attr);
    }

    /**
     * Method to select by visible text
     * @param by
     * @param textValue
     * @throws IOException
     */
    public void selectByVisibleText(By by, String textValue) throws IOException {
        WebElement selectBox = findElementBy(by);
        Select select = new Select(selectBox);
        select.selectByVisibleText(textValue);
    }

    /**
     * Method to select by visible text
     * @param webElement
     * @param textValue
     * @throws IOException
     */
    public void selectByVisibleText(WebElement webElement, String textValue) throws IOException {
        Select select = new Select(webElement);
        select.selectByVisibleText(textValue);
    }

    /**
     * Method to select checkbox
     * @param by
     * @return
     */
    public boolean selectCheckBox(By by) throws IOException {
        WebElement webElement = findElementBy(by);
        if (webElement.isSelected()){
            return true;
        }
        webElement.click();
        return true;
    }

    /**
     * Method to select checkbox
     * @param webElement
     * @return
     */
    public boolean selectCheckBox(WebElement webElement){
        if (webElement.isSelected()){
            return true;
        }
        webElement.click();
        return true;
    }

    public boolean isTextPresentOnPage(String text){
        String pageSource = driver.getPageSource();
        if(pageSource.contains(text)){
            return true;
        }
        return false;
    }
}
