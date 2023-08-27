package demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTrequest {

	@Test
	public void PostTest() {
		RestAssured.baseURI= "https://reqres.in/api/users";
		RequestSpecification request= RestAssured.given();
		
		JSONObject json= new JSONObject();
		json.put("name", "Abhishek");
		json.put("Job", "QA");
		
		request.body(json.toJSONString());
		Response response= request.post("");
		
		int statuscode= response.getStatusCode();
		Assert.assertEquals(String.valueOf(statuscode), "201");
		
		String successcode= response.jsonPath().get("SuccessCode");
		System.out.println(successcode);
	}
}
