package com.dotdash.test;

import com.dotdash.com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.DnDPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DnD {
    private WebDriver chrome_driver;

    @BeforeClass
    public void init() {
        Webdriver web_driver = new Webdriver();
        chrome_driver = web_driver.get_chrome_driver();
        web_driver.open_page("drag_and_drop");
    }

    @Test
    public void able_to_dnd_left_to_right() {
        DnDPage dnd_page = new DnDPage(chrome_driver);
        dnd_page.dnd_left_to_right().verify_text_after_dnd();
    }

    @Test
    public void able_to_dnd_right_to_left() {
        DnDPage dnd_page = new DnDPage(chrome_driver);
        dnd_page.dnd_right_to_left().verify_text_after_dnd();
    }

    @AfterClass
    public void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
