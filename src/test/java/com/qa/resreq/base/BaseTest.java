package com.qa.resreq.base;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.utility.ConfigReader;

public class BaseTest {

	protected String serviceApiUrl;
	protected CloseableHttpClient closeableHttpClient;
	protected HttpGet httpGet;
	protected CloseableHttpResponse closeableHttpResponse;
	protected JSONObject jsonObject;
	protected Properties prop;
	protected String responseString;

	@BeforeTest
	public void init() {
		prop = ConfigReader.getConfig("/src/main/resources/com/qa/config/config.properties");	
		serviceApiUrl = prop.getProperty("REQRESURL") + "/api/users";
		httpGet = new HttpGet(serviceApiUrl);
	}

	@BeforeMethod
	public void openConnections() throws ClientProtocolException, IOException {		
		closeableHttpClient = HttpClients.createDefault();		
	}

	@AfterMethod
	public void closeConnections() throws IOException {
		closeableHttpClient.close();
		closeableHttpResponse.close();
	}
}
