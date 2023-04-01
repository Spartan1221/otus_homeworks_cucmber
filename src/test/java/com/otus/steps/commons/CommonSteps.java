package com.otus.steps.commons;

import com.google.inject.Inject;
import com.otus.di.GuiceScooped;
import com.otus.selenium.WebDriverFactory;
import io.cucumber.java.ru.Пусть;

public class CommonSteps {

    @Inject
    public GuiceScooped guiceScooped;

    @Пусть("Открываем браузер {string}")
    public void openBrowser(String browserName){
        guiceScooped.driver = new WebDriverFactory().getDriver(browserName);
    }
}
