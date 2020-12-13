package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args) {
        try {
            Demo.print("PART4");
            Demo.print(' ');
            Demo.print(h\u0061sh("asdf", "MD5"));
            Demo.print(h\u0061sh("asdf", "SHA-256"));
            Demo.print(System.lineSeparator());
        } catch (NoSuchAlgorithmException e) {
            Demo.print(e.getStackTrace());
        }
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder hexHashString = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        for (byte hashPart : hash) {
            hexHashString.append(String.format("%02X", hashPart));
        }
        return hexHashString.toString();
    }
}
