package com.otus.steps.pages;

import com.google.inject.Inject;
import com.otus.conmponents.CourseCardComponent;
import com.otus.pages.MainPage;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MainPageSteps {

    @Inject
    public MainPage mainPage;

    @Inject
    public CourseCardComponent courseCardComponent;

    @Если("Открыть главную страницу")
    public void openPage(){
        mainPage.open();
    }

    @Тогда("На главной странице отображается заголовок {string}")
    public void mainPageHeaderShouldBeVisible(String headerText){
        mainPage.headerShouldBeSameAs(headerText);
    }

    @Тогда("Выводим информацию в консоль о курсах стартующих на {string} или позже указанной даты")
    public void printCourseInfo(String startDate){
        courseCardComponent.printCourseData(startDate);
        //TODO if in send data has course when print about it
        //TODO if there's no info about course in that day than print all courses
    }
}
