package edu.cmu.cs.cs214.hw2;

/**
 * 
 * @author shuruiz
 *
 */
public interface RoutePlannerBuilder {
	/**
	 * 
	 * @param transitFile 
	 * 			path of transit file
	 * @param maxWait
	 * 		maximum waiting time
	 * @return route plan
	 */
	RoutePlanner build(String transitFile, int maxWait);

}
