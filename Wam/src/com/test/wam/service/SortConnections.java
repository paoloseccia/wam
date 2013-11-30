package com.test.wam.service;

import com.test.wam.Connection;

/**
 * Utility class to sort a collection of boarding connection
 * 
 * @author Paolo Seccia
 *
 */
public class SortConnections {

	/**
	 * Sort an array of Connections Board.
	 * 
	 * This algorithm work if there is always an unbroken chain between
	 * all the legs of the trip. 
	 * 
	 * @param arrayConnections - The Unsorted Connections Board
	 */
	public static void mergeSort(Connection[] arrayConnections) {
		for (int i = 0; i < arrayConnections.length; i++) {

			for (int j = i + 1; j < arrayConnections.length; j++) {

				if (arrayConnections[i].getFrom().equalsIgnoreCase(
						arrayConnections[j].getTo())) {
					Connection c = arrayConnections[j];
					arrayConnections[j] = arrayConnections[i];
					arrayConnections[i] = c;
				}

			}
		}
	}

}
