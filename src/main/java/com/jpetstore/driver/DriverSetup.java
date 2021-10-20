package com.jpetstore.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface DriverSetup {
    Capabilities getBrowserCapabilities();
    Object getBrowserOption();
    WebDriver getWebDriver() throws IOException;
}
