package com.company.lesson16;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HomeWork {

    public static void main (String[] args) {

        var sc = new Scanner(System.in);
        String str = sc.nextLine();
        Pattern pattern = Pattern.compile("\\.");
        String[] strings = pattern.split(str);
        boolean isIp = true;
        for (var i = 0; i < strings.length; i++) {
            if (!strings[i].matches("[01]?\\d\\d?|2[0-4]\\d|25[0-5]") || !str.matches("\\d.+\\d")) {
                isIp = false;
            }
        }
        System.out.println(isIp ? "It's IP" : "It's not IP");
        sc.close();
    }
}
