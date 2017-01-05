package com.epam.owntask.page;

import com.epam.owntask.entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Davud_Murtazin on 12/29/2016.
 */
public class TrashPage extends AbstractPage{
    public TrashPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasAnyMessageWithAttachment(User user){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class= 'F cf zt']/descendant-or-self::span[@email = '"+user.getLogin()+"']"));
        return elements.isEmpty();
    }
}
