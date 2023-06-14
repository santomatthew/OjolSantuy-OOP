package com.lawencon.ojolsantuy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.ojolsantuy.model.Food;
import com.lawencon.ojolsantuy.model.Order;
import com.lawencon.ojolsantuy.model.Restaurant;
import com.lawencon.ojolsantuy.service.FoodService;

public class FoodServiceImpl implements FoodService {

	@Override
	public List<Food> findFood(int idRestaurant) {
		final List<Food> food = new ArrayList<Food>();

		// Restaurant 1 Food 1
		final Food bakso = new Food();
		bakso.setName("Bakso");
		bakso.setPrice(15000);
		bakso.setRestaurantId(1);
		food.add(bakso);

		// Restaurant 1 Food 2
		final Food indomie = new Food();
		indomie.setName("Indomie");
		indomie.setPrice(20000);
		indomie.setRestaurantId(1);
		food.add(indomie);

		// Restaurant 1 Food 3
		final Food nugget = new Food();
		nugget.setName("Nugget");
		nugget.setPrice(12000);
		nugget.setRestaurantId(1);
		food.add(nugget);

		// Restaurant 1 Food 4
		final Food sausage = new Food();
		sausage.setName("Sosis");
		sausage.setPrice(13000);
		sausage.setRestaurantId(1);
		food.add(sausage);

		// Restaurant 1 Food 5
		final Food friedTofu = new Food();
		friedTofu.setName("Tahu Goreng");
		friedTofu.setPrice(20000);
		friedTofu.setRestaurantId(1);
		food.add(friedTofu);

		// Restaurant 2 Food 1
		final Food friedBeef = new Food();
		friedBeef.setName("Barbeque Beef");
		friedBeef.setPrice(50000);
		friedBeef.setRestaurantId(2);
		food.add(friedBeef);

		// Restaurant 2 Food 2
		final Food pizza = new Food();
		pizza.setName("Pizza");
		pizza.setPrice(70000);
		pizza.setRestaurantId(2);
		food.add(pizza);

		// Restaurant 2 Food 3
		final Food chickenFillet = new Food();
		chickenFillet.setName("Chicken Fillet");
		chickenFillet.setPrice(45000);
		chickenFillet.setRestaurantId(2);
		food.add(chickenFillet);

		// Restaurant 2 Food 4
		final Food chocolateBread = new Food();
		chocolateBread.setName("Roti Cokelat");
		chocolateBread.setPrice(20000);
		chocolateBread.setRestaurantId(2);
		food.add(chocolateBread);

		// Restaurant 2 Food 5
		final Food chickenKatsu = new Food();
		chickenKatsu.setName("Chicken katsu");
		chickenKatsu.setPrice(47000);
		chickenKatsu.setRestaurantId(2);
		food.add(chickenKatsu);

		// Restaurant 3 Food 1
		final Food friedDuck = new Food();
		friedDuck.setName("Bebek Goreng");
		friedDuck.setPrice(62000);
		friedDuck.setRestaurantId(3);
		food.add(friedDuck);

		// Restaurant 3 Food 2
		final Food duckBento = new Food();
		duckBento.setName("Bebek Bento");
		duckBento.setPrice(49000);
		duckBento.setRestaurantId(3);
		food.add(duckBento);

		// Restaurant 3 Food 3
		final Food takoyakiDuck = new Food();
		takoyakiDuck.setName("Takoyaki bebek");
		takoyakiDuck.setPrice(72000);
		takoyakiDuck.setRestaurantId(3);
		food.add(takoyakiDuck);

		// Restaurant 3 Food 4
		final Food pekingDuck = new Food();
		pekingDuck.setName("Bebek Peking Goreng");
		pekingDuck.setPrice(56000);
		pekingDuck.setRestaurantId(3);
		food.add(pekingDuck);

		// Restaurant 3 Food 5
		final Food duckSatay = new Food();
		duckSatay.setName("Sate Bebek");
		duckSatay.setPrice(46000);
		duckSatay.setRestaurantId(3);
		food.add(duckSatay);

		// Restaurant 4 Food 1
		final Food friedRice = new Food();
		friedRice.setName("Nasi Goreng");
		friedRice.setPrice(30000);
		friedRice.setRestaurantId(4);
		food.add(friedRice);

		// Restaurant 4 Food 2
		final Food dimsum = new Food();
		dimsum.setName("Dimsum");
		dimsum.setPrice(24000);
		dimsum.setRestaurantId(4);
		food.add(dimsum);

		// Restaurant 4 Food 3
		final Food friedCorn = new Food();
		friedCorn.setName("Jagung Goreng");
		friedCorn.setPrice(13000);
		friedCorn.setRestaurantId(4);
		food.add(friedCorn);

		// Restaurant 4 Food 4
		final Food miePangsit = new Food();
		miePangsit.setName("Mie Pangsit");
		miePangsit.setPrice(18500);
		miePangsit.setRestaurantId(4);
		food.add(miePangsit);

		// Restaurant 4 Food 5
		final Food popcorn = new Food();
		popcorn.setName("Popcorn");
		popcorn.setPrice(27000);
		popcorn.setRestaurantId(4);
		food.add(popcorn);

		// Restaurant 5 Food 1
		final Food chickenSoup = new Food();
		chickenSoup.setName("Sup Ayam");
		chickenSoup.setPrice(28000);
		chickenSoup.setRestaurantId(5);
		food.add(chickenSoup);

		// Restaurant 5 Food 2
		final Food friedPotato = new Food();
		friedPotato.setName("Kentang Goreng");
		friedPotato.setPrice(25000);
		friedPotato.setRestaurantId(5);
		food.add(friedPotato);

		// Restaurant 5 Food 3
		final Food friedEgg = new Food();
		friedEgg.setName("Telur Goreng");
		friedEgg.setPrice(8000);
		friedEgg.setRestaurantId(5);
		food.add(friedEgg);

		// Restaurant 5 Food 4
		final Food iceCream = new Food();
		iceCream.setName("Ice Cream");
		iceCream.setPrice(19000);
		iceCream.setRestaurantId(5);
		food.add(iceCream);

		// Restaurant 5 Food 5
		final Food puding = new Food();
		puding.setName("Puding");
		puding.setPrice(5000);
		puding.setRestaurantId(5);
		food.add(puding);

		final List<Food> foodFromRestaurant = new ArrayList<Food>();
		for (int i = 0; i < food.size(); i++) {
			if (food.get(i).getRestaurantId() == idRestaurant)
				foodFromRestaurant.add(food.get(i));
		}

		return foodFromRestaurant;
	}

