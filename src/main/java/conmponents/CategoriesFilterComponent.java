package conmponents;

import data.CoursesCategoryData;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoriesFilterComponent extends AbsBaseComponent{
    public CategoriesFilterComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='ReactCollapse--content'] label")
    private List<WebElement> checkboxLabels;

    private String checkboxInputLocatorTemplate = "//label[text()='%s']/..//input[@type='checkbox']";

    public CategoriesFilterComponent checkboxStatusShouldBeSameAs(CoursesCategoryData categoryData, boolean expectedStatus){
        String locator = String.format(checkboxInputLocatorTemplate, categoryData.getName());
        Assertions.assertThat($(By.xpath(locator)).isSelected())
                .as("checkbox status is wrong")
                .isTrue();

        return this;
    };
}
