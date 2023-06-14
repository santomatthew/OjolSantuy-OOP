package com.lawencon.ojolsantuy.util;

import java.util.Scanner;

public class ScannerUtil {

	public static int scannerInt(String question, int min, int max) {
		System.out.print(question);
		final Scanner scan = new Scanner(System.in);
		try {
			final String input = scan.nextLine().trim();
			final InputChecker inputChecker = new InputChecker();
			final Boolean isInputString = inputChecker.isString(input);
			if (isInputString) {
				return scannerInt(question, min, max);
			} else {
				int inputStrToInt = Integer.parseInt(input);
				final Boolean isOutOfRange = inputChecker.isOutOfRange(inputStrToInt, min, max);
				if (isOutOfRange) {
					return scannerInt(question, min, max);
				} else {
					return inputStrToInt;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return scannerInt(question, min, max);
		}

	}

	public static int scannerQty(String question, int min) {
		System.out.print(question);
		final Scanner scan = new Scanner(System.in);
		try {
			final String input = scan.nextLine().trim();
			final InputChecker inputChecker = new InputChecker();
			final Boolean isInputString = inputChecker.isString(input);
			if (isInputString) {
				return scannerQty(question, min);
			} else {
				int inputStrToInt = Integer.parseInt(input);
				if (inputStrToInt < min) {
					System.out.println("Quantity minimal " + min);
					return scannerQty(question, min);
				} else {
					return inputStrToInt;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return scannerQty(question, min);
		}
	}

	public static Double scannerDouble(String question, int min) {
		System.out.print(question);
		final Scanner scan = new Scanner(System.in);

		try {
			final String input = scan.nextLine().trim();
			final InputChecker inputChecker = new InputChecker();
			final Boolean isInputString = inputChecker.isString(input);
			if (isInputString) {
				return scannerDouble(question, min);
			} else {
				final Double inputStrToDouble = Double.parseDouble(input);
				final Boolean isOutOfRange = inputChecker.isLessThanMinimum(inputStrToDouble, min);
				if (isOutOfRange) {
					return scannerDouble(question, min);
				} else {
					return inputStrToDouble;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return scannerDouble(question, min);
		}
	}

	public static String scannerStr(String question) {
		System.out.print(question);
		final Scanner scan = new Scanner(System.in);
		final String input = scan.nextLine().trim();
		if (input.equals("")) {
			System.out.println("Invalid Input");
			return scannerStr(question);
		} else {
			return input;
		}
	}

}
