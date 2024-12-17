package com.grace.firstLesson;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * All code should be within the class
 * Test functions -> will be used to write code for tests.
 * <p>
 * a class  -> always starts with { ends with }
 * a function/method/void  -> always starts with { ends with }
 * rainbow brackets -> search for it and try to install it
 * <p>
 * java commands always always end with ";"
 * first type -> then name it -> = value here
 * <p>
 * scope -
 * division /, multiplication *, subtraction -
 *
 * assertions -> to verify results - verify expected behavior
 *
 * Selenium -> framework to automate web browser
 */


public class MyFirstTest {
    int x = 2;
    int y = 5;
    boolean b = false;
    String firstName = "salam";
    String secondName = "abdul";

    public void createUser() {
        //step to create users;;;;
        System.out.println("user created successfully");
    }

    @Test
    public void one() {
        int grace = x + y;
        System.out.println(grace);
    }

    @Test
    public void two() {
        this.createUser();
        String name = firstName + " " + secondName;
        System.out.println(name);
    }

    @Test
    public void three() {
        this.createUser();
        int joshua = x + y;
        //assertEquals(8, joshua);
    }
}

