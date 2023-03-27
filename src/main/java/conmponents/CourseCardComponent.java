package conmponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CourseCardComponent extends AbsBaseComponent {

    public CourseCardComponent(WebDriver driver) {
        super(driver);
    }

    private String lessonsTitleSelector = ".lessons__new-item-title";
    private String courseStartDateOneSelector = ".lessons__new-item-bottom div[class='lessons__new-item-start']";
    private String courseStartDateTwoSelector = " div.lessons__new-item-bottom.lessons__new-item-bottom_spec > div.lessons__new-item-time";

    public List<WebElement> getCourseTitles() {
        return driver.findElements(By.cssSelector(lessonsTitleSelector));
    }

    public String getCourseDates() {

        List<WebElement> elements = driver.findElements(By.cssSelector(courseStartDateOneSelector));

        driver.findElements(By.cssSelector(courseStartDateOneSelector))
                .addAll(driver.findElements(By.cssSelector(courseStartDateOneSelector)));

        List<Date> dateList = driver.findElements(By.cssSelector(courseStartDateOneSelector))
                .stream()
                .map(element -> element.getText().replace("С ", ""))
                .map(s -> parseDate(s))
                .collect(Collectors.toList());

        List<Date> dateList1 = driver.findElements(By.cssSelector(courseStartDateTwoSelector))
                .stream()
                //TODO fix it
                .filter(element -> Pattern.matches("\\w{4}", element.getText()))
                .map(element -> element.getText().substring(0, element.getText().lastIndexOf(" ")))
                .map(s -> parseDate(s))
                .collect(Collectors.toList());
        dateList.addAll(dateList1);

        Date firstDate = dateList
                .stream()
                .reduce((date, date2) -> date.after(date2) ? date : date2)
                .get();

        //TODO add other format
        return "";
    }

    private Date parseDate(String text){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM", Locale.forLanguageTag("ru"));
        try {
            return simpleDateFormat.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
