package com.algorithm;

import java.util.Scanner;

public class InsertionStringSort {
	public static void main(String[] args) {
		        System.out.println("Enter the num of elements in String : ");
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        String[] array = new String[n];
		        
		        for (int i = 0; i < n; i++) {
		            System.out.println("Enter the Name which You want to Sort: " );
		            array[i]=sc.next();
		        }
		        InsertionSort insertionSort = new InsertionSort();
		        array=insertionSort.insertionSort(array);
		        
		        System.out.print("String Name After sorting are : ");
		        for (int j = 0;j<n;j++) {
		            System.out.print(array[j] + " ");
		        }


		    }
		    public <E extends Comparable<E>> E[] insertionSort(E[] array){
		        for(int i = 1; i < array.length ; i++){
		            int hole = i;
		            E val = array[i];
		            while(hole > 0 && array[hole-1].compareTo(val)>0 ){
		                array[hole]=array[hole-1];
		                hole=hole-1;
		            }
		            array[hole]=val;
		        }
		        return array;

		    }
		
	}


