package com.grace.firstLesson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class RegisterUser {
    ChromeDriver chromeDriver = new ChromeDriver();

    @Given("user should be on automation website home page")
    public void user_should_be_on_automation_website_home_page() {
        System.out.println("Step 1");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\grace\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        chromeDriver.get("https://automationexercise.com");
    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() throws InterruptedException {
        System.out.println("Step 2");
        assertEquals("https://automationexercise.com/", chromeDriver.getCurrentUrl());
        Thread.sleep(1000);
    }
    @Then("Click on consent button")
    public void click_on_consent_button() throws InterruptedException {
        System.out.println("Step 3");
        WebElement consentButton = chromeDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]"));
        consentButton.click();
        Thread.sleep(2000);
    }
    @Then("Click on Signup \\/ Login button")
    public void click_on_signup_login_button() throws InterruptedException {
        System.out.println("Step 4");
        WebElement signUpLoginButton = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();
        Thread.sleep(2000);
    }

    @Then("Verify New User Signup! is visible")
    public void verify_new_user_signup_is_visible()  throws InterruptedException {
        System.out.println("Step 4");
        WebElement signUpLoginButton = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLoginButton.click();
        Thread.sleep(2000);
    }

    @Then("Enter name and email address")
    public void enter_name_and_email_address() throws InterruptedException {
        WebElement nameText = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        nameText.sendKeys("John Doe");
        Thread.sleep(2000);

        WebElement emailAddressText = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        emailAddressText.sendKeys("testUser300@test.com");
        Thread.sleep(2000);
        System.out.println("Step 6");
    }

    @Then("Click Signup button")
    public void click_button() throws InterruptedException {
        WebElement signUpButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUpButton.click();
        Thread.sleep(1000);
        System.out.println("Step 7");

    }
    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_is_visible() throws InterruptedException {
        WebElement enterAccountInformationText = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));
        assertTrue(enterAccountInformationText.getText().contains("ENTER ACCOUNT INFORMATION"));
        Thread.sleep(1000);
        System.out.println("Step 8");

    }

    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() throws InterruptedException {
        chromeDriver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]")).click();

        // Select title and enter user details with delays between actions.
        chromeDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Johny01");
        chromeDriver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("14");
        chromeDriver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("April");
        chromeDriver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("2000");

        System.out.println("Step 9");

    }
    @Then("Select checkbox Sign up for our newsletter!")
    public void select_checkbox_sign_up_for_our_newsletter() throws InterruptedException {
        chromeDriver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        Thread.sleep(2000); // Delays are added after each action.
        System.out.println("Step 10");
    }

    @Then("Select checkbox Receive special offers from our partners!")
    public void select_checkbox_receive_special_offers_from_our_partners() throws InterruptedException {
        chromeDriver.findElement(By.xpath("//*[@id=\"optin\"]")).click();
        Thread.sleep(2000); // Delays are added after each action.
        System.out.println("Step 11");

    }
    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() throws InterruptedException {
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
            System.out.println("Step 12");
        }
    }

    @Then("Click Create Account button")
    public void click_create_account_button() throws InterruptedException {
        WebElement createAccountButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccountButton.click();
        Thread.sleep(1000);
        System.out.println("Step 13");
    }

    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_account_created_is_visible() throws InterruptedException {
        WebElement accountCreatedHeader = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2"));
        assertEquals("ACCOUNT CREATED!", accountCreatedHeader.getText());
        Thread.sleep(2000);
        System.out.println("Step 14");

    }

    @Then("Click Continue button")
    public void click_continue_button() throws InterruptedException {
        WebElement continueButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButton.click();
        Thread.sleep(2000);
        System.out.println("Step 15");
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() throws InterruptedException {
        WebElement loggedInAsUsernameText = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        assertEquals("Logged in as John Doe", loggedInAsUsernameText.getText());
        Thread.sleep(2000);
        System.out.println("Step 16");
    }

    @Then("Click Delete Account button")
    public void click_delete_account_button() throws InterruptedException {
        WebElement deleteAccountButton = chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccountButton.click();
        Thread.sleep(2000);
        System.out.println("Step 17");
    }
    @Then("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verify_that_account_deleted_is_visible_and_click_continue_button() throws InterruptedException {
        WebElement accountDeletedHeader = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2"));
        assertEquals("ACCOUNT DELETED!", accountDeletedHeader.getText());
        Thread.sleep(2000);

        WebElement deleteContinueButton = chromeDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        deleteContinueButton.click();
        Thread.sleep(2000);
        System.out.println("Step 18");

        // close browser
        chromeDriver.quit();

    }

}




