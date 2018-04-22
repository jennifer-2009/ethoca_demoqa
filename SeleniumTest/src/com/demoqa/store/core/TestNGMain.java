package com.demoqa.store.core;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNGMain {
	
	public static void main(String args[]){
		List<String> file = new ArrayList<String>();
		
		file.add("./TestNG_Demo.xml");
	    
		TestNG testng = new TestNG();
		testng.setTestSuites(file);
		testng.run();
	}

}
