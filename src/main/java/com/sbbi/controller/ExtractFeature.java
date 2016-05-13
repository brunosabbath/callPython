package com.sbbi.controller;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class ExtractFeature {

	private final int FEATURES_SIZE = 180856; 
	private final String PATH = "/home/bsilva/Desktop/sbbi/foodEngine/";
	private final String ENGINE_PATH = PATH + "engine.py";
	
	public double[] call(String photo) {

		String photoDir = "/home/bsilva/Desktop/" + photo;

		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("current time: " + currentTimeMillis);
		BufferedReader br = null;

		//ProcessBuilder pb = new ProcessBuilder("python", PATH + "engine.py", photoDir, currentTimeMillis + "");
		
		//BigDecimal features[] = new BigDecimal[FEATURES_SIZE];
		double features[] = new double[FEATURES_SIZE];
		
		try {
			
			String command = "python " + ENGINE_PATH + " " + photoDir + " " + currentTimeMillis;
			System.out.println(command);
			
			//execute process
			Process exec = Runtime.getRuntime().exec(command);
			exec.waitFor();
			
			String sCurrentLine;

			//read features from file
			br = new BufferedReader(new FileReader(currentTimeMillis + ".txt"));
			
			int i = 0;
			
			while ((sCurrentLine = br.readLine()) != null) {
				//features[i] = new BigDecimal(Double.parseDouble(sCurrentLine));
				//featuresStr[i] = sCurrentLine;
				features[i] = Double.parseDouble(sCurrentLine);
				i++;
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//return features;
		return features;

	}
}