package edu.cmu.cs.cs214.hw2;

import java.util.ArrayList;

/**
 * 
 * @author shuruiz
 *
 */
public interface RoutePlanner {
	/**
	 * search bus stop by substring
	 * @param search 
	 * 		String 
	 * @return stop list
	 */
	ArrayList<Stop> findStopBySubstring(String search);

	/**
	 * 
	 * @param src  
	 *  		start stop
	 * @param dest
	 * 		destination stop
	 * @param time
	 * 		starting time
	 * @return
	 * 		Itinarary result
	 */
	Itinerary computeRoute(Stop src, Stop dest, int time);

}
