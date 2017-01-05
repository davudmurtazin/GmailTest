package com.epam.owntask.step;

import com.epam.owntask.entity.User;
import com.epam.owntask.page.FiltersPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Davud_Murtazin on 12/24/2016.
 */
public class FiltersPageSteps extends AbstractSteps {
    private FiltersPage filtersPage;

    public FiltersPageSteps(WebDriver driver) {
        super(driver);
        filtersPage = new FiltersPage(driver);
    }

    public MainPageSteps createNewFilter (User userFrom, User userTo){
        log.info("Creating new filter");
        filtersPage.createNewFilter(userFrom, userTo);
        return new MainPageSteps(driver);
    }
}
