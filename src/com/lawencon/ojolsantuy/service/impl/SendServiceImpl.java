package com.lawencon.ojolsantuy.service.impl;

import com.lawencon.ojolsantuy.service.SendService;

public class SendServiceImpl implements SendService {

	@Override
	public double calculateTotal(String from, String to, double weight, double price) {
		final double result = (weight * price) + (from.length() + to.length());
		return result;
	}

}
