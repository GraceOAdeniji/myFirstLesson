package com.grace.firstLesson;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ValidDetailsLogin {
    ChromeDriver chromeDriver = new ChromeDriver();

    Faker ukFaker = new Faker(Locale.UK);

    //data (global variables)
    String email = ukFaker.internet().emailAddress();
    String password = ukFaker.internet().password();
    String firstname = ukFaker.name().firstName();
    String lastname = ukFaker.name().lastName();
    String name = firstname + " " + lastname;

    @Given("Valid details login Test: user is registered")
    public void valid_details_login_test_user_is_registered() throws InterruptedException {
        ChromeDriver registerChromeDriver = new ChromeDriver();
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Step 0");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\grace\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        registerChromeDriver.get("https://automationexercise.com");
        Thread.sleep(2000);

        WebElement consentButton = registerChromeDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]"));
        consentButton.click();
        Thread.sleep(2000);

        WebElement signUpLoginButton = registerChromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();
        Thread.sleep(2000);

        WebElement nameText = registerChromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        nameText.sendKeys(name);
        Thread.sleep(2000);

        WebElement emailAddressText = registerChromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        emailAddressText.sendKeys(email);
        Thread.sleep(2000);

        WebElement signUpButton = registerChromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUpButton.click();
        Thread.sleep(1000);

        registerChromeDriver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]")).click();
        Thread.sleep(2000);

        // Select title and enter user details with delays between actions.
        registerChromeDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        registerChromeDriver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("" + ukFaker.date().birthday().getDay());
        registerChromeDriver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("April");
        registerChromeDriver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("" + ukFaker.date().birthday().getYear());

        registerChromeDriver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        Thread.sleep(2000);

        ArrayList<String[]> elementList = new ArrayList<String[]>();
        elementList.add(new String[]{"//*[@id=\"first_name\"]", firstname});
        elementList.add(new String[]{"//*[@id=\"last_name\"]", lastname});
        elementList.add(new String[]{"//*[@id=\"company\"]", ukFaker.company().name()});
        elementList.add(new String[]{"//*[@id=\"address1\"]", ukFaker.address().buildingNumber()});
        elementList.add(new String[]{"//*[@id=\"address2\"]", ukFaker.address().streetAddress()});
        elementList.add(new String[]{"//*[@id=\"country\"]", ukFaker.address().country()});
        elementList.add(new String[]{"//*[@id=\"state\"]", ukFaker.address().state()});
        elementList.add(new String[]{"//*[@id=\"city\"]", ukFaker.address().city()});
        elementList.add(new String[]{"//*[@id=\"zipcode\"]", ukFaker.address().zipCode()});
        elementList.add(new String[]{"//*[@id=\"mobile_number\"]", ukFaker.phoneNumber().phoneNumber()});

        for (String[] elementData : elementList) {
            WebElement element = registerChromeDriver.findElement(By.xpath(elementData[0]));
            element.sendKeys(elementData[1]);
        }

        WebElement createAccountButton = registerChromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccountButton.click();
        Thread.sleep(1000);
        registerChromeDriver.quit();
    }

    @And("Valid details login Test: user should be on automation website home page")
    public void user_should_be_on_automation_website_home_page() {
        System.out.println("Step 1");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\grace\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        chromeDriver.get("https://automationexercise.com");
    }

    @Then("Valid details login Test: Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() throws InterruptedException {
        System.out.println("Step 2");
        assertEquals("https://automationexercise.com/", chromeDriver.getCurrentUrl());
        Thread.sleep(1000);
    }

    @Then("Valid details login Test: Click on consent button")
    public void valid_details_login_test_click_on_consent_button() throws InterruptedException {
        System.out.println("Step 3");
        WebElement consentButton = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]"));
        consentButton.click();
        Thread.sleep(2000);
    }

    @Then("Valid details login Test: Click on Signup \\/ Login button")
    public void click_on_signup_login_button() throws InterruptedException {
        System.out.println("Step 4");
        WebElement signUpLoginButton = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();
        Thread.sleep(2000);
    }

    @Then("Valid details login Test: that Login to your account is visible")
    public void that_login_to_your_account_is_visible() throws InterruptedException {
        System.out.println("Step 5");
        WebElement loginToYourAccountText = chromeDriver.findElement(By.cssSelector("div[class='login-form'] h2"));
        assertTrue(loginToYourAccountText.getText().contains("Login to your account"));
        Thread.sleep(1000);
    }

    @Then("Valid details login Test: Enter correct email address and password")
    public void enter_correct_email_address_and_password() throws InterruptedException {
        System.out.println("Step 6");
        WebElement emailAddressText = chromeDriver.findElement(By.cssSelector("input[data-qa='login-email']"));
        emailAddressText.sendKeys(email);
        Thread.sleep(1000);

        WebElement passwordText = chromeDriver.findElement(By.cssSelector("input[data-qa='login-password']"));
        passwordText.sendKeys(password);
        Thread.sleep(1000);
    }

    @Then("Valid details login Test: Click login button")
    public void click_login_button() throws InterruptedException {
        System.out.println("Step 7");
        WebElement loginButton = chromeDriver.findElement(By.cssSelector("button[data-qa='login-button']"));
        loginButton.click();
        Thread.sleep(1000);
    }

    @Then("Valid details login Test: Verify that Logged in as username is visible")
    public void valid_details_login_test_verify_that_logged_in_as_username_is_visible() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Step 8");
        WebElement verifyThatLoggedInAsUsernameIsVisibleText = chromeDriver.findElement(By.linkText("Logged in as " + name));
        assertTrue(verifyThatLoggedInAsUsernameIsVisibleText.isDisplayed());
        Thread.sleep(1000);
    }

    @Then("Valid details login Test: Click Delete Account button")
    public void clickDeleteAccountButton() throws InterruptedException {
        WebElement deleteAccountButton = chromeDriver.findElement(By.linkText("Delete Account"));
        deleteAccountButton.click();
        Thread.sleep(1000);
    }

    @Then("Valid details login Test: Verify that ACCOUNT DELETED! is visible")
    public void verify_that_account_deleted_is_visible() throws InterruptedException {
        WebElement accountDeletedHeader = chromeDriver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
        assertEquals("ACCOUNT DELETED!", accountDeletedHeader.getText());
        Thread.sleep(2000);

        // close browser
        chromeDriver.quit();
    }
}
