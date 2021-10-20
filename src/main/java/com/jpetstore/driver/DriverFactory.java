package com.jpetstore.driver;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.jpetstore.util.TimeUtil.getImplicitWait;

public class DriverFactory {
    public static PropertyReader prop;

    protected static WebDriver driver = null;

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Method to start WebDriver
     * @return
     * @throws IOException
     */
    public static WebDriver getDriver()  {

        if(driver == null){
            try {
                driverThreadLocal.set(getBrowser().getWebDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
//            driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitWait()));
            driverThreadLocal.get().manage().timeouts().implicitlyWait(getImplicitWait(),TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driverThreadLocal.get();
    }

    /**
     * Method to quit  WebDriver
     */
    public static void quitDriver(){
        driverThreadLocal.get().quit();
    }

    /**
     * Determin Browser
     * @return
     * @throws IOException
     */
    private static BrowserType getBrowser() throws IOException {
        if(prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("CHROME")){
            return BrowserType.CHROME;
        } else if(prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("FIREFOX")){
            return BrowserType.FIREFOX;
        }
        else {
            return BrowserType.FIREFOX;
        }
    }
}
