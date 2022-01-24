package restassuredtestcases;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;

import static io.restassured.RestAssured.*;

public class GetRequestSingleResourceNotFound {
	@Test
	public void UserNotFound() {

		baseURI = "https://reqres.in/api";
		given().get("/unknown/23").then().statusCode(404).log().ifValidationFails(LogDetail.STATUS)
				.log().status().log().body();

	}
}
