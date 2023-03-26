package conmponents.popups;

import annotations.Popup;
import conmponents.AbsBaseComponent;
import org.openqa.selenium.WebDriver;

@Popup(".js-header3-popup:not[style*='none']")
public class MenuPopup extends AbsBaseComponent<MenuPopup> implements IPopup{
    public MenuPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public Object modalNotVisible() {
        return null;
    }

    @Override
    public Object modalVisible() {
        return null;
    }
}
