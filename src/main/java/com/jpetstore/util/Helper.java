package com.jpetstore.util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Helper {
    public static boolean isWebDriverManager() throws IOException {
        if(PropertyReader.getInstance().getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("webDriverManager")){
            return true;
        }
        return false ;
    }

    /**
     * Method to obtain property from property file
     * @return
     */
    public static String getAppUrl() throws IOException {
        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance().getProperty(PropKey.PORT.getPropVal());

        String finalUrl = baseUrl + port;
        return finalUrl;
    }

    public static synchronized boolean takeScreenshot(WebDriver driver, String name) throws IOException {
        boolean isScreenshot = PropertyReader.getInstance()
                .getProperty(PropKey.SCREENSHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if(isScreenshot){
            attachedScreenShot(driver,name);
            return true;
        }
        return false;
    }

    /**
     * Method to take screenshot
     * @param driver
     * @param name
     * @return
     */
    @Attachment (value = "{name}")
    private static synchronized byte[] attachedScreenShot (WebDriver driver, String name) throws IOException {
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Method to take webelement screebshot
     * @param webElement
     * @param name
     * @return
     * @throws IOException
     */
    public static synchronized boolean takeElementScreenshot(WebElement webElement, String name) throws IOException {
        boolean isScreenshot = PropertyReader.getInstance()
                .getProperty(PropKey.ELEMENT_SCREENSHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if(isScreenshot){
            attachedElementScreenshot(webElement,name);
            return true;
        }
        return false;
    }

    @Attachment (value = "{name}", type = "{image/png}")
    private static synchronized byte[] attachedElementScreenshot (WebElement webElement, String name){
        return webElement.getScreenshotAs(OutputType.BYTES);

    }
}
