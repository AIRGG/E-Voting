package util;


import java.util.Random;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AIRGG
 */
public class MyUtility {
    public String generateUUID() {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
    public String getSaltString(Integer batas) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < batas) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    public static void main(String[] args) {
        MyUtility util = new MyUtility();
        String isi = util.generateUUID();
        System.out.println(isi);
        System.out.println(isi.length());
        System.out.println(util.getSaltString(5));
    }
}
