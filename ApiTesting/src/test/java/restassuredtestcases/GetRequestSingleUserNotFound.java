package restassuredtestcases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;

public class GetRequestSingleUserNotFound {
	
	
	@Test
	public void testNotfound() {
		//Response rsp=RestAssured.get("https://reqres.in/api/users/23");
		
		baseURI="https://reqres.in/api";
		
		given().get("/users/23").then().statusCode(404).log().
		ifValidationFails(LogDetail.STATUS)
		.log().status()
		.log().body();
		
		
	}
	

}
