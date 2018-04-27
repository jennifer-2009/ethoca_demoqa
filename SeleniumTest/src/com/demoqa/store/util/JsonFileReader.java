package com.demoqa.store.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Reporter;

public class JsonFileReader {
	
	public static JSONObject readJson(String jsonpath, String testData) {
      

        try {
            InputStream is = JsonFileReader.class.getResourceAsStream(jsonpath);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String jsonString = sb.toString();

            JSONObject jsonObject = new JSONObject(jsonString);
            
            JSONObject checkOutObject = jsonObject.getJSONObject(testData);
            
            return checkOutObject;            
        } catch (IOException e) {
        	Reporter.log("IOException............"+e.getMessage());	
        } catch (JSONException e) {
        	Reporter.log("JSONException............"+e.getMessage());	
        }	  
        
        return null;
    }
	
	

}
