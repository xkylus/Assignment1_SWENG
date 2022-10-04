package com.journaldev.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class stringToArray {
	public static void main(String[] args) {
        String line = "1 + 3 - 5";
        //using String split function
        String[] words = line.split(" ");
        System.out.println(Arrays.toString(words));
        //using java.util.regex Pattern
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(line);
        System.out.println(Arrays.toString(words));
    }
}

