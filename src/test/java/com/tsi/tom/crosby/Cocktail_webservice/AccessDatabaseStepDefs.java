package com.tsi.tom.crosby.Cocktail_webservice;

import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AccessDatabaseStepDefs {

    String response;

    @Given("The website is currently running")
    public void theWebsiteIsCurrentlyRunning() throws IOException {
        URL url = new URL("http://13.40.33.55:8080/cocktails/all");
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
        boolean testState = false;
        URL url = new URL("http://13.40.33.55:8080/cocktails/all");
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
        assertEquals(testState, true, "Cocktail found in response");
    }
}