
package com.grace.firstLesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyEdgeDriverTest {
    ChromeDriver chromeDriver = new ChromeDriver();

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\grace\\Downloads\\edgedriver_win64\\msedgedriver");
        chromeDriver.get("https://admin.staging.skylinkimpact.com");
    }

    @Test
    public void sampleTest() {
        System.out.println("My test is running");
    }

    @Test
    public void signUpClickTest() throws InterruptedException {
        WebElement signUpLink = chromeDriver.findElement(By.xpath("/html/body/div[1]/header/nav/nav/a[2]"));
        signUpLink.click();
        Thread.sleep(2000);

        WebElement firstPlanTypeSelection = chromeDriver.findElement(By.xpath("//*[@id=\"hobby\"]"));
        firstPlanTypeSelection.click();
        Thread.sleep(2000);

        WebElement yourNameText = chromeDriver.findElement(By.xpath("//*[@id=\"undefined-:r0:\"]"));
        yourNameText.sendKeys("Grace Adeniji");
        Thread.sleep(2000);

        WebElement continueButton = chromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/form/div/div/button"));
        continueButton.click();
        Thread.sleep(20000);
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
        Thread.sleep(200000);
    }

    @After
    public void exit() {
        chromeDriver.quit();
    }
}
