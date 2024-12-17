package com.grace.firstLesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyAutomationExerciseBackUpTest {
    //initialize  Browser
    ChromeDriver chromeDriver = new ChromeDriver();

    // Common  starting steps
    @Before
    public void setUp() {
        // Launch Browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\grace\\Downloads\\chromedriver-win64.zip\\chromedriver-win64");
        // Navigate to url
        chromeDriver.get("https://automationexercise.com");
    }

    // Test Case 1: Register User
    @Test
    public void registerUserTest() throws InterruptedException {
        // Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", chromeDriver.getCurrentUrl());
        Thread.sleep(2000);

        // Click on consent button
        WebElement consentButton = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]"));
        consentButton.click();
        Thread.sleep(2000);

        // Click on 'Signup / Login' button
        WebElement signUpLoginButton = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();
        Thread.sleep(2000);

        //  Verify 'New User Signup!' is visible
        WebElement newUserSignUpHeader = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        assertTrue(newUserSignUpHeader.getText().contains("New User Signup!"));
        Thread.sleep(2000);

        //Enter name and email address
        WebElement nameText = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        nameText.sendKeys("John Doe");
        Thread.sleep(2000);

        WebElement emailAddressText = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        emailAddressText.sendKeys("testUser7@test.com");
        Thread.sleep(2000);

        //  Click 'Signup' button
        WebElement signUpButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUpButton.click();
        Thread.sleep(2000);

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationText = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));
        assertTrue(enterAccountInformationText.getText().contains("ENTER ACCOUNT INFORMATION"));
        Thread.sleep(1000);

        //Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleText = chromeDriver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]"));
        titleText.click();
        Thread.sleep(2000);

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

        // Select title and enter user details with delays between actions.
        chromeDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Johny01");
        chromeDriver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("14");
        chromeDriver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("April");
        chromeDriver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("2000");

// Check newsletter and special offers options.
        chromeDriver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"optin\"]")).click();
        Thread.sleep(2000); // Delays are added after each action.

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


        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number'
        ArrayList<String[]> elementList = new ArrayList<String[]>();
        elementList.add( new String[]{"//*[@id=\"first_name\"]", "John" });
        elementList.add( new String[]{"//*[@id=\"last_name\"]", "Doe" });
        elementList.add( new String[]{"//*[@id=\"company\"]", "SkyLink Impact" });
        elementList.add( new String[]{"//*[@id=\"address1\"]", "House 41" });
        elementList.add( new String[]{"//*[@id=\"address2\"]", "London Road" });
        elementList.add( new String[]{"//*[@id=\"country\"]", "United States" });
        elementList.add( new String[]{"//*[@id=\"state\"]", "Michigan" });
        elementList.add( new String[]{"//*[@id=\"city\"]", "Detroit" });
        elementList.add( new String[]{"//*[@id=\"zipcode\"]", "0234567" });
        elementList.add( new String[]{"//*[@id=\"mobile_number\"]", "0123456789" });

        /** for (int counter = 0; counter < elementList.size(); counter++) {
         WebElement element = chromeDriver.findElement(By.xpath(elementList.get(counter)[0]));
         element.sendKeys(elementList.get(counter)[1]);
         }*/

        for (String[] elementData : elementList) {
            WebElement element = chromeDriver.findElement(By.xpath(elementData[0]));
            element.sendKeys(elementData[1]);
        }

        Thread.sleep(2000);

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

        //  Click 'Create Account button'
        WebElement createAccountButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccountButton.click();
        Thread.sleep(2000);

        // Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedHeader = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2"));
        assertEquals("ACCOUNT CREATED!", accountCreatedHeader.getText());
        Thread.sleep(2000);

        //  Click 'Continue' button
        WebElement continueButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButton.click();
        Thread.sleep(2000);

        // Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsernameText = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        assertEquals("Logged in as John Doe", loggedInAsUsernameText.getText());
        Thread.sleep(2000);

        //  Click 'Delete Account' button
        WebElement deleteAccountButton = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccountButton.click();
        Thread.sleep(2000);

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedHeader = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2"));
        assertEquals("ACCOUNT DELETED!", accountDeletedHeader.getText());
        Thread.sleep(2000);

        WebElement deleteContinueButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        deleteContinueButton.click();
        Thread.sleep(2000);
    }

    //Test Case 2: Login User with correct email and password
    @Test
    public void loginUserWithCorrectEmailAndPasswordTest() {

    }

    // Common ending steps
    @After
    public void exit() {
        chromeDriver.quit();
    }
}