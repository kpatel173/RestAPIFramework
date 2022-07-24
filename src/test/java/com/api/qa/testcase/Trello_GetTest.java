package com.api.qa.testcase;

import org.testng.annotations.Test;

import com.api.qa.util.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeMethod;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Trello_GetTest {
	String Name=RestUtil.empName();
	@Test
	public void CreateBoard() throws InterruptedException {

		
		  RestAssured.baseURI = "https://api.trello.com/1/";
		  RequestSpecification httpRequest = RestAssured.given(); 
		  JSONObject requestParams = new JSONObject();
		  requestParams.put("?", "");
		  requestParams.put("name", Name); 
		  requestParams.put("token","26545206bba44eec665996921a74118c59878f4b9d7a41b7653a988556fce0f0"); 
		  requestParams.put("key","51fba77a7651252bddc8f2e3261a7cb8"); 
		  httpRequest.header("content-Type", "application/json");
		  
		  httpRequest.body(requestParams.toJSONString());
		  
		  
		  Response response = httpRequest.request(Method.POST, "boards");
		  
		  int code = response.getStatusCode(); 
		  Thread.sleep(2000);
		  String responseBody = response.getBody().asString();
			System.out.println(responseBody);
		  Assert.assertEquals(code, 200);
		 
	}

	@Test
	public void GetBoard() throws InterruptedException {

		RestAssured.baseURI = "https://api.trello.com/1/";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("?", "");
		requestParams.put("token","26545206bba44eec665996921a74118c59878f4b9d7a41b7653a988556fce0f0"); 
		requestParams.put("key","51fba77a7651252bddc8f2e3261a7cb8"); 

		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.GET,
				"boards/id");
		Thread.sleep(2000);
		
		  String responseBody = response.getBody().asString();
		  System.out.println(responseBody);
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
	

	}

	@AfterMethod
	public void afterMethod() {
	}

}
