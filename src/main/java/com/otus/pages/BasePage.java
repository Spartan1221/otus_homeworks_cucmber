package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.di.GuiceScooped;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.otus.pageobject.PageObject;

public abstract class BasePage<T> extends PageObject<T> {

    @Inject
    public BasePage(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }

    private String baseUrl = System.getProperty("webdriver.base.url", "https://otus.ru");

    @FindBy(tagName = "h1")
    private WebElement header;

    public T headerShouldBeSameAs(String expectedHeader){
        Assertions.assertThat(this.header.getText())
                .as("заголовок не соответствует ожиданиям")
                .isEqualTo(expectedHeader);

        return (T)this;
    }

    private String getPath(){
        Path path = getClass().getAnnotation(Path.class);
        if (path != null){
            return path.value();
        }
        return "";
    }

    public T open(){
        driver.get(baseUrl + getPath());
        return (T) this;
    }

}
