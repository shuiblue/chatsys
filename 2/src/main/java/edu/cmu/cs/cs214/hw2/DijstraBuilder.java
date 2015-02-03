package edu.cmu.cs.cs214.hw2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author shuruiz
 *
 */
public class DijstraBuilder implements RoutePlannerBuilder {

	private final int stopLineSize = 4;
	private final int busLineSize = 2;
	private final int arriveTimeIndex = 3;
	private String stationName;
	private double longitude, latitude;
	private int arriveTime,fromArrivetime;

	@Override
	public RoutePlanner build(String transitFile, int maxWait) {

		// --------- read transit file to build graph
		AdjListGraph adjListGraph = new AdjListGraph();
		String busName = null;

		FileInputStream in = null;
		try {
			in = new FileInputStream(transitFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(in);
		scanner.useDelimiter(",");
		String currentLine = null;
		String preLine = null;

		Vertex preVertex=null, currentVertex = null;
		while (scanner.hasNext()) {
			currentLine = scanner.nextLine();
			System.out.println("current:" + currentLine);
			String[] splitCurrentLine = currentLine.split(",");

			// get bus name
			if (splitCurrentLine.length == busLineSize) {
				busName = splitCurrentLine[0];
				preVertex = null;

			}
			if (splitCurrentLine.length == stopLineSize) {
				stationName = splitCurrentLine[0];
				latitude = Double
						.parseDouble(splitCurrentLine[1]);
				longitude = Double
						.parseDouble(splitCurrentLine[2]);
				arriveTime = Integer
						.parseInt(splitCurrentLine[arriveTimeIndex]);
				currentVertex = new Vertex(stationName,
						latitude, longitude);
				adjListGraph.addVertex(currentVertex);
				
				
				if(preVertex!=null){
					Edge edge = new Edge(preVertex, currentVertex);
					edge.setArriveTimeOfFromStation(fromArrivetime);
					currentVertex.setStationName(stationName);
					edge.setBusName(busName);
					edge.setTo(currentVertex);
					edge.setArriveTimeOfToStation(arriveTime);
					adjListGraph.addVertex(preVertex);
					
					adjListGraph.addEdge(preVertex, currentVertex, edge);
				}
				if (scanner.hasNext()) {
					preVertex = currentVertex;
					fromArrivetime = arriveTime;
				}else {
					preVertex = null;
				}
				

			}
		}

		DijstraPlanner dijstraPlanner = new DijstraPlanner(maxWait,
				adjListGraph);
		// --------- RoutePlanner
		return dijstraPlanner;

	}

}
