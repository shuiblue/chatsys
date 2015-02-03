package edu.cmu.cs.cs214.hw2;


/**
 * 
 * @author shuruiz
 *
 */
public class WaitSegment implements TripSegment {

	private int waitTime;
	private Stop stop;
	private Itinerary itinerary  = new Itinerary();;

	/**
	 * 
	 * @param wt
	 *                waiting time
	 * @param st
	 *                stop
	 */
	public WaitSegment(int wt, Stop st) {
		this.waitTime = wt;
		this.stop = st;
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return waitTime;
	}

	/**
	 * 
	 * @return waiting stop
	 */
	public Stop getStop() {
		return stop;
	}

	@Override
	public Itinerary getItinerary() {
		// TODO Auto-generated method stub
		return itinerary;
	}

}
