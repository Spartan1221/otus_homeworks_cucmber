package com.otus.di;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class GuiceScooped {

    //public WebDriver driver = new WebDriverFactory().getDriver();

    public WebDriver driver;

}
