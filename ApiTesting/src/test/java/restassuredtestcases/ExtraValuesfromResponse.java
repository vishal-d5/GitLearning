package restassuredtestcases;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.sql.DatabaseMetaData;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class ExtraValuesfromResponse {

	/*
	 * @Test public void test() {
	 * 
	 * baseURI = "https://reqres.in/api";
	 * 
	 * JSONObject reqData = new JSONObject(); reqData.put("email",
	 * "eve.holt@reqres.in"); reqData.put("password", "cityslicka");
	 * 
	 * String token = given().
	 * 
	 * body(reqData.toJSONString()).contentType(ContentType.JSON).accept(ContentType
	 * .JSON) .header("charset",
	 * "utf-8").when().post("/login").then().extract().path("token");
	 * 
	 * System.out.println(token);
	 * 
	 * }
	 */

	
	
	
	
	
	
	
	/*
	 * @Test public void test2() { baseURI = "https://reqres.in/api";
	 * 
	 * JSONObject reqData = new JSONObject(); reqData.put("email",
	 * "eve.holt@reqres.in"); reqData.put("password", "cityslicka");
	 * reqData.put("id", "9"); reqData.put("token", "QpwL5tke4Pnpja7X4");
	 * 
	 * String id = given().
	 * 
	 * body(reqData.toJSONString()).contentType(ContentType.JSON).accept(ContentType
	 * .JSON) .header("charset",
	 * "utf-8").when().patch("/id/9").then().statusCode(200).log()
	 * .ifValidationFails(LogDetail.STATUS).extract().path("id");
	 * System.out.println(id);
	 * 
	 * 
	 * given().get(token).then(). statusCode(200) .log() .
	 * .body("data.first_name",hasItem("")). body();
	 * 
	 * 
	 * // baseURI="https://reqres.in/api";
	 * 
	 * given().get("/users?page=2").then().statusCode(200).body("data[2].id",equalTo
	 * (7)) .body("data[0].first_name", equalTo("Michael")) .body("data.first_name",
	 * hasItem("Lindsay")). log().
	 * 
	 * ifValidationFails(LogDetail.STATUS) .log().status().log().body();
	 * 
	 * 
	 * //given().get("/users?page=2").then().statusCode(200).body("data[2].id",
	 * equalTo(9)) // .body("data[2].first_name",
	 * equalTo("Tobias")).body("data[2].last_name", equalTo("Funke")).log() //
	 * .ifValidationFails(LogDetail.STATUS).log().all();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	@Test
	public void apiTesting() {

		// User Register
		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();
		reqData.put("email", "eve.holt@reqres.in");
		reqData.put("password", "pistol");

		System.out.println(reqData.toJSONString());
		given().header("Content-Type", "application/json").header("charset", "utf-8").header("Connection", "keep-alive")
				.accept(ContentType.JSON).body(reqData.toJSONString()).when().post("/register").then().statusCode(200)
				.log().all();

		// extract and Print
		String token = given().body(reqData.toJSONString()).contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("charset", "utf-8").when().post("/register").then().extract().path("token");

		System.out.println("Token  : " + token);

		// extract user Id print
		int userID = given().body(reqData.toJSONString()).contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("charset", "utf-8").when().post("/register").then().extract().path("id");

		System.out.println("User ID" + userID);

		// UerLogin

		given().header("Content-Type", "application/json").header("Connection", "keep-alive").accept(ContentType.JSON)
				.when().post("/login").then().
				// status verify
				statusCode(200).log().all();

		// Extract login token
		String LoginToken = given().body(reqData.toJSONString()).contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("charset", "utf-8").when().post("/login").then().extract().path("token");

		System.out.println("Token" + LoginToken);

		// get single user to find same user id >>

		given().get("/users/" + userID).then().statusCode(200).body("data.id", equalTo(4))
				.body("data.first_name", equalTo("Eve")).body("data.last_name", equalTo("Holt"))
				.body("data.email", equalTo("eve.holt@reqres.in")).log().body();

		// Single Resource Use the same userID >> validate details

		given().get("/unknown/" + userID).then().statusCode(200).body("data.id", equalTo(4))
				.body("data.name", equalTo("aqua sky")).
				// log everything
				log().everything();

		reqData.put("name", "John");
		reqData.put("job", "Teacher");
		given().body(reqData.toJSONString()).when().patch("/users/" + userID).then().statusCode(200).log().body();

		System.out.println(userID + "updated");

		// searching updated or not
		given().get("/users/" + userID).then().statusCode(200).body("data.id", equalTo(4)).log().body();

		// Delete same user >> search user validate

		when().delete("/users/" + userID).then().statusCode(204).log().ifStatusCodeIsEqualTo(204);

		System.out.println(userID + "Deleted Successfully..");

		// Search again deleted or not

		given().get("/users/" + userID).then().statusCode(200).body("data.id", equalTo(4)).log().body();

	}

}
