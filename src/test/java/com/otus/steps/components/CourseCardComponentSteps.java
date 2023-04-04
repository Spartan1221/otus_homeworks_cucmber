package com.otus.steps.components;

import com.google.inject.Inject;
import com.otus.conmponents.CourseCardComponent;
import io.cucumber.java.ru.Если;

public class CourseCardComponentSteps {

    @Inject
    public CourseCardComponent courseCardComponent;

    @Если("Кликнуть на (.*) плитку курса")
    public void clickCourseEarlyLast(String earlyLast){
        boolean isEarly = earlyLast.equals("раннего");
        courseCardComponent.clickOnCourseByBoundaryDate(isEarly);
    }
}
