package edu.cmu.cs.cs214.hw2;



/**
 * 
 * @author shuruiz
 *
 */
public class Edge {
	private Vertex from;
	private Vertex to;
	private String busName;
	private int arriveTimeOfFromStation;

	private int arriveTimeOfToStation;
//	private int weight;

	/**
	 * 
	 * @param v1
	 *                'from' node
	 * @param v2
	 *                'to' node
	 */
	public Edge(Vertex v1, Vertex v2) {
		this.from = v1;
		this.to = v2;
		
	}

	/**
	 * 
	 * @return the starting Vertex
	 */
	public Vertex getFrom() {
		return from;
	}

	/**
	 * @return the destination Vertex
	 */
	public Vertex getTo() {
		return to;
	}

	/**
	 * 
	 * @return the bus name
	 */
	public String getBusName() {
		return busName;
	}

	/**
	 * 
	 * @return the time when this bus arrive the 'from' station
	 */
	public int getArriveTimeOfFromStation() {
		return arriveTimeOfFromStation;
	}
	/**
	 * @param fromStation
	 * 'set' from vertex
	 */
	public void setFrom(Vertex fromStation) {
		this.from = fromStation;
	}
	/**
	 *
	 * @param toStation
	 *  'TO' STATION
	 */
	public void setTo(Vertex toStation) {
		this.to = toStation;
	}
	/**
	 * 
	 * @param bn busname
	 */
	public void setBusName(String bn) {
		this.busName = bn;
	}
	/**
	 * @param arriveFrom
	 *  set the time when this bus arrive the 'from' station
	 */
	public void setArriveTimeOfFromStation(int arriveFrom) {
		this.arriveTimeOfFromStation = arriveFrom;
	}

	/**
	 * @return get the time when this bus arrive the 'to' station
	 */
	public int getArriveTimeOfToStation() {
		return arriveTimeOfToStation;
	}

	/**
	 * 
	 * @param arriveTo
	 *set the time when this bus arrive the 'to' station
	 */
	public void setArriveTimeOfToStation(int arriveTo) {
		this.arriveTimeOfToStation = arriveTo;
	}

}
