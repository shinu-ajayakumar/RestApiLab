package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is -> " + statusCode);
		String response = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(response);

		System.out.println("Json Response Object is -> " + responseJson);
		Header[] headerArray = closeableHttpResponse.getAllHeaders();

		HashMap<String, String> headerMap = new HashMap<String, String>();

		for (Header header : headerArray) {
			headerMap.put(header.getName(), header.getValue());
		}

		System.out.println("Headers are -> " + headerMap);

	}
}
