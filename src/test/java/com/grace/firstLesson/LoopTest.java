package com.grace.firstLesson;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LoopTest {

    //initialize  Browser
    ChromeDriver chromeDriver = new ChromeDriver();


    // Common  starting steps
    @Before
    public void setUp() {
        // Launch Browser
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\grace\\Downloads\\chromedriver-win64.zip\\chromedriver-win64");
        // Navigate to url
        // chromeDriver.get("https://automationexercise.com");
    }

    /**
     * First thing is a counter - int  variable
     * Second thing is condition -
     * Third is the steps
     * <p>
     * condition ->
     * greater than >
     * lesser than <
     * equals to ==
     */
    @Test
    public void forLoopTest() throws InterruptedException {

        // keep running it until -> condition


        for (int counter = 0; counter < 6; counter++) {
            System.out.println("print this name -> ");
            Thread.sleep(2000);
        }

        for (int counter = 0; counter <= 10; counter++) {
            System.out.println("print this name -> ");
            Thread.sleep(2000);
        }

        for (int counter = 10; counter > 0; counter--) {
            System.out.println("print this name -> ");
            Thread.sleep(2000);
        }

        for (int counter = 30; counter < 50; counter--) {
            System.out.println("print this name -> ");
            Thread.sleep(2000);
        }


        //while loop

        boolean happy = false;
        while(!happy) {
            System.out.println("print this name -> ");
            Thread.sleep(2000);
           happy = true;
        }

        /*ArrayList<String> listOfNames = new ArrayList<String>();
         *         listOfNames.add("name0");
         *         listOfNames.add("name1");
         *         listOfNames.add("name2");
         *         System.out.println("print this name -> " + listOfNames.get(0));
         */


        // For Each loop
        ArrayList<String> listOfNames = new ArrayList<String>();
        listOfNames.add("Home");
        listOfNames.add("Products");
        listOfNames.add("Cart");
        listOfNames.add("SignUp/Login");
        listOfNames.add("Logout");
        listOfNames.add("Logout");


        for (String name : listOfNames) {
            WebElement item = chromeDriver.findElement(By.linkText(name));
            assertTrue(item.isDisplayed());
            System.out.println(name);
        }
    }


}