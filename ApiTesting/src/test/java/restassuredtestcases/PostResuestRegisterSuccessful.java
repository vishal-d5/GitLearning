package restassuredtestcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostResuestRegisterSuccessful {

	@Test
	public void testRegisterdsuccefull() {
		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();

		reqData.put("email", "vishal@gmail.com");
		reqData.put("password", "vishal123");

		System.out.println(reqData.toJSONString());

		given().accept(ContentType.JSON).body(reqData.toJSONString()).
		when().post("/register").then().statusCode(400)
				.log().body();

	}

}
