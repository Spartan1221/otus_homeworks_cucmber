package com.otus.steps.pages;

import com.google.inject.Inject;
import com.otus.pages.PreparingCoursePage;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;

public class PreparingCoursePageSteps {

    @Inject
    public PreparingCoursePage preparingCoursePage;

    @Если("Открыть страницу подготовительных курсов")
    public void openPage(){
        preparingCoursePage.open();
    }

    @Тогда("^Выводится информация о самом (.*) курсе")
    public void selectMostOrLeastExpensiveCourse(String type){
        preparingCoursePage.printMostOrLeastExpensiveCourseData(type);
    }
}
