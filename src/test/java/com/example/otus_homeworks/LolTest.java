package com.example.otus_homeworks;

import annotations.Driver;
import data.CoursesCategoryData;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class LolTest {

    @Driver
    public WebDriver driver;

    @Test
    public void rightClickAction() {
        new MainPage(driver)
                .open()
                .clickCategoryCourseLinkByName(CoursesCategoryData.Progamming)
                .headerShouldBeSameAs("Каталог");
    }

}
