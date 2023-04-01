package com.otus.conmponents.popups;

import com.google.inject.Inject;
import com.otus.annotations.Popup;
import com.otus.di.GuiceScooped;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Popup("css:.js-header3-popup:not[style*='none']")
public class MenuPopup extends AbsBasePopup<MenuPopup> {

    @Inject
    public MenuPopup(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }

    @FindBy(css = "[data-name='learning'] > .js-header3-popup-container .header3__card-recommendation-header-sub-chunk")
    private WebElement recommendationBlock;

    public MenuPopup recommendationBlockVisible() {
        Assertions.assertThat(this.baseWaiters.waitVisibleElement(recommendationBlock))
                .isTrue();

        return this;
    };

}
