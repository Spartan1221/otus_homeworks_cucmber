package com.otus.selenium;

import com.otus.exceptions.DriverTypeNotSupported;
import com.otus.selenium.chrome.ChromeWebDriver;
import com.otus.selenium.firefox.FirefoxWebDriver;
import com.otus.selenium.opera.OperaWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class WebDriverFactory implements IWebDriverFactory{



    @Override
    public EventFiringWebDriver getDriver(String browserName){
        switch (browserName) {
            case "chrome": {
                return new EventFiringWebDriver(new ChromeWebDriver().newDriver());
            }
            case "firefox": {
                return new EventFiringWebDriver(new FirefoxWebDriver().newDriver());
            }
            case "opera": {
                return new EventFiringWebDriver(new OperaWebDriver().newDriver());
            }
            default:
                try {
                    throw new DriverTypeNotSupported(browserName);
                } catch (DriverTypeNotSupported ex) {
                    ex.printStackTrace();
                    return null;
                }
        }
    }

}
