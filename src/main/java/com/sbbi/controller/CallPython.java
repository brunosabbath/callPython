package com.sbbi.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sbbi.dao.connection.MongoConnection;

public class CallPython {

	private final int FEATURES_SIZE = 180856; 
	private final String PATH = "/home/bsilva/Desktop/sbbi/foodEngine/";
	private final String ENGINE_PATH = PATH + "engine.py";
	
	public String[] call() {

		String photoDir = "/home/bsilva/Desktop/strog1.jpg";

		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("current time: " + currentTimeMillis);
		BufferedReader br = null;

		//ProcessBuilder pb = new ProcessBuilder("python", PATH + "engine.py", photoDir, currentTimeMillis + "");
		
		BigDecimal features[] = new BigDecimal[FEATURES_SIZE];
		String featuresStr[] = new String[FEATURES_SIZE];
		
		try {
			//Process p = pb.start();
			
			String command = "python " + ENGINE_PATH + " " + photoDir + " " + currentTimeMillis;
			System.out.println(command);
			
			Process exec = Runtime.getRuntime().exec(command);
			exec.waitFor();
			
			String sCurrentLine;

			br = new BufferedReader(new FileReader(currentTimeMillis + ".txt"));
			
			int i = 0;
			
			while ((sCurrentLine = br.readLine()) != null) {
				//features[i] = new BigDecimal(Double.parseDouble(sCurrentLine));
				featuresStr[i] = sCurrentLine;
				i++;
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//return features;
		return featuresStr;

	}
}