package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils {

	public static String post(String url, HashMap<String, String> parameterMap) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//		if(parameterMap != null) {
//			parameterMap.forEach( (key, value) -> {
//				nvps.add(new BasicNameValuePair(key, value));
//			});
//		}
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		System.out.println(httpPost+"&"+nvps.toString());
		CloseableHttpResponse response = httpclient.execute(httpPost);
		
		try {
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
                return  convertStreamToString(entity.getContent());
				
            }
		} finally {
		    response.close();
		}
		return null;
	}
	
	public static String get(String url) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet( url );
		
		CloseableHttpResponse response = httpclient.execute(httpGet);
		
		try {
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
                return  convertStreamToString(entity.getContent());
				
            }
		} finally {
		    response.close();
		}
		return null;
	}

	public static String convertStreamToString(InputStream is) throws IOException {
		/*
		 * To convert the InputStream to String we use the
		 * Reader.read(char[] buffer) method. We iterate until the
		 * Reader return -1 which means there's no more data to
		 * read. We use the StringWriter class to produce the string.
		 */
		if (is != null) {
		    Writer writer = new StringWriter();
		
		    char[] buffer = new char[1024];
		    try {
		        Reader reader = new BufferedReader(
		                new InputStreamReader(is, "UTF-8"));
		        int n;
		        while ((n = reader.read(buffer)) != -1) {
		            writer.write(buffer, 0, n);
		        }
		    } finally {
		        is.close();
		    }
		    return writer.toString();
		} else {        
		    return "";
		}
	}
	
	public static void main(String...strings) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("a", "1");
		map.put("b", "2");
		
//		map.forEach( (key, value) -> {
//			System.out.println(key + ":" + value);
//		});
	}

//	티켓 발행을 위한 header 부분 추가
	public static String sendTicketPost(String ticketURL,HashMap<String, String> parameterMap,HashMap<String, String> heardParameterMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(ticketURL);
		
		httpPost.setHeader("apiName",heardParameterMap.get("apiName"));
		httpPost.setHeader("clientId",heardParameterMap.get("clientId"));
		httpPost.setHeader("accessToken",heardParameterMap.get("accessToken"));
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//		if(parameterMap != null) {
//			parameterMap.forEach( (key, value) -> {
//				nvps.add(new BasicNameValuePair(key, value));
//			});
//		}
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		
		try {
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
                return  convertStreamToString(entity.getContent());
				
            }
		} finally {
		    response.close();
		}
		return null;
	}
}
