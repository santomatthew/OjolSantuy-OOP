package com.lawencon.ojolsantuy.view;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.ojolsantuy.model.Driver;
import com.lawencon.ojolsantuy.model.Food;
import com.lawencon.ojolsantuy.model.Order;
import com.lawencon.ojolsantuy.model.Restaurant;
import com.lawencon.ojolsantuy.service.DriverService;
import com.lawencon.ojolsantuy.service.FoodService;
import com.lawencon.ojolsantuy.service.RideService;
import com.lawencon.ojolsantuy.util.ScannerUtil;

public class FoodView {

	private final DriverService driverService;
	private final FoodService foodService;
	private final List<Order> orders = new ArrayList<Order>();
	private final RideService rideService;

	FoodView(RideService rideService, DriverService driverService, FoodService foodService) {
		this.driverService = driverService;
		this.foodService = foodService;
		this.rideService = rideService;
	}

	void show() {
		System.out.println("====== Food Santuy =====");
		final List<Restaurant> restaurants = foodService.findRestaurant();
		for (int i = 0; i < restaurants.size(); i++) {
			System.out.println(
					(i + 1) + ". " + restaurants.get(i).getName() + " || Alamat : " + restaurants.get(i).getAddress());
		}
		final int chooseRestaurant = ScannerUtil.scannerInt("Pilih Restoran : ", 1, restaurants.size());
		final int idRestaurant = restaurants.get(chooseRestaurant - 1).getIdRestaurant();
		showMenu(idRestaurant);

	}

	private void showMenu(int idRestaurant) {
		System.out.println("===== Choose Food =====");
		final List<Food> foods = foodService.findFood(idRestaurant);
		for (int i = 0; i < foods.size(); i++) {
			System.out.println((i + 1) + ". " + foods.get(i).getName() + " harga = Rp. " + foods.get(i).getPrice());
		}
		final int chooseFood = ScannerUtil.scannerInt("Pilih makanan : ", 1, foods.size());
		final String name = foods.get(chooseFood - 1).getName();
		final int price = foods.get(chooseFood - 1).getPrice();
		final int quantity = ScannerUtil.scannerQty("Mau pesan berapa : ", 1);
		final Boolean check = foodService.checkName(name, orders);

		if (check) {
			final int checkIfAlreadyOrder = foodService.checkFoodIfAlreadyOrdered(name, orders);
			final Order currentOrder = orders.get(checkIfAlreadyOrder);
			currentOrder.setQuantity(orders.get(checkIfAlreadyOrder).getQuantity() + quantity);
			orders.set(checkIfAlreadyOrder, currentOrder);
		} else {
			final Order newOrder = foodService.addNewOrder(name, price, quantity);
			orders.add(newOrder);
		}

		System.out.println("Sukses menambahkan " + quantity + " " + name);
		final int option = ScannerUtil.scannerInt("Masih mau nambah ?(1 Untuk Ya, 2 Untuk Tidak) ", 1, 2);

		if (option == 1) {
			showMenu(idRestaurant);
		} else if (option == 2) {
			showOrderMenu(idRestaurant);
		}
	}

	private void showOrderList() {
		System.out.println("===== Order List =====");
		for (int i = 0; i < orders.size(); i++) {
			System.out.println((i + 1) + ". " + orders.get(i).getFoodName() + " Harga : Rp. "
					+ orders.get(i).getFoodPrice() + " Quantity : " + orders.get(i).getQuantity());
		}
		System.out.println("===== Order List =====");
	}

	private void showOrderMenu(int restaurantId) {
		showOrderList();
		final int grandTotal = getGrandTotal();
		System.out.println("Grand Total = Rp. " + grandTotal);
		System.out.println("1. Edit Quantity");
		System.out.println("2. Remove Partial");
		System.out.println("3. Checkout");
		System.out.println("4. Cancel Order");
		final int chooseMenu = ScannerUtil.scannerInt("Pilih Menu :", 1, 4);
		optionOrderMenu(chooseMenu, restaurantId);
	}

	private void optionOrderMenu(int chooseMenu, int restaurantId) {
		final MainView mainView = new MainView();

		if (chooseMenu == 1) {
			showEditQtyOrder();
			showOrderMenu(restaurantId);
		} else if (chooseMenu == 2) {
			showRemovePartial();
			showOrderMenu(restaurantId);
		} else if (chooseMenu == 3) {
			checkout(restaurantId);
			mainView.showMenu();
		} else if (chooseMenu == 4) {
			cancelOrder();
			mainView.showMenu();
		}
	}

	private void showEditQtyOrder() {
		showOrderList();
		final int chooseOrder = ScannerUtil.scannerInt("Pilih makanan yang mau diganti : ", 1, orders.size());
		editQty(chooseOrder - 1);
	}

	private void editQty(int chooseOrder) {
		final int qtyToUpdate = ScannerUtil.scannerQty("Quantity : ", 1);
		final Order chosenOrder = orders.get(chooseOrder);
		final Order updatedOrder = foodService.editQty(qtyToUpdate, chosenOrder);
		orders.set(chooseOrder, updatedOrder);
	}

	private void showRemovePartial() {
		showOrderList();
		final int chooseOrder = ScannerUtil.scannerInt("Pilih makanan yang mau dihapus : ", 1, orders.size());
		removePartial(chooseOrder - 1);
	}

	private void removePartial(int chooseOrder) {
		orders.remove(chooseOrder);
	}

	private void checkout(int restaurantId) {
		showOrderList();
		final List<Restaurant> restaurants = foodService.findRestaurant();
		final String restaurantAddress = foodService.getRestaurantAddress(restaurants, restaurantId);
		final String receiverAddress = ScannerUtil.scannerStr("Masukkan alamat anda: ");
		final double shippingPrice = rideService.calculateTotal(restaurantAddress, receiverAddress);
		final Driver driver = driverService.findDriver();
		final int grandTotal = getGrandTotal();
		System.out.println("Grand Total = Rp. " + (grandTotal + shippingPrice));
		System.out.println("===== Drivers Detail =====");
		System.out.println("Nama driver : " + driver.getFullName());
		System.out.println("No Plat : " + driver.getPlatNo());
		System.out.println("Hp : " + driver.getHp());
		System.out.println("===== Drivers Detail =====");

		orders.clear();
	}

	private int getGrandTotal() {
		int grandTotal = 0;
		for (int i = 0; i < orders.size(); i++) {
			grandTotal += foodService.calculateTotal(orders.get(i).getFoodPrice(), orders.get(i).getQuantity());
		}
		return grandTotal;
	}

	private void cancelOrder() {
		orders.clear();
		System.out.println("Order anda telah dibatalkan");
	}

}
