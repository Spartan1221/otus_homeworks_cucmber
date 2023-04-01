package com.otus.selenium;

import com.otus.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;

public interface IWebDriverFactory {

    WebDriver getDriver(String browserName) throws DriverTypeNotSupported;
}
