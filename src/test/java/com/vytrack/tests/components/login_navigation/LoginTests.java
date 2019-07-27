package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest1(){
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);
    }
}
