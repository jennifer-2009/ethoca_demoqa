package com.demoqa.store.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.testng.Reporter;

public class ConfigFileReader {
	
	 public static Map<String, String>  readTxt(String filePath) {
	        Map<String, String> map = new ConcurrentHashMap<>();

	        try {
	            InputStream is = new FileInputStream(filePath);
	            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

	            String line = buf.readLine();
	            while(line != null){
	                String[] tokens = line.split("=");
	                map.put(tokens[0], tokens[1]);

	                line = buf.readLine();
	            }

	        } catch (IOException e) {
	        	Reporter.log("Read Config File - IOException............"+e.getMessage());
	        }

	        return map;
	    }
	    
	    public static String getConfigValue(String key){
	    	
	    	Map<String, String> map = readTxt("config.txt");
	    	
	    	for (Map.Entry<String, String> entry : map.entrySet()) {
	            if(key.equalsIgnoreCase(entry.getKey()))
	                return entry.getValue();            
	        }
	    	return null;
	    }   
}
