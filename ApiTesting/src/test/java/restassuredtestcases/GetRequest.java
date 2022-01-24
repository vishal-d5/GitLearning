package restassuredtestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {
	
	
	@Test
	 void testGestUserList() {
		//sending  get request to server
		 Response rsp=RestAssured.get("https://reqres.in/api/users?page=2");
		 
		 
		 // validating status code
		 System.out.println(rsp.getStatusCode());		 
		 Assert.assertEquals(rsp.getStatusCode(), 200);
		 
		 // getting response body		 
		 System.out.println(rsp.getBody().asString());
		 System.out.println("The response body is - " + rsp.body().asString());
		 
		 // response time 
		 System.out.println("The response time is  - " +  rsp.getTime());
		 
		 //get header
		 
		 System.out.println("content type header is - "+ rsp.header("content - type"));
	
		 System.out.println("Response header are - " +  rsp.headers());
		 
	 }
	
	
	@Test
	void testSingleUser() {
		
		String userid="2";
		
		 Response rsp=RestAssured.get("https://reqres.in/api/users/" + userid);
		 
		 
		 // validating status code
		 System.out.println(rsp.getStatusCode());		 
		 Assert.assertEquals(rsp.getStatusCode(), 200);
		 
		 // getting response body		 
		 System.out.println(rsp.getBody().asString());
		 System.out.println("The response body is - " + rsp.body().asString());
		 
		 // response time 
		 System.out.println("The response time is  - " +  rsp.getTime());
		 
		 //get header
		 
		 System.out.println("content type header is - "+ rsp.header("content - type"));
	
		 System.out.println("Response header are - " +  rsp.headers());
		 
	 }
	
	
	

}
