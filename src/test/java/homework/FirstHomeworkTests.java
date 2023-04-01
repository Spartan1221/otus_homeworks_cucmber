package homework;

import com.otus.annotations.Driver;
import com.otus.conmponents.CourseCardComponent;
import com.otus.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class FirstHomeworkTests {

    @Driver
    public WebDriver driver;

    /*@Test
    public void filterCoursesTest(){
        new MainPage(driver)
                .open();

        List<WebElement> collect = new CourseCardComponent(driver)
                .getCourseTitles()
                .stream()
                .filter(element -> element.getText().equals("Специализация Python"))
                .collect(Collectors.toList());

        assertThat(collect)
                .as("Ожидалось нахождение 1 курса")
                .hasSize(1);
    }

    @Test
    public void clickOnLatestCourseTest(){
        new MainPage(driver).open();
        new CourseCardComponent(driver)
                .clickOnCourseByBoundaryDate(true);
    }

    @Test
    public void clickOnEarliestCourseTest() {
        new MainPage(driver).open();
        new CourseCardComponent(driver)
                .clickOnCourseByBoundaryDate(false);
    }*/
}
