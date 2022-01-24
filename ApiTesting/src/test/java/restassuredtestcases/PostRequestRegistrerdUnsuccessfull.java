package restassuredtestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestRegistrerdUnsuccessfull {

	@Test
	public void testRegisterdUnsuccefull() {
		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();

		reqData.put("email", "vishal@gmail.com");

		System.out.println(reqData.toJSONString());

		given().accept(ContentType.JSON).body(reqData.toJSONString()).
		when().post("/register").then().statusCode(400)
				.log().body();

	}
}
