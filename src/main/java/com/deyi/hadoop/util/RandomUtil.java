package com.deyi.hadoop.util;

import java.util.Random;

public class RandomUtil {
	public static Long genRandomRangeLong() {
		Long min = 10L;
		Long max = 5000L;
		Long rangeLong = min + (((long) (new Random().nextDouble() * (max - min))));
		return rangeLong;
	}
	public static Integer genRandomRangeInteger() {
		Integer min = 10;
		Integer max = 5000;
		Integer rangeLong = min + (((int) (new Random().nextDouble() * (max - min))));
		return rangeLong;
	}
}
