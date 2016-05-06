package com.sbbi.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CallPython {

	private final String PATH = "/home/bsilva/Desktop/sbbi/foodEngine/";

	public void call() {

		String photoDir = "/home/bsilva/Desktop/sbbi/foodEngine/building.jpg";

		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("current time: " + currentTimeMillis);
		BufferedReader br = null;

		//ProcessBuilder pb = new ProcessBuilder("python", PATH + "engine.py", photoDir, currentTimeMillis + "");
		
		try {
			//Process p = pb.start();
			
			String command = "python " + PATH + "engine.py " + photoDir + " " + currentTimeMillis;
			
			Process exec = Runtime.getRuntime().exec(command);
			exec.waitFor();
			
			String sCurrentLine;

			br = new BufferedReader(new FileReader(PATH + currentTimeMillis + ".txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}