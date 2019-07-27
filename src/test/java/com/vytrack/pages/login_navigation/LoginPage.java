package com.vytrack.pages.login_navigation;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //we are
    private WebDriver driver = Driver.getDriver();

    @FindBy(id = "prependedInput")
    public WebElement userNameElement;

    @FindBy(name = "_password")
    public WebElement passwordElement;

    @FindBy(id="_submit")
    public WebElement loginButtonElement;

    @FindBy(id = "remember_me")
    public WebElement rememberMeElement;

    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;

    @FindBy(tagName = "h2")
    public WebElement titleElement;

    @FindBy(css = "[class='alert alert-error'] > div")
    public WebElement errorMessageElement;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }
}
