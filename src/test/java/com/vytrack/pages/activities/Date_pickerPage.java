package com.vytrack.pages.activities;

import com.vytrack.utilities.TestBase;
import javafx.application.Application;
import javafx.stage.Stage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Date_pickerPage extends TestBase {


   //LOCATORS
    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEventBtn;
    @FindBy(css = "[id^='oro_calendar_event_form_title']")
    public WebElement titleInputLocator;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDateLocator;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDateLocator;
    @FindBy(css = "a[title='Grid Settings']")
    public WebElement gridSettingsElement;
    @FindBy(css = "a[title='Reset']")
    public WebElement resetBtnElement;
    @FindBy(css = ".grid-header-cell__label")
    public List<WebElement> headers;
    @FindBy(css = "select[class='ui-datepicker-month']")
    public WebElement selectMonth;
    @FindBy(css = "select[class='ui-datepicker-year']")
    public WebElement selectYear;



}


