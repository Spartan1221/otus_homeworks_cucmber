package com.otus.conmponents;

import com.google.inject.Inject;
import com.otus.di.GuiceScooped;
import org.openqa.selenium.WebDriver;
import com.otus.pageobject.PageObject;

public abstract class AbsBaseComponent<T> extends PageObject<T> {

    @Inject
    public AbsBaseComponent(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }


}
