package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.di.GuiceScooped;
import org.openqa.selenium.WebDriver;

@Path("/courses")
public class CoursesCatalogPage extends BasePage<CoursesCatalogPage> {

    @Inject
    public CoursesCatalogPage(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }
}