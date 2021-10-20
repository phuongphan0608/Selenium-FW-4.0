package com.jpetstore.util;

import java.io.IOException;

public class TimeUtil {
    /**
     * Method to retun Implicit wait
     * @return
     * @throws IOException
     */
    public static long getImplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance()
                .getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    public static long getExplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance()
                .getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
    }
}
