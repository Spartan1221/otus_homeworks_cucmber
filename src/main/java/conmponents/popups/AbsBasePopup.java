package conmponents.popups;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsBasePopup<T>  extends PageObject<T> implements IPopup<T> {

    public AbsBasePopup(WebDriver driver) {
        super(driver);
    }


}
