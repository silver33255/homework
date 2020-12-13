package com.epam.rd.java.basic.practice3;

import java.security.*;
import java.util.Arrays;

public class Part4 {

    public static void main(String[] args) {
        try {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%1X", b));
        }
        return sb.toString();
    }
}
