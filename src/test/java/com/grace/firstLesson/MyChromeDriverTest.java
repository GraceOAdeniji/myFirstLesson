
package com.grace.firstLesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class MyChromeDriverTest {

ChromeDriver chromeDriver = new ChromeDriver();

    @Before
    public void startWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\grace\\Downloads\\chromedriver-win64.zip\\chromedriver-win64");
        chromeDriver.get("https://admin.staging.skylinkimpact.com");
    }


    @Test
    public void sampleTest() {
        System.out.println("My test is running");
    }

    @Test
    public void myFirstClickTest() throws InterruptedException {
        WebElement continueWithEmailButton = chromeDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div/div/div/div/a"));
        continueWithEmailButton.click();
        Thread.sleep(2000);

        WebElement emailText = chromeDriver.findElement(By.xpath("//*[@id=\"undefined-:r2:\"]"));
        emailText.sendKeys("testUser@test.com");
        Thread.sleep(2000);

        WebElement loginEmail = chromeDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div/div/form/button"));
        loginEmail.click();
        Thread.sleep(2000);

        WebElement otpCode = chromeDriver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div/div/div/div/form/div/div[7]/input"));
        otpCode.sendKeys("123456");
        Thread.sleep(2000);

/* assertEquals is used to verify
        assertEquals("products", productsMenu.getText());
        assertEquals("products", productsMenu.isDisplayed());
 **/

        assertEquals("https://admin.staging.skylinkimpact.com", chromeDriver.getCurrentUrl());
    }

    /** WebElement firstNameText = chromeDriver.findElement(By.xpath("//*[@id=\"first_name\"]"));
     firstNameText.sendKeys("John");
     Thread.sleep(2000);

     WebElement lastNameText = chromeDriver.findElement(By.xpath("//*[@id=\"last_name\"]"));
     lastNameText.sendKeys("Doe");
     Thread.sleep(2000);

     WebElement companyText = chromeDriver.findElement(By.xpath("//*[@id=\"company\"]"));
     companyText.sendKeys("SkyLink Impact");
     Thread.sleep(2000);

     WebElement addressText = chromeDriver.findElement(By.xpath("//*[@id=\"address1\"]"));
     addressText.sendKeys("House 41");
     Thread.sleep(2000);

     WebElement address2Text = chromeDriver.findElement(By.xpath("//*[@id=\"address2\"]"));
     address2Text.sendKeys("London Road");
     Thread.sleep(2000);

     WebElement countryDropdown = chromeDriver.findElement(By.xpath("//*[@id=\"country\"]"));
     countryDropdown.sendKeys("United States");
     Thread.sleep(2000);

     WebElement stateText = chromeDriver.findElement(By.xpath("//*[@id=\"state\"]"));
     stateText.sendKeys("Michigan");
     Thread.sleep(2000);

     WebElement cityText = chromeDriver.findElement(By.xpath("//*[@id=\"city\"]"));
     cityText.sendKeys("Detroit");
     Thread.sleep(2000);

     WebElement zipcodeText = chromeDriver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
     zipcodeText.sendKeys("0234567");
     Thread.sleep(2000);

     WebElement mobileNumberText = chromeDriver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
     mobileNumberText.sendKeys("0123456789");
     Thread.sleep(2000); */


    // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number'
    /** ArrayList<String> xpathList = new ArrayList<String>();
     xpathList.add("//*[@id=\"first_name\"]");
     xpathList.add("//*[@id=\"last_name\"]");
     xpathList.add("//*[@id=\"company\"]");
     xpathList.add("//*[@id=\"address1\"]");
     xpathList.add("//*[@id=\"address2\"]");
     xpathList.add("//*[@id=\"country\"]");
     xpathList.add("//*[@id=\"state\"]");
     xpathList.add("//*[@id=\"city\"]");
     xpathList.add("//*[@id=\"zipcode\"]");
     xpathList.add("//*[@id=\"mobile_number\"]");

     ArrayList<String> dataList = new ArrayList<String>();
     dataList.add("John");
     dataList.add("Doe");
     dataList.add("SkyLink Impact");
     dataList.add("House 41");
     dataList.add("London Road");
     dataList.add("United States");
     dataList.add("Michigan");
     dataList.add("Detroit");
     dataList.add("0234567");
     dataList.add("0123456789");

     for (int counter = 0; counter < xpathList.size(); counter++) {
     WebElement element = chromeDriver.findElement(By.xpath(xpathList.get(counter)));
     element.sendKeys(dataList.get(counter));
     }
     Thread.sleep(2000);*/

    /** WebElement passwordText = chromeDriver.findElement(By.xpath("//*[@id=\"password\"]"));
     passwordText.sendKeys("Johny01");
     Thread.sleep(2000);

     WebElement dateOfBirthDayText = chromeDriver.findElement(By.xpath("//*[@id=\"days\"]"));
     dateOfBirthDayText.sendKeys("14");
     Thread.sleep(2000);

     WebElement dateOfBirthMonthText = chromeDriver.findElement(By.xpath("//*[@id=\"months\"]"));
     dateOfBirthMonthText.sendKeys("April");
     Thread.sleep(2000);

     WebElement dateOfBirthYearText = chromeDriver.findElement(By.xpath("//*[@id=\"years\"]"));
     dateOfBirthYearText.sendKeys("2000");
     Thread.sleep(2000);

     // Select checkbox 'Sign up for our newsletter!'
     WebElement signUpForOurNewsletterText = chromeDriver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
     signUpForOurNewsletterText.click();
     Thread.sleep(2000);

     // Select checkbox 'Receive special offers from our partners!'
     WebElement receiveSpecialOffersFromOurPartnersText = chromeDriver.findElement(By.xpath("//*[@id=\"optin\"]"));
     receiveSpecialOffersFromOurPartnersText.click();
     Thread.sleep(2000); */

    @After
    public void exit() {
        chromeDriver.quit();
    }
}