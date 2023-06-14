package com.lawencon.ojolsantuy.view;

import com.lawencon.ojolsantuy.constant.ItemTypes;
import com.lawencon.ojolsantuy.model.Driver;
import com.lawencon.ojolsantuy.service.DriverService;
import com.lawencon.ojolsantuy.service.SendService;
import com.lawencon.ojolsantuy.util.ScannerUtil;

public class SendView {

	private final ItemTypes[] itemTypes = ItemTypes.values();
	private final DriverService driverService;
	private final SendService sendService;

	SendView(DriverService driverService, SendService sendService) {
		this.driverService = driverService;
		this.sendService = sendService;
	}

	void show() {
		System.out.println("===== Send Santuy =====");

		for (int i = 0; i < itemTypes.length; i++) {
			System.out.println((i + 1) + ". " + itemTypes[i].name);
		}

		final int chosenType = ScannerUtil.scannerInt("Pilih Tipe Barang :", 1, itemTypes.length);
		final String nameType = itemTypes[chosenType - 1].name;
		final int priceType = itemTypes[chosenType - 1].price;
		final double weight = ScannerUtil.scannerDouble("Berat : ", 0);

		final String from = ScannerUtil.scannerStr("Alamat Pengirim : ");
		final String to = ScannerUtil.scannerStr("Alamat Penerima : ");

		final double total = sendService.calculateTotal(from, to, weight, priceType);
		final Driver driver = driverService.findDriver();

		System.out.println("===== Details =====");
		System.out.println("Nama Barang : " + nameType);
		System.out.println("Berat : " + weight);
		System.out.println("Alamat Pengirim : " + from);
		System.out.println("Alamat Penerima : " + to);
		System.out.println("Total : Rp." + total);

		System.out.println("===== Driver Details =====");
		System.out.println("Nama Driver : " + driver.getFullName());
		System.out.println("No Plat : " + driver.getPlatNo());
		System.out.println("Hp : " + driver.getHp());
		System.out.println("Total : Rp." + total);

	}

}
