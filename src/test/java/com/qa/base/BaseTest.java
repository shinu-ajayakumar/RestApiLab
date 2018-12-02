package com.qa.base;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected String serviceApiUrl;
	protected CloseableHttpClient closeableHttpClient;
	protected HttpGet httpGet;
	protected CloseableHttpResponse closeableHttpResponse;
	protected JSONObject jsonObject;
	protected Properties prop;
	protected String responseString;
	protected int statusCode;	

	@BeforeMethod
	public void openConnections() throws ClientProtocolException, IOException {
		closeableHttpClient = HttpClients.createDefault();
		httpGet = new HttpGet(serviceApiUrl);
		closeableHttpResponse = closeableHttpClient.execute(httpGet);
		statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		jsonObject = new JSONObject(responseString);
	}

	@AfterMethod
	public void closeConnections() throws IOException {
		closeableHttpClient.close();
		closeableHttpResponse.close();
	}
}
