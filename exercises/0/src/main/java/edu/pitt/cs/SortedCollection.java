package edu.pitt.cs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class SortedCollection {

	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	private ArrayList<Integer> collect = new ArrayList<>();
	int size = 0;
	public boolean add(int n) {
		int x = Collections.binarySearch(collect, n);
		if(x < 0) x = -x - 1;
		collect.add(x, n);
		size++;
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		if(collect.isEmpty()) throw new NoSuchElementException();
		int small = collect.remove(0);
		return small;
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		for (int i = 0; i < args.length; i++) {
			try {
				int x = Integer.parseInt(args[i]);
				collection.add(x);
			}
			catch(NumberFormatException e){	
				showUsage();
				return;
			}
		}
		
		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
