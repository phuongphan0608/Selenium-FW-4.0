package com.jpetstore.util;

import io.qameta.allure.Step;

import java.io.IOException;

public class LogHelper {

    /**
     * Method  to log step information to report
     * @param message
     * @return
     */
    public static synchronized boolean logToReport(String message) throws IOException {

        boolean isLogEnabled = PropertyReader.getInstance().getProperty(PropKey.ALLURE_REPORT_STEP_LOG.getPropVal())
                .equalsIgnoreCase("ENABLE");
        if(isLogEnabled){
            logToAllureReport(message);
            return true;
        }
        return false;

    }
    @Step("{0}")
    private static synchronized void logToAllureReport(String message){

    }
}
