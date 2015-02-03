package edu.cmu.cs.cs214.hw2;


import java.util.HashMap;
import java.util.Set;

/**
 * use Adjacent List implement Graph
 * 
 * @author shuruiz
 *
 */
public class AdjListGraph implements InterfaceGraph {

	private HashMap<String, Vertex> adjListgraph = new HashMap<String, Vertex>();

	@Override
	public void addVertex(Vertex v1) {

		if (adjListgraph.containsKey(v1)) {
			return;
		} else {
			adjListgraph.put(v1.getStationName(), v1);
		}

	}

	@Override
	public void addEdge(Vertex v1, Vertex v2, Edge edge) {
		
		v1.getEdges().add(edge);
		

	}

	@Override
	public Vertex getVertex(String str) {
		// TODO Auto-generated method stub
		return adjListgraph.get(str);
	}

	@Override
	public Edge getEdge(String start, String end, int time) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<String> getVertexList(){
		return adjListgraph.keySet();
	}

}
