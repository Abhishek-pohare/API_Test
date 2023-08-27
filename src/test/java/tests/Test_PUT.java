package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Test_PUT {
	
	@Test
	public void Test_1_PUT() {
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
		when().put("https://reqres.in/api/users/2").
		then()
		.statusCode(200).log().all();
	}

}
