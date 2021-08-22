package com.ontology.app.utils;

import java.util.Random;

public class methods {

	public static String create_string() {
		Random r = new Random(); // just create one and keep it around
	    String alphabet = "abcdefghijklmnopqrstuvwxyz";

	    final int N = 10;
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < N; i++) {
	        sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
	    }
	    String randomName = sb.toString();

	    System.out.println(randomName);
	    return randomName;
	}

	public static void main(String[] args) {
		create_string();
	}
}
