package edu.cmu.cs.cs214.hw2;

import java.util.Set;

/**
 * 
 * @author shuruiz
 *
 */

interface InterfaceGraph {
	/**
	 * Add a vertex to the graph
	 * 
	 * @param v1
	 *                is a Vertex
	 */
	void addVertex(Vertex v1);

	/**
	 * @param v1
	 *                vertex 1
	 * @param v2
	 *                vertex 2
	 * @param edge
	 *                from v1-->v2
	 */
	void addEdge(Vertex v1, Vertex v2, Edge edge);

	/**
	 * 
	 * @param str
	 *                station name
	 * @return vertex vertex named str
	 */
	Vertex getVertex(String str);

	/**
	 * 
	 * @param start
	 *                start station
	 * @param end
	 *                end station
	 * @param time
	 *                start time
	 * @return edge find an edge
	 */
	Edge getEdge(String start, String end, int time);

	/**
	 * 
	 * @return vertex List
	 */
	Set<String> getVertexList();
}
