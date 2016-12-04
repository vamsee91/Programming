package com.leetcode;

public class MissingNumber {

	public static void main(String[] args) {
		int []nums = {0, 1};
		System.out.println(missingNumber(nums));
	}

	private static int missingNumber(int[] nums) {
		int l = nums.length;
		if (l == 1 && nums[l - 1] == 0) {
			return 1;
		} else if (l == 1 && nums[l-1] != 0) {
			return 0;
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < l; i++) {
			sum = sum + nums[i];
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		int k = (max * (max + 1)) /2;
		if (k == sum) {
			return l;
		}
		return (k - sum);
	}
}
