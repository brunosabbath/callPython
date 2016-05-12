package com.sbbi;

import java.math.BigDecimal;

import com.sbbi.controller.CallPython;
import com.sbbi.dao.connection.MongoConnection;
import com.sbbi.model.MenuItem;
import com.sbbi.model.Restaurant;
import com.sbbi.similarity.Similarity;

public class App {
	
    public static void main( String[] args ){
        
    	CallPython c = new CallPython();
    	//String[] features = c.call();
    	
    	MongoConnection mongo = new MongoConnection();
    	
    	/*MenuItem menuItem = new MenuItem();
    	menuItem.setName("strogonoff 2");
    	menuItem.setFeatures(features);
    	mongo.insertMenuItem(menuItem, "Rodizio Grill");*/
    	
    	String listRestaurants[] = {"Noodles Company"};
    	String features[] = new String[1];
    	calcSimilarity(features, listRestaurants);
    	
    	//Restaurant r = mongo.getRestaurant("Subway");
    	
    	/*String restaurantName = "Noodles Company";
		String menuItemName = "pasta";
		mongo.deleteItemMenu(restaurantName, menuItemName);*/
    	
    	/*Restaurant restaurant = new Restaurant();
    	restaurant.setName("Rodizio Grill");
    	mongo.insertRestaurant(restaurant);*/
    	
    }

	private static void calcSimilarity(String[] features, String[] listRestaurants) {
		
		MongoConnection mongo = new MongoConnection();
		Similarity similarity = new Similarity();
		
		for(String restaurantStr : listRestaurants){
			Restaurant restaurant = mongo.getRestaurant(restaurantStr);
			System.out.println("oi");
		}
		
	}
}
