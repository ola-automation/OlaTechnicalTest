package com.bjss.testcases.api;

import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class APITest {

//	@Test
//	public void Test_01() {
//
//		Response resp = when().get("https://reqres.in/api/users");
//
//		System.out.println(resp.getStatusCode());
//
//	}
//
//	@Test
//	public void Test_02() {
//
//		Response resp = when().get("https://reqres.in/api/users");
//
//		Assert.assertEquals(resp.getStatusCode(), 200);
//
//	}
//
//	// How to use parameters with rest assured
//	@Test
//	public void Test_03() {
//
//		Response resp = given().
//				param("id", "3").
//				when().
//				get("https://reqres.in/api/users");
//
//		Assert.assertEquals(resp.getStatusCode(), 200);
//	}
//
//	// Assert our test case in rest assured API
//	@Test
//	public void Test_04() {
//
//		given().
//		param("id", "3").
//		when().get("https://reqres.in/api/users").
//		then().
//		assertThat().
//		statusCode(200);
//
//	}
//
//	@Test
//	public void Test_05() {
//
//		Response resp = given().
//				param("id", "3").
//				when().
//				get("https://reqres.in/api/users");
//
//		System.out.println(resp.asString());
//
//	}
//	
//	@Test
//	public void Test_06() {
//
//		String first_name = given().
//				parameter("id", "3").
//				when().
//				get("https://reqres.in/api/users").
//				then().
//				contentType(ContentType.JSON).
//				extract().
//				path("data[0].first_name");
//
//		System.out.println(first_name);
//
//	}
	
	@Test
	public void Test_07() {

		Response resp = given().
				parameter("id", "3").
				when().
				get("https://reqres.in/api/unknown");
		
		String first_name = resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("page");

		System.out.println(first_name);

	}

}























