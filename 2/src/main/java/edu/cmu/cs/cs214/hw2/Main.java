package edu.cmu.cs.cs214.hw2;


/**
 * 
 * @author shuruiz
 *
 */
public class Main {

	 static final int MAX_WAIT = 1200;
	/**
	 * 
	 * @param args
	 * 		main
	 *
	 */
	public static void main(String[] args){
		
		String transitFile = "src/main/resources/61Ctest.txt";

		DijstraBuilder dijstraBuilder = new DijstraBuilder();
		dijstraBuilder.build(transitFile, MAX_WAIT);

	}
}
