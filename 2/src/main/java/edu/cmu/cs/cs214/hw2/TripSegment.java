package edu.cmu.cs.cs214.hw2;


/**
 * 
 * @author shuruiz
 *
 */
public interface TripSegment {
	/**
	 * 
	 * @return last time
	 */
	int getTime();
	/**
	 * 
	 * @return itinerary of certain segment
	 */
	Itinerary getItinerary();
	
}
