package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

	public static void main(String[] args) {
		//useless method
        throw new UnsupportedOperationException();
	}

	public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.update(input.getBytes());
		byte[] hash = digest.digest();
		StringBuilder bld = new StringBuilder();
		for (byte elem : hash) {
			String str = Integer.toHexString(elem);
			if (str.length() > 2) {
				str = str.substring(6);
			}
			if (str.length() == 1) {
				str = "0" + str;
			}
			bld.append(str);
		}
		return bld.toString().toUpperCase();
	}
}
