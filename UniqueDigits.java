package com.leetcode;

public class UniqueDigits {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(countNumbersWithUniqueDigits(n));
	}

	private static int countNumbersWithUniqueDigits(int k) {
		int p = 9;
		int sum = 10;
		if (k == 1) {
			return 10;
		}
		if (k == 0) {
			return 1;
		}
		for (int i = 2; i <= k; i++) {
			p = p * (9 - i + 2);
			sum = sum + p;
		}
		return sum;
	}
}