	@Override
	public List<Restaurant> findRestaurant() {
		final List<Restaurant> restaurant = new ArrayList<Restaurant>();
		// Restaurant 1
		final Restaurant upnormal = new Restaurant();
		upnormal.setName("Upnormal");
		upnormal.setAddress("Jl. Pakuwon Raya");
		upnormal.setIdRestaurant(1);
		restaurant.add(upnormal);

		// Restaurant 2
		final Restaurant hanamasa = new Restaurant();
		hanamasa.setName("Hanamasa");
		hanamasa.setAddress("Jl. Kawan lama");
		hanamasa.setIdRestaurant(2);
		restaurant.add(hanamasa);

		// Restaurant 3
		final Restaurant bebekKaleyo = new Restaurant();
		bebekKaleyo.setName("Bebek Kaleyo");
		bebekKaleyo.setAddress("Jl Asahan 2");
		bebekKaleyo.setIdRestaurant(3);
		restaurant.add(bebekKaleyo);

		// Restaurant 4
		final Restaurant podomoro = new Restaurant();
		podomoro.setName("Podomoro");
		podomoro.setAddress("Jl. Cipondok Keraton");
		podomoro.setIdRestaurant(4);
		restaurant.add(podomoro);

		// Restaurant 5
		final Restaurant kfc = new Restaurant();
		kfc.setName("KFC");
		kfc.setAddress("Jl. Margonda");
		kfc.setIdRestaurant(5);
		restaurant.add(kfc);

		return restaurant;
	}

	@Override
	public int calculateTotal(int price, int quantity) {
		return price * quantity;
	}

	@Override
	public int checkFoodIfAlreadyOrdered(String name, List<Order> orders) {
		int takeField = 0;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getFoodName().equals(name)) {
				takeField = i;
			}
		}
		return takeField;
	}

	@Override
	public Boolean checkName(String name, List<Order> orders) {
		Boolean result = false;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getFoodName().equals(name)) {
				result = true;
			}
		}
		return result;

	}

	@Override
	public Order editQty(int qty, Order order) {
		order.setQuantity(qty);
		return order;
	}

	@Override
	public Order addNewOrder(String name, int price, int qty) {
		final Order newOrder = new Order();

		newOrder.setFoodName(name);
		newOrder.setFoodPrice(price);
		newOrder.setQuantity(qty);

		return newOrder;

	}

	@Override
	public String getRestaurantAddress(List<Restaurant> restaurants, int restaurantId) {
		String address = "";
		for (int i = 0; i < restaurants.size(); i++) {
			if (restaurants.get(i).getIdRestaurant() == restaurantId) {
				address = restaurants.get(i).getAddress();
			}
		}
		return address;
	}

}
