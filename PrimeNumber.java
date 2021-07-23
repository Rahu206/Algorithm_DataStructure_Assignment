package com.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter lower bound of the interval: ");
        int lowerBound = sc.nextInt();

        System.out.print("Enter upper bound of the interval: ");
        int upperBound = sc.nextInt();

        System.out.println("Prime numbers between " +lowerBound + " and " +upperBound+ " are: ");
        checkPrime(lowerBound, upperBound);
    }

    public static void checkPrime(int lowerBound, int upperBound) {
        int flag = 0;
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound; i++) {
            if (i == 1 || i == 0)
                continue;
            flag = 1;

            for (int j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                System.out.print(i + " ");
                arrayList.add(Integer.toString(i));
            }
        }
        System.out.println();
    }
}
