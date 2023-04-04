package com.otus.pages;

import com.google.inject.Inject;
import com.otus.di.GuiceScooped;

public class CoursePage extends BasePage<CoursePage>{

    @Inject
    public CoursePage(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }

    public void pageShouldBeOpened(){

    }
}
