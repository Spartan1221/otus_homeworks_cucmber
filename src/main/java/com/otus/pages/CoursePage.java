package com.otus.pages;

import com.google.inject.Inject;
import com.otus.di.GuiceScooped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class CoursePage extends BasePage<CoursePage>{

    @Inject
    public CoursePage(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }

    public void pageShouldBeOpened() {
        WebElement webElement = driver.findElement(By.partialLinkText("Оставить заявку"));
        assertThat(webElement.isDisplayed())
                .as("")
                .isTrue();
    }
}
