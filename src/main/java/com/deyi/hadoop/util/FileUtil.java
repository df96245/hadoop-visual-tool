package com.deyi.hadoop.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
	public static String readFile(String filePath) throws IOException {
		File file = new File(filePath);
    	InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
    	BufferedReader br = new BufferedReader(reader);
    	StringBuilder sBuilder = new StringBuilder();
    	String lineTxt=null;
        while ((lineTxt = br.readLine()) != null) {
        	boolean uselessLine = lineTxt.contains("This XML file does not appear");
        	boolean containScheduler= lineTxt.contains("<scheduler>")||lineTxt.contains("</scheduler>");
			if (!uselessLine&&!containScheduler) {
        		sBuilder.append(lineTxt+"\n");
			}
        	
        }
		return sBuilder.toString();
	}
}
