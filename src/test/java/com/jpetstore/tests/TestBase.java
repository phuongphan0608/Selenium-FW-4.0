package com.jpetstore.tests;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class TestBase {
    static WebDriver driver;
    static PropertyReader prop = PropertyReader.getInstance();
    @BeforeAll
    public static void init() throws IOException {
        if(prop.getProperty(PropKey.BROWSER.getPropVal())
                        .equalsIgnoreCase("CHROME")){

            if (prop.getProperty(PropKey.BROWSERMANAGER.getPropVal())
                .equalsIgnoreCase("webDriverManager")){
                    WebDriverManager.chromedriver().setup();
            } else {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/mac/chromedriver");
            }
            driver = new ChromeDriver();
        }else if(prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("FIREFOX")) {
            if (prop.getProperty(PropKey.BROWSERMANAGER.getPropVal())
                    .equalsIgnoreCase("webDriverManager")) {

                WebDriverManager.firefoxdriver().setup();

            } else {

                System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/mac/geckodriver");
            }
            driver = new FirefoxDriver();

        }
    }

    @AfterAll
    public static void cleanUp() {
        driver.quit();
    }
}
