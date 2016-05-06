package com.sbbi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CallPython {

	private final String PATH = "/home/bsilva/Desktop/sbbi/foodEngine/engine.py";
	
	public void call(){
		
		String photo = "/home/bsilva/Desktop/sbbi/foodEngine/building.jpg";
		
		
		//long currentTimeMillis = System.currentTimeMillis();
		
		 ProcessBuilder pb = new ProcessBuilder("python", PATH, photo);
		 
		 try {
			Process p = pb.start();
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			 System.out.println(in.readLine());
			 //int ret = new Integer(in.readLine());
			 //System.out.println("value is : "+ret);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
