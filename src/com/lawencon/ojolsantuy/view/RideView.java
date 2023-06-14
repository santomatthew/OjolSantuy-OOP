package com.lawencon.ojolsantuy.view;

import com.lawencon.ojolsantuy.model.Driver;
import com.lawencon.ojolsantuy.service.DriverService;
import com.lawencon.ojolsantuy.service.RideService;
import com.lawencon.ojolsantuy.util.ScannerUtil;

public class RideView {

	private final RideService rideService;
	private final DriverService driverService;

	RideView(RideService rideService, DriverService driverService) {
		this.rideService = rideService;
		this.driverService = driverService;
	}

	void show() {
		System.out.println("===== Ride Santuy =====");
		final String inputFrom = ScannerUtil.scannerStr("From : ");
		final String inputTo = ScannerUtil.scannerStr("To : ");

		final double total = rideService.calculateTotal(inputFrom, inputTo);
		final Driver driver = driverService.findDriver();
		System.out.println("===== Details =====");
		System.out.println("Nama Driver : " + driver.getFullName());
		System.out.println("No Plat : " + driver.getPlatNo());
		System.out.println("Hp : " + driver.getHp());
		System.out.println("Total : Rp." + total);
	}
}
