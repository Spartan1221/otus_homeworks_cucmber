package com.example.otus_homeworks;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@ExtendWith(UIExtension.class)
public class LolTest {

    @Driver
    public WebDriver driver;

    @Test
    public void rightClickAction() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightButtonElement = driver.findElement(By.cssSelector("span.context-menu-one"));
        Actions actions = new Actions(driver);
        rightButtonElement.click();
        actions.contextClick(rightButtonElement).build().perform();
    }

}
