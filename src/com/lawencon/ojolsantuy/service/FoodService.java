package com.lawencon.ojolsantuy.service;

import java.util.List;

import com.lawencon.ojolsantuy.model.Food;
import com.lawencon.ojolsantuy.model.Order;
import com.lawencon.ojolsantuy.model.Restaurant;

public interface FoodService {

	List<Restaurant> findRestaurant();

	List<Food> findFood(int restaurantId);

	int checkFoodIfAlreadyOrdered(String name, List<Order> orders);

	Boolean checkName(String name, List<Order> orders);

	Order addNewOrder(String name, int price, int qty);

	Order editQty(int qty, Order order);

	int calculateTotal(int price, int quantity);

	String getRestaurantAddress(List<Restaurant> restaurants, int restaurantId);
}
