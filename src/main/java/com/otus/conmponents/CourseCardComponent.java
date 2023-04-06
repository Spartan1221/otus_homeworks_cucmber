package com.otus.conmponents;

import com.google.inject.Inject;
import com.otus.di.GuiceScooped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CourseCardComponent extends AbsBaseComponent {

    @Inject
    public CourseCardComponent(GuiceScooped guiceScooped) {
        super(guiceScooped);
    }

    private String lessonsTitleSelector = ".lessons__new-item-title";
    private String courseStartDateOneSelector = ".lessons__new-item-bottom div[class='lessons__new-item-start']";
    private String courseStartDateTwoSelector = "div.lessons__new-item-bottom.lessons__new-item-bottom_spec > div.lessons__new-item-time";

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM", Locale.forLanguageTag("ru"));

    @FindBy(css = ".lessons__new-item-container")
    private List<WebElement> coursesItems;

    public List<WebElement> getCourseItems() {
        return List.copyOf(coursesItems);
    }

    public Map<String, Date> getCourseTitlesAndDates(List<WebElement> courseItems){
        Map<String, Date> result = new HashMap<>();

        for (WebElement webElement : courseItems){
            String courseTitle = webElement.findElement(By.cssSelector(lessonsTitleSelector)).getText();

            List<WebElement> elements = webElement.findElements(By.cssSelector(courseStartDateOneSelector));
            if (elements.size() != 0){
                Stream.of(elements.get(0))
                        .map(element -> element.getText().replace("С ", ""))
                        .map(s -> parseDate(s))
                        .findFirst()
                        .ifPresent(date -> result.put(courseTitle, date));
            }else {
                WebElement webElement1 = webElement.findElement(By.cssSelector(courseStartDateTwoSelector));
                Stream.of(webElement1)
                        .filter(element -> Pattern.matches("\\d+\\s+[а-яёА-ЯЁ]+\\s+\\d+\\s+[а-яёА-ЯЁ]+", element.getText()))
                        .map(element -> element.getText().replaceFirst("\\d+\\s+месяцев|месяца", ""))
                        .map(s -> parseDate(s.replaceAll("\\s+", " ")))
                        .findFirst()
                        .ifPresent(date -> result.put(courseTitle, date));
            }
        }

        return result;
    }

    private Date parseDate(String text){
        try {
            return simpleDateFormat.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clickOnCourseByTitle(String title) {
        actions.moveToElement(driver.findElement(By.partialLinkText(title)))
                .click()
                .perform();
    }

    public void printCourseData(String startDate){
        List<WebElement> courseItems = getCourseItems();
        Map<String, Date> courseTitlesAndDates = getCourseTitlesAndDates(courseItems);

        Date date = parseDate(startDate);

        if (courseTitlesAndDates.containsValue(date)){
            for (Map.Entry<String, Date> entry : courseTitlesAndDates.entrySet()) {
                if (entry.getValue().equals(date)){
                    printData(entry);
                }
            }
        }else {
            for (Map.Entry<String, Date> entry : courseTitlesAndDates.entrySet()) {
                if (entry.getValue().after(date)){
                    printData(entry);
                }
            }
        }
    }

    private void printData(Map.Entry<String, Date> entry){
        System.out.println("Имя курса =  " + entry.getKey() + " Дата начала = " + simpleDateFormat.format(entry.getValue()));
    }
}
