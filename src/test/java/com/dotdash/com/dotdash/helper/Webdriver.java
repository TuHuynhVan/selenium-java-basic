package com.dotdash.com.dotdash.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver {

    private WebDriver driver = null;

    public  Webdriver() {
        String path = System.getProperty("user.dir");
        String chrome_driver_path = path + "/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chrome_driver_path);
        driver = new ChromeDriver();
    }

    public WebDriver get_chrome_driver() {
        return driver;
    }

    public void open_page(String path) {
        driver.get("http://localhost:7080/" + path);
    }
}
