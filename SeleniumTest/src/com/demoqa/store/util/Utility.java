package com.demoqa.store.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
	
	public static JSONObject readJson(String jsonpath) {
      

        try {
            InputStream is = Utility.class.getResourceAsStream(jsonpath);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String jsonString = sb.toString();

            JSONObject jsonObject = new JSONObject(jsonString);
            
            JSONObject checkOutObject = jsonObject.getJSONObject("checkout_info");
            
            return checkOutObject;            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }	  
        
        return null;
    }
	
	

}
