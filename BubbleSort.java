package com.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

	public static class BubbleSortImplementation<T extends Comparable<T>> {
		T[] elements;

		public BubbleSortImplementation(T[] elements) {
			this.elements = elements;
		}

		public void sort() {
			int length = elements.length;

			System.out.print("Before sorting: ");
			for (int i = 0; i < length; i++) {
				System.out.print(elements[i] + " ");
			}
			System.out.println();

			for (int i = 0; i < length - 1; i++) {
				for (int j = 0; j < length - i - 1; j++) {
					if (elements[j].compareTo(elements[j + 1]) > 0) {
						T temp = elements[j];
						elements[j] = elements[j + 1];
						elements[j + 1] = temp;
					}
				}
			}
			printSortedArray();
		}

		public void printSortedArray() {
			System.out.print("After sorting: ");
			for (int i = 0; i < elements.length; i++)
				System.out.print(elements[i] + " ");
		}

		public static class ReadFile {
			public static ArrayList<Integer> readFile() {
				ArrayList<Integer> dataArray = new ArrayList<>();
				String data = " ";
				String filePath = "C:\\\\Users\\\\Administrator.LAPTOP-BH6CAQ0T\\\\OneDrive\\\\Desktop/File1.txt";
				try {
					File myObj = new File(filePath);
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						// reading the line from the file and removing the "," from the line
						data = myReader.nextLine().replaceAll(",", data);
						// splitting the data into new line based on white space
						String[] data1 = data.split("\\W+");
						for (String s : data1)
							dataArray.add(Integer.parseInt(s));
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

			// read data from the file
			ReadFile read = new ReadFile();
			ArrayList<Integer> dataArray = read.readFile();

			// convert the arraylist into array to pass it to the generic class
			Integer[] array = new Integer[dataArray.size()];
			array = dataArray.toArray(array);

			// call the bubble sort method
			BubbleSortImplementation bubbleSort = new BubbleSortImplementation(array);
			bubbleSort.sort();
		}

	}
}
