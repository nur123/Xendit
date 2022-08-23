package base;

import io.restassured.RestAssured;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;

import static constants.ServiceConstants.BASE_URL;

public class BaseRequest {

    public FilterableRequestSpecification base() {
        return (FilterableRequestSpecification) RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authentication", "TestAuth")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                //for mocking using postman
                .header("x-mock-match-request-body", "true")
                .log().all();
    }
}
