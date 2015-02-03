package edu.cmu.cs.cs214.hw2;



import java.util.ArrayList;

/**
 * @author shuruiz
 *
 */
public class Itinerary {
	private String name;
	private String instruction;
	private Stop startLoation;
	private Stop endLocation;
	private int startTime;
	private int endTime;
	private int waitTime;
	private ArrayList<TripSegment> segments;

	/**
	 * 
	 * @return segement list
	 */
	public ArrayList<TripSegment> getSegments() {
		return segments;
	}

	/**
	 * @param sgs
	 *  * set segment list
	 */
	public void setSegments(ArrayList<TripSegment> sgs) {
		this.segments = sgs;
	}

	/**
	 * get bus name
	 * 
	 * @return string
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param n
	 *                set bus name
	 */
	public void setName(String n) {
		this.name = n;
	}

	/**
	 * get route instruction
	 * 
	 * @return string instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * @param instr
	 *                * set route information
	 */
	public void setInstruction(String instr) {
		this.instruction = instr;
	}

	/**
	 * start stop station
	 * 
	 * @return start location
	 */
	public Stop getStartLoation() {
		return startLoation;
	}

	/**
	 * 
	 * @param stloc
	 *                start station location
	 */
	public void setStartLoation(Stop stloc) {
		this.startLoation = stloc;
	}

	/**
	 * 
	 * @return end station location
	 */
	public Stop getEndLocation() {
		return endLocation;
	}

	/**
	 * @param endloc
	 *                end station location
	 */
	public void setEndLocation(Stop endloc) {
		this.endLocation = endloc;
	}

	/**
	 * 
	 * @return start time
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * @param stime
	 *                set the start time of the person
	 */
	public void setStartTime(int stime) {
		this.startTime = stime;
	}

	/**
	 * get the endtime
	 * 
	 * @return int endtime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * @param et
	 *                set the end time of the trip
	 */
	public void setEndTime(int et) {
		this.endTime = et;
	}

	/**
	 * @return waittime wait time of each segment
	 */
	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * @param wt
	 *                set wait time of the segment
	 * 
	 */
	public void setWaitTime(int wt) {
		this.waitTime = wt;
	}

}
