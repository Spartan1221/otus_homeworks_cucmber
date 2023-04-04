package com.otus.steps.components;

import com.google.inject.Inject;
import com.otus.conmponents.CourseCardComponent;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;

public class CourseCardComponentSteps {

    @Inject
    public CourseCardComponent courseCardComponent;

    @Если("Нажать на курс {string}")
    public void clickOnCourseByTitle(String title){
        courseCardComponent.clickOnCourseByTitle(title);
    }

}
