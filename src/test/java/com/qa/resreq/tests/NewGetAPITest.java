package com.qa.resreq.tests;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.resreq.base.BaseTest;
import com.qa.utility.Utility;

public class NewGetAPITest extends BaseTest {
	
	int statusCode;

	@Test
	public void verfiyAPIStatusCode() {		
		Assert.assertEquals(statusCode, 200);
	}

	@Test(dependsOnMethods = { "getJsonResponse" })
	public void verifyAPIResponsePerPage() {		
		int perPage = Integer.parseInt(Utility.getValueByJPath(jsonObject, "/per_page"));
		Assert.assertEquals(perPage, 3);
	}

	@Test(dependsOnMethods = { "getJsonResponse" })
	public void verifyAPIResponseTotal() {		
		int perPage = Integer.parseInt(Utility.getValueByJPath(jsonObject, "/total"));
		Assert.assertEquals(perPage, 12);
	}

	@Test(dependsOnMethods = { "getJsonResponse" })
	public void verifyAPIResponseArray() {		
		int id = Integer.parseInt(Utility.getValueByJPath(jsonObject, "/data[0]/id"));
		String firstName = Utility.getValueByJPath(jsonObject, "/data[0]/first_name");
		String lastName = Utility.getValueByJPath(jsonObject, "/data[0]/last_name");
		Assert.assertEquals(id, 1);
		Assert.assertEquals(firstName, "George");
		Assert.assertEquals(lastName, "Bluth");
	}

	@Test
	public void getJsonResponse() throws ParseException, IOException {
		statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		jsonObject = new JSONObject(responseString);
		
	}
}
