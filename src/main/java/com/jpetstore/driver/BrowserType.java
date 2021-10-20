package com.jpetstore.driver;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;

import static com.jpetstore.util.Helper.isWebDriverManager;

public enum BrowserType implements DriverSetup{
    CHROME {
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOption();
            return capabilities;
        }

        @Override
        public ChromeOptions getBrowserOption() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--window-size=1920,1090");
            chromeOptions.setAcceptInsecureCerts(true);
            return chromeOptions;
        }

        @Override
        public WebDriver getWebDriver() throws IOException {
            String browserPath = PropertyReader.getInstance().getProperty(PropKey.CHROME_DRIVER_PATH.getPropVal());

            if(isWebDriverManager()){
                WebDriverManager.chromedriver().setup();
            }
            else{
                System.setProperty("webdriver.chrome.driver", browserPath);

            }

            ChromeOptions chromeOptions = getBrowserOption();
            return new ChromeDriver(chromeOptions);

        }
    },

    FIREFOX{
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOption();
            return capabilities;
        }

        @Override
        public FirefoxOptions getBrowserOption() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();

            //Accept Untrusted Certificates
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);

            //Set Firefox profile to capabilities
            firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);

            return firefoxOptions;
        }

        @Override
        public WebDriver getWebDriver() throws IOException {
            String browserPath = PropertyReader.getInstance().getProperty(PropKey.FIREFOX_DRIVER_PATH.getPropVal());

            if(isWebDriverManager()){
                WebDriverManager.chromedriver().setup();
            }
            else{
                System.setProperty("webdriver.gecko.driver", browserPath);

            }

            FirefoxOptions firefoxOptions = getBrowserOption();
            return new FirefoxDriver(firefoxOptions);

        }
        }
    };



