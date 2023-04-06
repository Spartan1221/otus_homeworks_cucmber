package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.di.GuiceScooped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/online")
public class PreparingCoursePage extends BasePage<PreparingCoursePage> {

    @Inject
    public PreparingCoursePage(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }

    @FindBy(css = ".lessons__new-item-container")
    private List<WebElement> coursesItems;

    private String lessonsTitleSelector = ".lessons__new-item-title";

    private String coursePriceSelector = "div.lessons__new-item-price";

    public List<WebElement> getCourseItems() {
        return List.copyOf(coursesItems);
    }

    public void printMostOrLeastExpensiveCourseData(String type){
        List<WebElement> courseItems = getCourseItems();
        Map<String, Integer> courseTitlesAndDates = getCourseTitlesAndPrices(courseItems);

        Map.Entry<String, Integer> stringIntegerEntry = null;

        if (type.equals("дорогой")){
            stringIntegerEntry = courseTitlesAndDates.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .get();
        }else {
            stringIntegerEntry = courseTitlesAndDates.entrySet().stream()
                    .min(Map.Entry.comparingByValue())
                    .get();
        }

        System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue());
    }

    public Map<String, Integer> getCourseTitlesAndPrices(List<WebElement> courseItems){
        Map<String, Integer> result = new HashMap<>();

        for (WebElement webElement : courseItems){
            String courseTitle = webElement.findElement(By.cssSelector(lessonsTitleSelector)).getText();
            Integer price = Integer.valueOf(webElement.findElement(By.cssSelector(coursePriceSelector)).getText().replace(" ₽", ""));
            result.put(courseTitle, price);
        }

        return result;
    }
}
