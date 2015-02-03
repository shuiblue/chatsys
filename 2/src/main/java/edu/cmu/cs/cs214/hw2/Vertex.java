package edu.cmu.cs.cs214.hw2;

import java.util.ArrayList;


/**
 * 
 * @author shuruiz
 *
 */
public class Vertex implements Stop{
	private String stationName;
	
	private double latitude, longitude;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	@Override
	public String getStationName() {
		return stationName;
	}
	/**
	 * 
	 * @return edges list
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	/**
	 * 
	 * @param edgesList
	 * 		all the edges connect to this station
	 */
	public void setEdges(ArrayList<Edge> edgesList) {
		this.edges = edgesList;
	}
	/**
	 * @param stname
	 * 			set Station Name
	 */
	public void setStationName(String stname) {
		this.stationName = stname;
	}


	/**
	 * 
	 * @param stn station name
	 * @param lat latitute
	 * @param lgt longitute
	 */
	public Vertex(String stn, double lat, double lgt) {
	this.stationName = stn;
	this.latitude = lat;
	this.longitude = lgt;
	}
	
	

	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}
	@Override
	public void setLatitude(double lat) {
		this.latitude = lat;
		
	}
	@Override
	public void setLongitude(double lgt) {
		this.longitude = lgt;
	}

}
