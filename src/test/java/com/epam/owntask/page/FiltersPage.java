package com.epam.owntask.page;

import com.epam.owntask.entity.User;
import com.epam.owntask.util.ThreadSleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 12/24/2016.
 */
public class FiltersPage extends AbstractPage {
    //div[@class='nH f2 hCyPr']/div/div[5]/div/table[@class='cf']/tbody/tr[6]/td/span[1]
    @FindBy(xpath = "//td[@class='rG']/span[1]")
    private WebElement buttonCreateFilter;

    @FindBy(xpath = "//div[@class='SK ZF-zT']/descendant-or-self::input[@class='ZH nr aQa']")
    private WebElement inputLoginFromWhom;

    @FindBy(xpath = "//input[@class='ZH nr aQf']")
    private WebElement inputLoginToWhom;

    @FindBy(xpath = "//div[@class='ZZ']/div[7]/span[1]/input[1]")
    private WebElement checkBoxHasAttach;

    @FindBy(xpath = "//div[@class='ZZ']/div[9]/div[2]")
    private WebElement buttonContinueCreatingFilter;

    @FindBy(xpath = "//div[@class='nH']/div[6]/label")
    private WebElement checkBoxDelete;

    @FindBy(xpath = "//div[@class='nH']/div[8]/label")
    private WebElement checkBoxMarkAsImportant;

    @FindBy(xpath = "//div[@class='ZZ']/div[5]/div")
    private WebElement buttonEndCreateFilter;

    public FiltersPage(WebDriver driver) {
        super(driver);
    }

    public void createNewFilter(User userFrom, User userTo){
        ThreadSleep.waitElement(2000);
        wait.waitForElementIsClickable(buttonCreateFilter).click();
        ThreadSleep.waitElement(3000);
        wait.waitForElementIsClickable(inputLoginFromWhom).sendKeys(userFrom.getLogin());
        wait.waitForElementIsClickable(inputLoginToWhom).sendKeys(userTo.getLogin());
        checkBoxHasAttach.click();
        buttonContinueCreatingFilter.click();
        driver.switchTo().activeElement();
        checkBoxDelete.click();
        checkBoxMarkAsImportant.click();
        buttonEndCreateFilter.click();
        driver.switchTo().activeElement();
    }
}
