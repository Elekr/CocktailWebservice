package com.tsi.tom.crosby.cocktail_webservice;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class AccessDatabaseStepDefs {

    String response;

    @Given("The website is currently running")
    public void theWebsiteIsCurrentlyRunning() throws IOException {
        URL url = new URL("http://18.170.52.254:8080/cocktails/all");
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //Assert whether the Website can be reached
            assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode(), "Connection Succeeded");
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @When("I try to look up the drink I want {string}")
    public void iTryToLookUpTheIWant(String drink) throws IOException{
        URL url = new URL("http://18.170.52.254:8080/cocktails/all");
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int status = con.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            response = sb.toString();
            con.disconnect();
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Then("The database will retrieve the cocktail I want")
    public void the_database_will_retrieve_the_cocktail_i_want() {
        //check that the response isn't null
        assertNotNull(response);
    }
    @And("I will have all the information about a {string}")
    public void iWillHaveAllTheInformationAboutA(String drink) {
        boolean testState = false;
        if (response.toLowerCase().contains(drink.toLowerCase())) {
            testState = true;
        }
        assertTrue(testState, "Cocktail found in response");
    }

    @Given("The website is running but goes to the wrong route")
    public void theWebsiteIsRunningButGoesToTheWrongRoute() throws IOException {
        URL url = new URL("http://18.170.52.254:8080/cocktails/all/wrongone");
    }

    @Then("I won't be able to access the website")
    public void iWonTBeAbleToAccessTheWebsite() throws IOException{
        URL url = new URL("http://18.170.52.254:8080/cocktails/all/wrongone");
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //TODO: get the response code
            //Assert whether the Website can be reached
            int responseCode = con.getResponseCode();
            assertEquals(HttpURLConnection.HTTP_NOT_FOUND, con.getResponseCode(), "Connection Succeeded");
            System.out.println(responseCode);
            con.disconnect();
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Given("The website is currently running up")
    public void theWebsiteIsCurrentlyRunningUp() throws IOException {
        URL url = new URL("http://18.170.52.254:8080/cocktails/all");
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //Assert whether the Website can be reached
            assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode(), "Connection Succeeded");
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @When("I try to look up the drink that I want {string}")
    public void iTryToLookUpTheDrinkThatIWant(String arg0) throws IOException {
        URL url = new URL("http://18.170.52.254:8080/cocktails/all");
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int status = con.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            response = sb.toString();
            con.disconnect();
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @And("The {string} does not exist")
    public void theDoesNotExist(String drink) {
        boolean testState = false;
        if (response.toLowerCase().contains(drink.toLowerCase())) {
            testState = true;
        }
        assertFalse(testState, "Cocktail found in response");
    }

    @Then("The database will return that the drink does not exist")
    public void theDatabaseWillReturnThatTheDoesNotExist() {
        //TODO:this
    }

}