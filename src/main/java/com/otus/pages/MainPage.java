package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.di.GuiceScooped;


@Path("/")
public class MainPage extends BasePage<MainPage> {

    @Inject
    public MainPage(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }


}
