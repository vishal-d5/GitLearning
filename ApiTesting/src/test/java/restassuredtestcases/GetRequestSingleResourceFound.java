package restassuredtestcases;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;

public class GetRequestSingleResourceFound {
	
	@Test
	public void testList() {
		baseURI="https://reqres.in/api";
		
		 given().get("/unknown/2").then().statusCode(200).log().ifValidationFails(LogDetail.STATUS)
		 .log().status().log().body();
		
	}

}
