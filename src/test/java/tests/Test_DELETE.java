package tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


@Test
public class Test_DELETE {

	public void Test_1_delete() {

		when().delete("https://reqres.in/api/users/2").
		then()
		.statusCode(204).log().all();
	}
}
