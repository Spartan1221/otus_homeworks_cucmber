package com.otus.selenium;

import com.otus.exceptions.DriverTypeNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public interface IWebDriver {

    String REMOTE_URL = System.getProperty("webdriver.remote.url");

    WebDriver newDriver();

    default URL getRemoteUrl() {
        try {
            return new URL(REMOTE_URL);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    default void downloadLocalWebDriver(DriverManagerType driverType) throws DriverTypeNotSupported {
        Config wdmConfig = WebDriverManager.globalConfig();
        wdmConfig.setAvoidBrowserDetection(true);

        String browserVersion = System.getProperty("browser.version", "");

        if (!browserVersion.isEmpty()) {
            switch (driverType) {
                case CHROME:
                    wdmConfig.setChromeDriverVersion(browserVersion);
                    break;
                case FIREFOX:
                    wdmConfig.setGeckoDriverVersion(browserVersion);
                    break;
                case OPERA:
                    wdmConfig.setOperaDriverVersion(browserVersion);
                    break;
                default:
                    throw new DriverTypeNotSupported(driverType);
            }
        }

        WebDriverManager.getInstance(driverType).setup();
    }
}
