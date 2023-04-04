package com.otus.steps.pages;

import com.google.inject.Inject;
import com.otus.pages.CoursesCatalogPage;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;

public class CoursesCatalogPageSteps {

    @Inject
    public CoursesCatalogPage coursesCatalogPage;

    @Если("Открыть страницу курсов")
    public void openPage(){
        coursesCatalogPage.open();
    }

    @Тогда("Выводится информация о самом (.*) курсе")
    public void selectMostOrLeastExpensiveCourse(String type){
        //TODO use jsoup
    }
}
