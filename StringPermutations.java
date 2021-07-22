package com.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringPermutations {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String str = scanner.next();
        String empty = "";
        int length = str.length();
        
        System.out.println("Possible Permutations of strings are :  ");
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        arr1 = permutationsUsingIterativeMethod(arr1,str, empty);
        	System.out.println("Using Recursion : ");
        arr2 = permutationUsingRecursion(arr2,str,0,length - 1);
        	System.out.println(arr1);
        	System.out.println(arr2);
        Collections.sort(arr1);
        Collections.sort(arr2);
        if(arr1 == arr2)
            System.out.println("Both Strings are equal");
        else
            System.out.println("Both of them are not equal ");
    }

    public static ArrayList permutationsUsingIterativeMethod(ArrayList<String> arr1 ,String str, String answer) {

        int length = str.length();
        if (length == 0) {
            System.out.println(answer + " ");
            arr1.add(answer);
        }

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            String leftStr = str.substring(0, i);
            String rightStr = str.substring(i + 1);
            String restStr = leftStr + rightStr;
            permutationsUsingIterativeMethod(arr1,restStr, answer + ch);
        }
        return arr1;
    }

    public static ArrayList permutationUsingRecursion(ArrayList<String>arr2,String str, int l, int r) {
        if(l == r) {
            System.out.println(str);
            arr2.add(str);
        }
        else{
            for(int i = l; i <= r ; i++){
                str = swap(str,l,i);
                permutationUsingRecursion(arr2,str,l+1,r);
                str = swap(str,l,i);

            }
        }
        return arr2;
    }

    private static String swap(String str, int l, int i) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[l];
        charArray[l] = charArray[i];
        charArray[i] = temp;
        return String.valueOf(charArray);
    }
}
