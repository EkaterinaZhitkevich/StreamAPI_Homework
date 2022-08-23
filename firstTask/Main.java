package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> numbers = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> integers = new ArrayList<>();
        for (Integer i: numbers) {
           if (i > 0){
               if (i%2 == 0){
                   integers.add(i);
               }
           }
        }
        Collections.sort(integers);
        System.out.println(integers);
    }
}
