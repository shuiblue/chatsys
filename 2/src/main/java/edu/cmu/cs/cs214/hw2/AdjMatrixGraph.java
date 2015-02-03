package edu.cmu.cs.cs214.hw2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * use Adjacent Matrix implement Graph
 * 
 * @author shuru
 *
 */
public class AdjMatrixGraph implements InterfaceGraph {
	
	private final int maxSize = 1000;
	private int[][] adjMatrixGraph = new int[maxSize][maxSize];
	private Vertex[] stop = new Vertex[maxSize];
	private HashMap<Integer,ArrayList<Edge>> edges = new HashMap<Integer, ArrayList<Edge>>();
	
	@Override
	public void addVertex(Vertex v1) {
	  stop[stop.length] = v1;
	}

	@Override
	public void addEdge(Vertex v1, Vertex v2,Edge edge) {
		int indexOfV1 = 0;
		int indexOfV2 = 0;
		int indexOfEdges = 0;
		for(int i = 0; i<=stop.length; i++){
			if(stop[i].equals(v1)){
				indexOfV1 = i;
			}else if(stop[i].equals(v2)){
				indexOfV2 = i;
			}
		}
		indexOfEdges = adjMatrixGraph[indexOfV1][indexOfV2];
		edges.get(indexOfEdges).add(edge);
	}

	@Override
	public Vertex getVertex(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge getEdge(String start, String end, int time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getVertexList() {
		// TODO Auto-generated method stub
		return null;
	}

}
