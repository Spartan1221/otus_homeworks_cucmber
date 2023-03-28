package conmponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
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
    private String courseStartDateTwoSelector = "div.lessons__new-item-bottom.lessons__new-item-bottom_spec > div.lessons__new-item-time";

    public List<WebElement> getCourseTitles() {
        return driver.findElements(By.cssSelector(lessonsTitleSelector));
    }

    public CourseCardComponent clickOnEarliestDateCourse() {
        Date earliestDate = getListDate()
                .stream()
                .reduce((date, date2) -> date.before(date2) ? date : date2)
                .get();
        clickByCourseDate(earliestDate);

        return this;
    }

    public CourseCardComponent clickOnLatestDateCourse() {
        Date latestDate = getListDate()
                .stream()
                .reduce((date, date2) -> date.after(date2) ? date : date2)
                .get();

        clickByCourseDate(latestDate);

        return this;
    }

    private void clickByCourseDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String partialLinkText = calendar.get(Calendar.DAY_OF_MONTH)
                + " " + Month.of(calendar.get(Calendar.MONTH) + 1).getDisplayName(TextStyle.FULL, new Locale("ru"));

        this.actions.moveToElement(findElement(By.partialLinkText(partialLinkText)))
                .click()
                .build()
                .perform();
    }

    private List<Date> getListDate(){
        List<Date> dateList = driver.findElements(By.cssSelector(courseStartDateOneSelector))
                .stream()
                .map(element -> element.getText().replace("С ", ""))
                .map(s -> parseDate(s))
                .collect(Collectors.toList());
        List<Date> dateList1 = driver.findElements(By.cssSelector(courseStartDateTwoSelector))
                .stream()
                .filter(element -> Pattern.matches("\\d+ [а-яёА-ЯЁ]+ \\d+ [а-яёА-ЯЁ]+", element.getText()))
                .map(element -> element.getText().replaceFirst("\\d+ месяцев|месяца", ""))
                .map(s -> parseDate(s))
                .collect(Collectors.toList());
        dateList.addAll(dateList1);

        return dateList;
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
