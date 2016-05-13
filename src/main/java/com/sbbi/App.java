package com.sbbi;

import com.sbbi.controller.ExtractFeature;
import com.sbbi.dao.connection.MongoConnection;
import com.sbbi.model.MenuItem;
import com.sbbi.model.Restaurant;
import com.sbbi.similarity.Similarity;

public class App {
	
    public static void main( String[] args ){
        
    	String photo = "cheessi.jpg";
    	
    	ExtractFeature c = new ExtractFeature();
    	double[] features = c.call(photo);
    	
    	MongoConnection mongo = new MongoConnection();
    	
    	//save new dish
    	/*MenuItem menuItem = new MenuItem();
    	menuItem.setName("ITpasta");
    	menuItem.setFeatures(features);
    	mongo.insertMenuItem(menuItem, "Noodles Company");*/
    	
    	//calculate similarity
    	String listRestaurants[] = {"Noodles Company","Subway","Rodizio Grill"};
    	calcSimilarity(features, listRestaurants);
    	
    	//Restaurant r = mongo.getRestaurant("Subway");
    	
    	/*String restaurantName = "Noodles Company";
		String menuItemName = "pasta";
		mongo.deleteItemMenu(restaurantName, menuItemName);*/
    	
    	/*Restaurant restaurant = new Restaurant();
    	restaurant.setName("Rodizio Grill");
    	mongo.insertRestaurant(restaurant);*/
    	
    }

	private static void calcSimilarity(double[] features, String[] listRestaurants) {
		
		MongoConnection mongo = new MongoConnection();
		Similarity similarity = new Similarity();
		
		for(String restaurantStr : listRestaurants){
			Restaurant restaurant = mongo.getRestaurant(restaurantStr);
			
			for(MenuItem menuItem : restaurant.getMenuItems()){
				double value = similarity.calculate(features, menuItem.getFeatures());
				System.out.println("Similarity with " + menuItem.getName() + ": " + value);
			}
			
		}
		
	}
}
