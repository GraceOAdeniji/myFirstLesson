package com.grace.firstLesson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class TableFeature {
   /** @Test
    public void displayNumber() {
        int[] numbers = {1, 2, 3, 40, 50, 6, 7, 8};
       // System.out.println("number " + numbers[2]);

        for (int counter = 2; counter < 6; counter++) {
            System.out.println("number " + numbers[counter] + " array position " + counter);
        }
        ArrayList <Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(10);
        numbers2.add(15);
        numbers2.add(20);

        for (int counter = 0; counter < numbers2.size(); counter++){
            System.out.println(numbers2.get(counter));
        }
    }
   */

   @Given("student record exists")
   public void student_record_exists() {
       // Write code here that turns the phrase above into concrete actions
       throw new io.cucumber.java.PendingException();
   }
    @Then("Verify that  record entered is correct")
    public void verify_that_record_entered_is_correct(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
