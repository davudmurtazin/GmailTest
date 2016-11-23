package com.epam.owntask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Davud_Murtazin on 11/23/2016.
 */
public class LogoutPage extends AbstractPage{
    @FindBy(xpath = "//a[@class = 'gb_b gb_db gb_R']/span")
    private WebElement logoutIcon;
    @FindBy(xpath = "//a[text() = 'Выйти']")
    private WebElement logoutButton;
    @FindBy(xpath = "//a[@id='account-chooser-link']")
    private WebElement loginNewUser;
    @FindBy(xpath = "//a[@id='account-chooser-add-account']")
    private WebElement loginNewUserChooseAccount;
    @FindBy(xpath = "html/body/div/div[2]/div[1]/h1")
    private WebElement bannerAvailability;

    public boolean logout(){
        boolean flag = false;
        try {
            logoutIcon.click();
            logoutButton.click();
            Thread.sleep(500);
            loginNewUser.click();
            Thread.sleep(1000);
            loginNewUserChooseAccount.click();
            Thread.sleep(1500);
            if(bannerAvailability.isEnabled()){
                return true;
            }
            else return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean logoutSecond(){
        boolean flag = false;
        try {
            logoutIcon.click();
            logoutButton.click();
            Thread.sleep(500);
            loginNewUserChooseAccount.click();
            Thread.sleep(1500);
            if(bannerAvailability.isEnabled()){
                return true;
            }
            else return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }


}
