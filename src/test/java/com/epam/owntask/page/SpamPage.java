package com.epam.owntask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/24/2016.
 */
public class SpamPage extends AbstractPage{
    @FindBy(xpath = "//span[contains(text(),'Удалить все письма со спамом')]")
    private WebElement fieldOpenSpamPage;

    public SpamPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSpamPage() throws InterruptedException {
        Thread.sleep(2000);
        return fieldOpenSpamPage.isEnabled();
    }
}
