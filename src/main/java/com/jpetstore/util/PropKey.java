package com.jpetstore.util;

public enum PropKey {
    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSERMANAGER("browserManager"),

    //Driver Paths
    CHROME_DRIVER_PATH("chromeDriverPath"),
    FIREFOX_DRIVER_PATH("firefoxDriverPath"),

    //Timeout
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait"),

    //Screenshot
    SCREENSHOT("screenshot"),
    ELEMENT_SCREENSHOT ("elementScreenshot") ,

    //ALLURE REPORT
    ALLURE_REPORT_STEP_LOG ("allureReportStepLog");
    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
