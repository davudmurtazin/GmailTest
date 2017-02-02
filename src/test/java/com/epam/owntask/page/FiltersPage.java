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

    @FindBy(xpath = "//td[@class='rG']/span/preceding-sibling::span")
    private WebElement buttonCreateFilter;

    @FindBy(xpath = "//div[@class='SK ZF-zT']/descendant-or-self::input[@class='ZH nr aQa']")
    private WebElement inputLoginFromWhom;

    @FindBy(xpath = "//input[@class='ZH nr aQf']")
    private WebElement inputLoginToWhom;

    @FindBy(xpath = "//div[@class='w-Nw']/span[@class='w-Pv ZG']/preceding-sibling::span/input[@type='checkbox']")
    private WebElement checkBoxHasAttach;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji Zx aQe T-I-atl L3']/following-sibling::div")
    private WebElement buttonContinueCreatingFilter;

    @FindBy(xpath = "//label[contains(text(),'Delete it')]/preceding-sibling::input")
    private WebElement checkBoxDelete;

    @FindBy(xpath = "//label[contains(text(),'Always mark it as important')]/preceding-sibling::input")
    private WebElement checkBoxMarkAsImportant;

    @FindBy(xpath = "//div[contains(text(),'Create filter')]")
    private WebElement buttonEndCreateFilter;

    public FiltersPage(WebDriver driver) {
        super(driver);
    }

    public void createNewFilter(User userFrom, User userTo){
        wait.waitForElementIsClickable(buttonCreateFilter).click();
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
