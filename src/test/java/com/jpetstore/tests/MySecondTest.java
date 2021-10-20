package com.jpetstore.tests;

import com.jpetstore.driver.DriverManager;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.jpetstore.tags.JPetStoreTags.DRAFT;

//@Disabled
@DisplayName("My Second browser")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)

public class MySecondTest extends DriverManager {

    @Tag(DRAFT)
    @Test
    @DisplayName("This is my second selenium test !!!")
    void this_is_my_second_selenium_test() throws InterruptedException, IOException {
        String url = prop.getProperty("url");
        String port = prop.getProperty("port");
        String finalUrl = url + port ;
        driver.get(finalUrl);
        Thread.sleep(4000);
    }


}
