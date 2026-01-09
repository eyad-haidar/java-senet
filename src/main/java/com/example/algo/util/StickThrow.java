package com.example.algo.util;

import java.util.concurrent.ThreadLocalRandom;
/*
 * DEV_NOTES: the returns in this class are wrong , just naming functions ,.
 */
public class StickThrow {
	public static int throwSticks() {
		/*
		 * this is a mathmatical representation , the bits value will be between 0->15 ( all will be represented with 4 bits ) 
		 * and then the sum variable will be the count of 1's in the binary format of the randomly generated number . 
		 * 		 */
		int bits = ThreadLocalRandom.current().nextInt(16); 
	    int sum = Integer.bitCount(bits);
	    return sum == 0 ? 5 : sum;
	}
}