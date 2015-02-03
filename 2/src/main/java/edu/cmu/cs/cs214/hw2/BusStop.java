package edu.cmu.cs.cs214.hw2;

import java.util.ArrayList;

/**
 * 
 * @author shuruiz
 *
 */
public class BusStop implements Stop {
	private String stationName;
	private double latitude, longitude;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	@Override
	public String getStationName() {
		return stationName;
	}
	@Override
	public void setStationName(String stn) {
		this.stationName = stn;
	}
	@Override
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	@Override
	public void setEdges(ArrayList<Edge> es) {
		this.edges = es;
	}
	@Override
	public void setLatitude(double lat) {
		this.latitude = lat;
	}
	@Override
	public void setLongitude(double lgt) {
		this.longitude = lgt;
	}

	/**
	 * 
	 * @param stn station name
	 * @param lat latitute
	 * @param lgt longitute
	 */
	public BusStop(String stn, double lat, double lgt) {
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

}
