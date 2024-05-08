package com.utils;

import java.util.Random;

public class RandomUtil {
	public static String getRandomNumber() {
		Random rd = new Random();
		
		String result = "";
		for(int i = 1; i <= 6; i++) {
			result += rd.nextInt(10);
		}
		
		return result;
	}
}
