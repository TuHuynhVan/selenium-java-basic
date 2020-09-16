package com.dotdash.pageobject;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DnDPage {

    private WebDriver driver;
    private WebElement from;
    private WebElement to;
    private String left_column_text_before_dnd = "";
    private String right_column_text_before_dnd = "";

    private final By left_element = By.id("column-a");
    private final By right_element = By.id("column-b");

    public DnDPage(WebDriver driver) {
        this.driver = driver;
    }

    public DnDPage dnd_left_to_right() {
        this.from = this.driver.findElement(left_element);
        this.to = this.driver.findElement(right_element);
        this.left_column_text_before_dnd = from.getText();
        this.right_column_text_before_dnd = to.getText();
        this.from(from).to(to).perform_drag_n_drop();
        return this;
    }

    public DnDPage dnd_right_to_left() {
        this.from = this.driver.findElement(right_element);
        this.to = this.driver.findElement(left_element);
        this.left_column_text_before_dnd = to.getText();
        this.right_column_text_before_dnd = from.getText();
        this.from(from).to(to).perform_drag_n_drop();
        return this;
    }

    public void verify_text_after_dnd() {
        String left_column_text_after_dnd = driver.findElement(left_element).getText();
        String right_column_text_after_dnd = driver.findElement(right_element).getText();

        Assert.assertEquals(left_column_text_after_dnd, right_column_text_before_dnd, "[ERR] DnDPage failed!");
        Assert.assertEquals(right_column_text_after_dnd, left_column_text_before_dnd, "[ERR] DnDPage failed!");
    }

    private DnDPage from(WebElement from) {
        this.from = from;
        return this;
    }

    private DnDPage to(WebElement to) {
        this.to = to;
        return this;
    }

    public void perform_drag_n_drop() {
        Actions action = new Actions(this.driver);
        action.dragAndDrop(from, to).perform();
    }

}
