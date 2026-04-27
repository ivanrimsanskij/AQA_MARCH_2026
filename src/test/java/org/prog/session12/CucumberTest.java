package org.prog.session12;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberTest {

    @Given("I request {int} some amount people from randomuser.me")
    public void requestRandomPeople(int amount ) {
        System.out.println("Requesting" + amount + "random users");
    }

    @When("I store their to {string} DB")
    public void storeToDb(String dbName) {
        System.out.println("Hello" + dbName);
    }

    @Then("DB entry {string} count increases {int}")
    public void db_entry_count_increases(String string, Integer int1) {
        System.out.println("Success! DB: " + string + " count: " + int1);
    }
}
