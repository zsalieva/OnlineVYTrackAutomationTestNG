package com.vytrack.tests.components.activities;

import com.vytrack.pages.activities.CalendarEventsPage;
import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrackUtils;
import org.testng.annotations.Test;

public class DatePickerTest {
    @Test
    public void verifyDateTest(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarPage = new CalendarEventsPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        //login
        loginPage.login(username, password);
        //go to Calendar Events page
       VYTrackUtils.waitUntilLoaderScreenDisappear();
        VYTrackUtils.navigateToModule("Activities", "Calendar Events");
        //deselect title option from grid settings
        VYTrackUtils.waitUntilLoaderScreenDisappear();
        calendarPage.createCalendarEventBtn.click();
        //deselect title option from grid settings
        VYTrackUtils.waitUntilLoaderScreenDisappear();
   //     calendarPage.selectDate("8/5/2019", "start");
   //     calendarPage.selectDate("10/15/2019", "end");

    }

}
