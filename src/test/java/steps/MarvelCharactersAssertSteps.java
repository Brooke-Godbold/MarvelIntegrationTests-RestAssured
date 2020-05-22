package steps;

import io.cucumber.java8.En;
import io.restassured.path.json.JsonPath;
import utils.AssertUtils;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MarvelCharactersAssertSteps extends MarvelCharactersBaseSteps implements En {

    public MarvelCharactersAssertSteps(TestState testState) {
        super(testState);

        Then("The Response contains all of the expected Fields", () -> {
            assertThat(testState.response.statusCode()).isEqualTo(200);

            JsonPath jsonPath = new JsonPath(testState.response.asString()).setRootPath("data");
            List<LinkedHashMap> results = jsonPath.get("results");
            results.forEach(
                    result -> assertThat(result).containsKeys(AssertUtils.getExpectedCharacterFields().toArray())
            );
        });

        Then("The Response has a Status Code of {int}", (Integer statusCode) -> {
            assertThat(testState.response.statusCode()).isEqualTo(statusCode);
        });

    }

}
