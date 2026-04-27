package org.prog.session11;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.prog.session11.dto.ResultDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.matchesRegex;

public class RestTest {

    @Test
    public void testRest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.basePath("/api");
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.queryParam("inc", "gender, name, nat, location");
        requestSpecification.get().prettyPrint();
        requestSpecification.auth().basic("user", "password");
        Response response = requestSpecification.get();
        response.body().prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("results[0].location.street.number", Matchers.notNullValue());
        validatableResponse.body("results[0].location.street.name", Matchers.notNullValue());
        validatableResponse.body("results[0].location.postcode", matchesRegex("\\d+"));

    }

    @Test
    public void testRest2() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.basePath("/api");
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.queryParam("inc", "gender, name, nat, location");
        requestSpecification.get().prettyPrint();
        requestSpecification.auth().basic("user", "password");

        Response response = requestSpecification.get();
        ResultDto resultsDto = response.as(ResultDto.class);
        Assert.assertTrue(
                resultsDto.getResults()
                        .stream()
                        .anyMatch(p ->
                                p.getLocation().getStreet().getNumber() != null &&
                                        p.getLocation().getStreet().getName() != null &&
                                        p.getLocation().getPostcode().matches("\\d+")
                                )
        );
    }
}