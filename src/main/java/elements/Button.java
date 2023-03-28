package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.PageObject;

public class Button<T> extends PageObject<Button>  {

    private WebElement element;

    public Button(WebDriver driver, By by) {
        super(driver);
        this.element = findElement(by);
    }

    public void click() {
        this.element.click();
    }
}
