import annotations.Driver;
import conmponents.menu.HeaderMenuComponent;
import conmponents.popups.IPopup;
import conmponents.popups.MenuPopup;
import data.HeaderMenuData;
import data.ModalStateData;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class MenuTest {

    @Driver
    private WebDriver driver;

    @Test
    public void checkCourseBlockInLearningMenuTest(){
        new MainPage(driver)
                .open();

        new MenuPopup(driver)
                .modalState(ModalStateData.INVISIBLE);

        new HeaderMenuComponent(driver)
                .moveToHeaderMenu(HeaderMenuData.LEARNING)
                .modalState(ModalStateData.VISIBLE)
                .recommendationBlockVisible();

    }
}
