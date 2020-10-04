package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver = null;

    @BeforeClass
    public void set_up() {
        System.out.println("Before class");
        Webdriver chrome_driver = new Webdriver();
        driver = chrome_driver.get_chrome_driver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tear_down() {
        System.out.println("After class");
        driver.close();
        driver.quit();
    }
}
