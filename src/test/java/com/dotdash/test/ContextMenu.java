package com.dotdash.test;

import com.dotdash.com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.ContextMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenu {

    private WebDriver chrome_driver;

    @BeforeClass
    public void init() {
        Webdriver web_driver = new Webdriver();
        chrome_driver = web_driver.get_chrome_driver();
        web_driver.open_page("context_menu");
    }

    @Test
    public void able_to_click_on_target_area() {
        ContextMenuPage context_menu_page = new ContextMenuPage(chrome_driver);
        context_menu_page
                .right_click_on_target_area()
                .is_alert_displayed();
    }

    @AfterClass
    public void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
