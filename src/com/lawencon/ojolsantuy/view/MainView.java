package com.lawencon.ojolsantuy.view;

import com.lawencon.ojolsantuy.service.DriverService;
import com.lawencon.ojolsantuy.service.FoodService;
import com.lawencon.ojolsantuy.service.RideService;
import com.lawencon.ojolsantuy.service.SendService;
import com.lawencon.ojolsantuy.service.impl.DriverServiceImpl;
import com.lawencon.ojolsantuy.service.impl.FoodServiceImpl;
import com.lawencon.ojolsantuy.service.impl.RideServiceImpl;
import com.lawencon.ojolsantuy.service.impl.SendServiceImpl;
import com.lawencon.ojolsantuy.util.ScannerUtil;

public class MainView {

	public void showMenu() {
		System.out.println("===== Ojol Santuy =====");
		System.out.println("1. Ride");
		System.out.println("2. Send");
		System.out.println("3. Food");
		System.out.println("4. Keluar Menu");

		final int chooseMenu = ScannerUtil.scannerInt("Pilih Menu :", 1, 3);

		if (chooseMenu == 1) {
			final RideService rideService = new RideServiceImpl();
			final DriverService driverService = new DriverServiceImpl();
			final RideView rideView = new RideView(rideService, driverService);
			rideView.show();
			showMenu();
		} else if (chooseMenu == 2) {
			final DriverService driverService = new DriverServiceImpl();
			final SendService sendService = new SendServiceImpl();
			final SendView sendView = new SendView(driverService, sendService);
			sendView.show();
			showMenu();
		} else if (chooseMenu == 3) {
			final DriverService driverService = new DriverServiceImpl();
			final FoodService foodService = new FoodServiceImpl();
			final RideService rideService = new RideServiceImpl();
			final FoodView foodView = new FoodView(rideService, driverService, foodService);
			foodView.show();
			showMenu();
		} else if (chooseMenu == 4) {
			System.out.println("Anda keluar menu");
		}
	}
}
