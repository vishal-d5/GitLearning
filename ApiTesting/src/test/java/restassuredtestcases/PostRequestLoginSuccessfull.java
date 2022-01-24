package restassuredtestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestLoginSuccessfull {
	@Test
	public void testLoginsuccefull() {
		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();
		
		

		reqData.put("email", "vishal@gmail.com");
		reqData.put("password", "vishal123");
		
		
		

		System.out.println(reqData.toJSONString());

		given()
		.header("Connection", "Keep-alive")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		body(reqData.toJSONString())
		.log().all()
		.when().
		post("/login").then().statusCode(400)
		.log().all();
				

	}

}
