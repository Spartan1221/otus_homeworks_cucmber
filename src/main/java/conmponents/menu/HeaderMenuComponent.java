package conmponents.menu;

import conmponents.AbsBaseComponent;
import data.HeaderMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class HeaderMenuComponent extends AbsBaseComponent {
    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }

    private String headerMenuSelector = "[data-name='$s']";

    public void moveToHeaderMenu(HeaderMenuData headerMenuData){
        String selector = String.format(headerMenuSelector, headerMenuData.name().toLowerCase(Locale.ROOT));
        this.actions.moveToElement($(By.cssSelector(selector)))
                .build()
                .perform();

    }
}
