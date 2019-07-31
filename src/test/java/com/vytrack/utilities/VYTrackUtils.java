package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.support.ui.Select;

public class VYTrackUtils {
    //we don't want to access these variables outside
    private static String usernamelocator = "prependedInput";
    private static String passwordLocator = "prependedInput2";
    private static String loaderMaskLocator = "div[class='loader-mask shown']";
    private static String pageSubTitleLocator = "h1[class='oro-subtitle']";
    /**
     * Login into vytrack application
     * @param driver
     * @param username
     * @param password
     */
    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id(usernamelocator)).sendKeys(username);
        //Keys.ENTER means click enter after entering password
        //in this way, we don't need to click login button
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(3);
    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     *
     * @param tab
     * @param module
     */
    public static void navigateToModule(String tab, String module){
        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'title title-level-2')]";
        SeleniumUtils.clickWithWait(Driver.getDriver(), By.xpath(tabLocator), 5);
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
    }
    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.

     */
  //  public static void waitUntilLoaderScreenDisappear() {
    //    try {
      //      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
        //    wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
        //}catch (Exception e){
          //  System.out.println(e+" :: Loader mask doesn't present.");
        //}
    //}
    /**
     *
     * @return page name, for example: Dashboard
     */
    public static String getPageSubTitle(){
        waitUntilLoaderScreenDisappear();
        return Driver.getDriver().findElement(By.cssSelector(pageSubTitleLocator)).getText();
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     *
     */
    public static void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
            wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
        }catch (Exception e){
            System.out.println(e+" :: Loader mask doesn't present.");
        }
    }

    /**
     * Simple method that can select start or end date on create calendar event page
     * @param date - date should be in the format MM/dd/yyy, for example: 12/12/2019
     * @param startOrEnd - which date to enter: start or end.
     */
    public void selectDate( String date,  String startOrEnd){
       LocalDate ld = LocalDate.of(Integer.parseInt(date.substring(date.lastIndexOf("/")+1)),
                Integer.parseInt(date.substring(0, date.indexOf("/"))),
                Integer.parseInt(date.substring(date.indexOf("/")+1, date.lastIndexOf("/"))));
        String month = DateTimeFormatter.ofPattern("MMM").format(ld);
        int year = ld.getYear();
        int day = ld.getDayOfMonth();
        //locator for day
        String dayLocator =  "//a[@class='ui-state-default' and text()='"+day+"']";
        //click on start or end date
        if(startOrEnd.equalsIgnoreCase("start")){
 //           startDateLocator.click();
        }else{
//            endDateLocator.click();
        }
        //select month
  //      new Select(selectMonth).selectByVisibleText(month);
        //select year
   //     new Select(selectYear).selectByVisibleText(year+"");
        //select day
        Driver.getDriver().findElement(By.xpath(dayLocator)).click();
        try {
            //wait until date picker disappears at all
            new WebDriverWait(Driver.getDriver(), 3).
                    until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(dayLocator))));
            //in case of exception, recover from it and move on
        }catch (Exception e){
            System.out.println(e+" ::: Datepicker not found");
        }
    }

}