package edu.cmu.cs.cs214.hw2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author shuruiz
 *
 */
public class DijstraPlanner implements RoutePlanner {

	private int maxWait;
	private AdjListGraph adjListGraph;

	/**
	 * 
	 * @param mw
	 *                max waiting time
	 * @param adjGraph
	 *                adjListGraph
	 */
	DijstraPlanner(int mw, AdjListGraph adjGraph) {
		this.maxWait = mw;
		this.adjListGraph = adjGraph;
	}

	@Override
	public ArrayList<Stop> findStopBySubstring(String search) {
		ArrayList<Stop> stopList = new ArrayList<Stop>();
		for (String key : adjListGraph.getVertexList()) {
			if (key.contains(search)) {
				stopList.add(adjListGraph.getVertex(key));
			}
		}

		return stopList;
	}

	@Override
	public Itinerary computeRoute(Stop src, Stop dest, int time) {
		LinkedList<Stop> queue = new LinkedList<Stop>();
		//
		HashMap<Stop, Integer> leastTimeToStopMap = new HashMap<Stop, Integer>();

		Itinerary itinerary = new Itinerary();
		itinerary.setStartLoation(src);

		itinerary.setEndLocation(dest);
		itinerary.setStartTime(time);
		String busNameString = "";
		String instructionString = "";

		int leastTime;
		HashMap<Vertex, ArrayList<Edge>> preAvailableEdgesMap = new HashMap<Vertex, ArrayList<Edge>>();

		queue.add(src); // Start breath-first search
		leastTimeToStopMap.put(src, time);

		while (!queue.isEmpty()) {
			Stop stop = queue.remove();
			ArrayList<Edge> edges = stop.getEdges();
			ArrayList<Edge> candidateEdges = new ArrayList<Edge>();// available
			// edges

			for (int i = 0; i < edges.size(); i++) {
				Stop neighbourStop = edges.get(i).getTo();
				if (!leastTimeToStopMap
						.containsKey(neighbourStop)) {
					for (int j = 0; j < stop.getEdges()
							.size(); j++) {
						int waitTime = stop
								.getEdges()
								.get(j)
								.getArriveTimeOfFromStation()
								- time;
						if (waitTime <= maxWait) {
							candidateEdges.add(stop
									.getEdges()
									.get(j));
						}
					}
				}
			}
			for (int t = 0; t < candidateEdges.size(); t++) {

				ArrayList<Edge> preVertexArrayList = new ArrayList<Edge>();

				// if the neighbor stop haven't been searched
				if (!leastTimeToStopMap
						.containsKey(candidateEdges
								.get(t).getTo())) {
					leastTimeToStopMap
							.put(candidateEdges
									.get(t)
									.getTo(),
									candidateEdges.get(
											t)
											.getArriveTimeOfToStation());
					// add pre available vertex

					preVertexArrayList.add(candidateEdges
							.get(t));
					preAvailableEdgesMap
							.put((Vertex) candidateEdges
									.get(t)
									.getTo(),
									preVertexArrayList);

					queue.add(candidateEdges.get(t).getTo());

				} else {
					if (leastTimeToStopMap
							.get(candidateEdges
									.get(t)
									.getTo()) > candidateEdges
							.get(t)
							.getArriveTimeOfToStation()) {
						leastTimeToStopMap
								.put(candidateEdges
										.get(t)
										.getTo(),
										candidateEdges.get(
												t)
												.getArriveTimeOfToStation());

						// queue.add(candidateEdges.get(t)
						// .getTo());
						// add pre available vertex
						preVertexArrayList
								.add(candidateEdges
										.get(t));
						preAvailableEdgesMap
								.put((Vertex) candidateEdges
										.get(t)
										.getTo(),
										preVertexArrayList);
						queue.add(candidateEdges.get(t)
								.getTo());
					}

				}
				busNameString = candidateEdges.get(t)
						.getBusName();

			}
		}

		ArrayList<TripSegment> segments = new ArrayList<TripSegment>();
		ArrayList<Edge> availableEdges = new ArrayList<Edge>();
		Stack<Stop> searchedStops = new Stack<Stop>();

		// get itinerary

		searchedStops.add(dest);
		
		while (!searchedStops.empty()) {
			Stop tmpDest = searchedStops.pop();
			if (leastTimeToStopMap.containsKey(tmpDest)) {
				// whole trip last time
				leastTime = leastTimeToStopMap.get(tmpDest)
						- time;
				

				availableEdges = preAvailableEdgesMap
						.get(tmpDest);
				int waitTime = 0;
				if (availableEdges!=null) {

					// parse all the available vertex
					for (int i = 0; i < availableEdges
							.size(); i++) {
						Vertex currentVertex = availableEdges
								.get(i)
								.getFrom();
						searchedStops.push(currentVertex);

						if (waitTime > 0) {
							// edit a waitSegment
							TripSegment waitSegment = new WaitSegment(
									waitTime,
									currentVertex);
							waitSegment.getItinerary()
									.setInstruction("wait at "
											+ currentVertex.getStationName()
											+ " for "
											+ waitTime
											+ " seconds ");
						}
						// edit a busSegment
						busNameString = availableEdges
								.get(i)
								.getBusName();
						int lastTime = leastTimeToStopMap
								.get(tmpDest)
								- leastTimeToStopMap
										.get(currentVertex);
						TripSegment busSegment = new BusSegment(
								lastTime,
								currentVertex,
								tmpDest,
								busNameString);

						busSegment.getItinerary()
								.setEndLocation(tmpDest);
						busSegment.getItinerary()
								.setEndTime(leastTimeToStopMap
										.get(tmpDest));
						busSegment.getItinerary()
								.setName(tmpDest.getStationName());
						busSegment.getItinerary()
								.setStartLoation(
										currentVertex);
						busSegment.getItinerary()
								.setStartTime(leastTimeToStopMap
										.get(currentVertex));

						busSegment.getItinerary()
								.setInstruction("take "
										+ busNameString
										+ " from "
										+ currentVertex.getStationName()
										+ " to "
										+ tmpDest.getStationName()
										+ " last "
										+ lastTime);
						segments.add(busSegment);

						if (preAvailableEdgesMap.get(
								currentVertex)
								!=null) {

							tmpDest = currentVertex;
							waitTime = availableEdges
									.get(i)
									.getArriveTimeOfFromStation()
									- leastTimeToStopMap
											.get(tmpDest);

						}

					}
				}
				instructionString = "from "
						+ src.getStationName() + " to "
						+ dest.getStationName()
						+ " need " + leastTime
						+ " seconds";

				itinerary.setInstruction(instructionString);
				itinerary.setSegments(segments);
			} else {
				System.out.println("cannot get destination");
			}
		}
		return itinerary;
	}
}
