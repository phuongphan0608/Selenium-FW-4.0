package com.jpetstore.tests;

import com.jpetstore.driver.DriverManager;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.jpetstore.tags.JPetStoreTags.DRAFT;
import static com.jpetstore.util.PropKey.PORT;
import static com.jpetstore.util.PropKey.URL;

//@Disabled
@DisplayName("My First browser")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)

public class MyFirstTest extends DriverManager{
    @Tag(SMOKE)
    @Test
    @DisplayName("This is my first selenium test !!!")
    void this_is_my_first_selenium_test() throws InterruptedException, IOException {

        String url = prop.getProperty(URL.getPropVal());
        String port = prop.getProperty(PORT.getPropVal());
        String finalUrl = url + port;
        driver.get(finalUrl);
        Thread.sleep(4000);
    }

}
