package com.taotao.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

	/**
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doGet(String url, Map<String, String> param) {

		// create httpclient object
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;

		try {
			// create uri
			URIBuilder uribuilder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					// adding key,value pair from param object one by one
					uribuilder.addParameter(key, param.get(key));
				}
			}
			URI uri = uribuilder.build();
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			// 执行请求
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultString;
	}

	/**
	 * @param uri
	 * @return
	 */
	public static String doGet(String uri) {
		return doGet(uri, null);
	}

	/**
	 * @param uri
	 * @param param
	 * @return
	 */
	public static String doPost(String uri, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;

		try {
			// 创建Http Post请求
			HttpPost doPost = new HttpPost(uri);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				doPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(doPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
			httpClient.execute(doPost);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	/**
	 * @param uri
	 * @return
	 */
	public String doPost(String uri) {
		return doPost(uri, null);
	}

	/**
	 * @param uri
	 * @param json
	 * @return
	 */
	public String doPostJson(String uri, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = null;

		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri);
			// 创建请求内容
			StringEntity stringEntity = new StringEntity(json);
			httpPost.setEntity(stringEntity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(stringEntity, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}
}
