package edu.random;

import java.util.Random;

public class Rand {

	public static void main(String[] args) {
		String[] names = new String[] {
			
			"Denis"
		};
		Random r = new Random();
		System.out.println(names[r.nextInt(names.length)]);
 	}

}
