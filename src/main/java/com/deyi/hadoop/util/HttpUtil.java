package com.deyi.hadoop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
	public static String getJsonReseponse(String tagUrl) {
		StringBuffer document = new StringBuffer();
    	try{
    	URL url = new URL(tagUrl);
    	URLConnection conn = url.openConnection();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	String line = null;
    	while ((line = reader.readLine()) != null)
    	document.append(line + "\n");
    	reader.close();
    	}catch(MalformedURLException e) {
    	e.printStackTrace();
    	}catch(IOException e){
    	e.printStackTrace();
    	}
		return document.toString();
	}
}
