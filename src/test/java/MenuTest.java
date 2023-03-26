import annotations.Driver;
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

    }
}
