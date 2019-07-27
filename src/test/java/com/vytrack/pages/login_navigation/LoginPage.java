package com.vytrack.pages.login_navigation;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver = Driver.getDriver();

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
}
