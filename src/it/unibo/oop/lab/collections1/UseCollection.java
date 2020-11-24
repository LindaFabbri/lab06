package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;

	private UseCollection() {
	}

	/**
	 * @param s unused
	 */
	public static void main(final String... s) {

		/*
		 * 1) Create a new ArrayList<Integer>, and populate it with the numbers from
		 * 1000 (included) to 2000 (excluded).
		 */

		final ArrayList<Integer> myArrayList = new ArrayList<>();
		for (int i = 1000; i < 2000; i++) {
			myArrayList.add(i);
		}

		/*
		 * 2) Create a new LinkedList<Integer> and, in a single line of code without
		 * using any looping construct (for, while), populate it with the same contents
		 * of the list of point 1.
		 */

		final LinkedList<Integer> myLinkedList = new LinkedList<>();
		myLinkedList.addAll(myArrayList);

		/*
		 * 3) Using "set" and "get" and "size" methods, swap the first and last element
		 * of the first list. You can not use any "magic number". (Suggestion: use a
		 * temporary variable)
		 */

		int firstElement = myArrayList.get(0);
		int lastElement = myArrayList.get((myArrayList.size() - 1));
		myArrayList.set((myArrayList.size() - 1), firstElement);
		myArrayList.set(0, lastElement);

		/*
		 * 4) Using a single for-each, print the contents of the arraylist.
		 */

		for (int num : myArrayList) {
			System.out.println(num);
		}

		/*
		 * 5) Measure the performance of inserting new elements in the head of the
		 * collection: measure the time required to add 100.000 elements as first
		 * element of the collection for both ArrayList and LinkedList, using the
		 * previous lists. In order to measure times, use as example
		 * TestPerformance.java.
		 */

		long time = System.nanoTime();
		for (int i = 1; i < ELEMS; i++) {
			myArrayList.add(i);
		}
		time = System.nanoTime() - time;
		System.out
				.println("Adding " + ELEMS + " element in the ArrayList took " + time + "ns (" + time / TO_MS + "ms)");

		long time2 = System.nanoTime();
		for (int i = 1; i < ELEMS; i++) {
			myLinkedList.add(i);
		}
		time2 = System.nanoTime() - time2;
		System.out.println(
				"Adding " + ELEMS + " elements in the LinkedList took " + time2 + "ns (" + time2 / TO_MS + "ms)");

		/*
		 * 6) Measure the performance of reading 1000 times an element whose position is
		 * in the middle of the collection for both ArrayList and LinkedList, using the
		 * collections of point 5. In order to measure times, use as example
		 * TestPerformance.java.
		 */

		long time3 = System.nanoTime();
		for (int i = 0; i < 1_000; i++) {
			myArrayList.get(ELEMS / 2);
		}
		time3 = System.nanoTime() - time3;
		System.out.println(
				"reading " + ELEMS + " elements in the ArrayList took " + time3 + "ns (" + time3 / TO_MS + "ms)");

		long time4 = System.nanoTime();
		for (int i = 0; i < 1_000; i++) {
			myLinkedList.get(ELEMS / 2);
		}
		time4 = System.nanoTime() - time4;
		System.out.println(
				"reading " + ELEMS + " elements in the linkedList took " + time4 + "ns (" + time4 / TO_MS + "ms)");

		/*
		 * 7) Build a new Map that associates to each continent's name its population:
		 * 
		 * Africa -> 1,110,635,000
		 * 
		 * Americas -> 972,005,000
		 * 
		 * Antarctica -> 0
		 * 
		 * Asia -> 4,298,723,000
		 * 
		 * Europe -> 742,452,000
		 * 
		 * Oceania -> 38,304,000
		 */

		final Map<String, Long> myMap = new HashMap<String, Long>();
		myMap.put("Africa", (long) 1_110_635_000);
		myMap.put("Americas", (long) 972_005_000);
		myMap.put("Antarctica", (long) 0);
		myMap.put("Asia", 4298723000L);
		myMap.put("Europe", (long) 742_452_000);
		myMap.put("Oceania", (long) 38_304_000);

		/*
		 * 8) Compute the population of the world
		 */

		long wordPopulation;
		wordPopulation = myMap.get("Africa") + myMap.get("Americas") + myMap.get("Antarctica") + myMap.get("Asia")
				+ myMap.get("Europe") + myMap.get("Oceania");
		System.out.println(wordPopulation);
	}

}
