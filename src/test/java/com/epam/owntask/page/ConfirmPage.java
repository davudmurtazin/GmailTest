package com.epam.owntask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/25/2016.
 */
public class ConfirmPage extends AbstractPage {
    private String currentWindow = driver.getWindowHandle();

    @FindBy(xpath = "//td[@align = 'left']/input[3]")
    private WebElement buttonContinue;

    @FindBy(xpath = "//div[@class = 'Kj-JD-Jl']/button[@class='J-at1-auR']")
    private WebElement buttonOKConfirmInfo;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public void confirmForward(){
        switchUtil.switchWindow();
        buttonContinue.click();
        driver.switchTo().window(currentWindow);
        buttonOKConfirmInfo.click();
    }
}
