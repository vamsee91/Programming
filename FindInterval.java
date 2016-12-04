package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class FindInterval {

	public static void main(String[] args) {
		Interval []intervals = new Interval[3];
		intervals[0] = new Interval(3,4);
		intervals[1] = new Interval(2,3);
		intervals[2] = new Interval(1,2);
		int []arr = findRightInterval(intervals);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int[] findRightInterval(Interval[] intervals) {
		int []res = new int[intervals.length];
		int len = intervals.length;
		if (len == 1) {
			int []a = new int[1];
			a[0] = -1;
			return a;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < len; i++) {
			map.put(intervals[i].start, i);
		}
		Arrays.sort(intervals, (a, b)->(a.start - b.start));
		for (int i = 0; i < len; i++) {
			int tar = intervals[i].end;
			int left = i+1;
			int right = len ;
			while (left < right) {
				int mid = (left + right)/2;
				if (intervals[mid].start < tar) { left = mid + 1; }
				else { right = mid; }
			}
			res[map.get(intervals[i].start)] = (right == len) ? -1 : map.get(intervals[right].start);
		}
		return res;
	}
}