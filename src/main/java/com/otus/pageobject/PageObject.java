package com.otus.pageobject;

import com.google.inject.Inject;
import com.otus.di.GuiceScooped;
import com.otus.waiters.BaseWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject<T> {

    protected WebDriver driver;
    protected Actions actions;

    protected BaseWaiters baseWaiters;

    @Inject
    public PageObject(GuiceScooped guiceScooped) {
        this.driver = guiceScooped.driver;
        this.actions = new Actions(driver);
        this.baseWaiters = new BaseWaiters(guiceScooped);

        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
}
