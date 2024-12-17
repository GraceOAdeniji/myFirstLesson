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

public class MyAutomationExerciseTest {
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
        ArrayList<String[]> elementList = new ArrayList<String[]>();
        elementList.add(new String[]{"//*[@id=\"first_name\"]", "John"});
        elementList.add(new String[]{"//*[@id=\"last_name\"]", "Doe"});
        elementList.add(new String[]{"//*[@id=\"company\"]", "SkyLink Impact"});
        elementList.add(new String[]{"//*[@id=\"address1\"]", "House 41"});
        elementList.add(new String[]{"//*[@id=\"address2\"]", "London Road"});
        elementList.add(new String[]{"//*[@id=\"country\"]", "United States"});
        elementList.add(new String[]{"//*[@id=\"state\"]", "Michigan"});
        elementList.add(new String[]{"//*[@id=\"city\"]", "Detroit"});
        elementList.add(new String[]{"//*[@id=\"zipcode\"]", "0234567"});
        elementList.add(new String[]{"//*[@id=\"mobile_number\"]", "0123456789"});

        for (String[] elementData : elementList) {
            WebElement element = chromeDriver.findElement(By.xpath(elementData[0]));
            element.sendKeys(elementData[1]);
        }

        Thread.sleep(2000);

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