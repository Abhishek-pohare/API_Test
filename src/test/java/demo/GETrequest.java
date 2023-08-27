package demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETrequest {

	@Test
	public void GetDetails() {
		RestAssured.baseURI= "https://reqres.in/api/users";
		RequestSpecification httprequest= RestAssured.given();
		Response response= httprequest.get("/2");
		
		int StatusCode= response.getStatusCode();
		System.out.println("Status Code: "+StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		String statusLine= response.getStatusLine();
		System.out.println("status body: "+statusLine);
		
		//first 
		JsonPath jsonpathEvaluator= response.jsonPath();
		Map<Object, Object> abc= jsonpathEvaluator.get();
		System.out.println("Body: "+abc);
		
		Map<Object, Object> map= new LinkedHashMap<Object, Object>();
		map.putAll(abc);
		
		for(Map.Entry m: map.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
		System.out.println(map.get("id"));
	}
}
