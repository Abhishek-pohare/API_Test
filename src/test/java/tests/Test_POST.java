package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class Test_POST {

	@Test
	public void Test_1() {
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("name", "Abhishek");
		map.put("job", "SDET");
		
		System.out.println(map);
		
		//JSONObject request= new JSONObject(map);
		JSONObject request= new JSONObject();
	
		request.put("name", "Abhishek");
		request.put("job", "Software Tester");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
		header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("https://reqres.in/api/users").
		then()
		.statusCode(201).log().all();
	}
}
