package restassuredtestcases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;

public class GetRequestListResorce {
	
	
	@Test
	public void testList() {
		baseURI="https://reqres.in/api";
		
		 given().get("/unknown").then().statusCode(200).log()
		 .ifValidationFails(LogDetail.STATUS)
		 .log().status().log().body();
		
	}

}
