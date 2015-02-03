package edu.cmu.cs.cs214.hw2;

import java.util.ArrayList;

/**
 * 
 * @author shuruiz
 *
 */
public interface Stop {

	/**
	 * 
	 * @return getStationName
	 */
	 String getStationName();
	/**
	 * 
	 * @return latitude of this station
	 */
	double getLatitude();
	/**
	 * 
	 * @return longitude of the station
	 */
	double getLongitude();
	/**
	 * 
	 * @return edge list that connected to this station
	 */
	ArrayList<Edge> getEdges();
	/**
	 * @param stationName
	 *  * set stationName
	 */
	void setStationName(String stationName) ;
	/**
	 * @param edges
	 * set edges
	 */
	void setEdges(ArrayList<Edge> edges) ;
	/**
	 * @param latitude
	 * * set latitude of the stop
	 */
	void setLatitude(double latitude);
	/**
	 * @param longitude
	 * * set longitude
	 */
	void setLongitude(double longitude);
}
