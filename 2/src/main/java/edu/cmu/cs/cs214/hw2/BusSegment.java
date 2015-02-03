package edu.cmu.cs.cs214.hw2;


/**
 * 
 * @author shuruiz
 *
 */
public class BusSegment implements TripSegment {

	private int lastTime;
	private Stop src;

	private Stop dest;
	private Itinerary itinerary = new Itinerary();
	private String busName;

	/**
	 * 
	  * @param last
	 *                last time
	 * @param s
	 *                start stop
	 * @param d
	 *                destination
	 * @param bs
	 * 		bus name
	 */
 public BusSegment(int last, Stop s, Stop d, String bs) {
		this.lastTime = last;
		this.src = s;
		this.dest = d;
		this.busName = bs;
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return lastTime;
	}

	/**
	 * start stop
	 * 
	 * @return src
	 */
	public Stop getSrc() {
		return src;
	}

	/**
	 * destination
	 * 
	 * @return dest
	 */
	public Stop getDest() {
		return dest;
	}

	@Override
	public Itinerary getItinerary() {
		// TODO Auto-generated method stub
		return itinerary;
	}

}
