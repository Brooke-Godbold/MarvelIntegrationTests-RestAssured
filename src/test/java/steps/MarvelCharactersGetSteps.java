package steps;

import io.cucumber.java8.En;
import utils.ApiUtils;

import static io.restassured.RestAssured.given;

public class MarvelCharactersGetSteps extends MarvelCharactersBaseSteps implements En {

    public MarvelCharactersGetSteps(TestState testState) {
        super(testState);

        When("A GET Request is Made to Get the Characters", () -> {
            testState.response =
                    given()
                        .param("ts", ApiUtils.getTimestamp())
                        .param("apikey", ApiUtils.getKey())
                        .param("hash", ApiUtils.getHash()).
                    when().
                        get(ApiUtils.getCharactersApi()).
                    then().extract().response();
        });

        When("A GET Request is Made to Get the Characters without a Timestamp", () -> {
            testState.response =
                    given()
                        .param("apikey", ApiUtils.getKey())
                        .param("hash", ApiUtils.getHash()).
                    when().
                        get(ApiUtils.getCharactersApi()).
                    then().extract().response();
        });

        When("A GET Request is Made to Get the Characters without an API Key", () -> {
            testState.response =
                    given()
                        .param("ts", ApiUtils.getTimestamp())
                        .param("hash", ApiUtils.getHash()).
                    when().
                        get(ApiUtils.getCharactersApi()).
                    then().extract().response();
        });

        When("A GET Request is Made to Get the Characters without a Hash", () -> {
            testState.response =
                    given()
                        .param("ts", ApiUtils.getTimestamp())
                        .param("apikey", ApiUtils.getKey()).
                    when().
                        get(ApiUtils.getCharactersApi()).
                    then().extract().response();
        });
    }

}
