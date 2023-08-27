package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test_Example_1 {

	@Test
	public void Test_1() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statuscode= response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	public void Test_2() {
		RestAssured.given()
			.get("https://reqres.in/api/users?page=2")
			.then().statusCode(200)
			.body("data.id[0]", equalTo(7));
	}
}
