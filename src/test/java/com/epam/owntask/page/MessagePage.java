package com.epam.owntask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class MessagePage extends AbstractPage {
    private String currentWindow = driver.getWindowHandle();

    @FindBy(xpath = "//div[@class='ii gt adP adO']/div/a[4]")
    private WebElement linkConfirmForward;

    @FindBy(xpath = "//form/p/input")
    private WebElement buttonConfirmForward;

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    public void confirmRequestForward(){
        linkConfirmForward.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()) ;
        driver.switchTo().window(tabs.get(1));
        buttonConfirmForward.click();
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
}
