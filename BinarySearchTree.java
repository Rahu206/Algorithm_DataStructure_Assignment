package com.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchTree {
	public static class BinarySearchImplementation<T extends Comparable<T>> {
	    T[] elements;

	    public BinarySearchImplementation(T[] elements) {
	        this.elements = elements;
	    }

	    public int search(Comparable<T> v) {
	        int low = 0;
	        int high = elements.length - 1;
	        while (low <= high) {
	            int mid = (low + high) / 2;
	            T midVal = elements[mid];
	            int result = v.compareTo(midVal);
	            if (result < 0) {
	                high = mid - 1;
	            } else if (result > 0) {
	                low = mid + 1;
	            } else {
	                return mid;
	            }
	        }
	        return -1;
	    }
	}
	public static class ReadFile {
	    public static ArrayList<String> readFile() {
	        ArrayList<String> dataArray = new ArrayList<>();
	        String data = " ";
	        String filePath = "C:/Users/Administrator.LAPTOP-BH6CAQ0T/OneDrive/Desktop/File.txt";
	        try {
	            File myObj = new File(filePath);
	            Scanner myReader = new Scanner(myObj);
	            while (myReader.hasNextLine()){
	                data = myReader.nextLine().replaceAll(",", data);
	                String[] data1 = data.split("\\W+");
	                for(String s: data1)
	                    dataArray.add(s);
	            }
	            myReader.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	        return dataArray;
	    }
	} 
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //read data from the file
        ReadFile read = new ReadFile();
        ArrayList<String> dataArray = read.readFile();

        //sort the data in ascending order
        Collections.sort(dataArray);
               System.out.println(dataArray);
        //Take input from the user to search for the word
        System.out.print("Enter the word you want to search from the file: ");
        String value = input.next();

        //convert the arraylist into array to pass it to the generic class
        String[] array = new String[dataArray.size()];
        array = dataArray.toArray(array);

        //Create object for binary search class and check if the user input element is present or not
        BinarySearchImplementation<String> searcher = new BinarySearchImplementation<>(array);
        int result = searcher.search(value);
        if (result >= 0) {
            System.out.println(value + " is at index " + result + " in the array");
        } else {
            System.out.println(value + " is not in the array.");
        }
    }
	
	}	