import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    - Each contestant walks at a given estimated speed.
 *    - The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */
//
public class CompetitionFloydWarshall {
	public int sA;
	public int sB;
	public int sC;
	public int numberEdges;
	public int vertices;
	public double[][]  SP;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 * @throws FileNotFoundException 
	 */

	CompetitionFloydWarshall (String filename, int sA, int sB, int sC) {
		try {		
			this.sA=sA;
			this.sB=sB;
			this.sC=sC;
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			for(int i = 0;scan.hasNextLine();i++) {
				String line = scan.nextLine();
				if (i==0) {
					vertices = Integer.parseInt(line);	
					SP = new double[vertices][vertices];
					for (int rowIndex = 0;rowIndex<vertices;rowIndex++) {
						for (int columnIndex=0;columnIndex<vertices;columnIndex++) {
							if(rowIndex==columnIndex) 
								SP[rowIndex][columnIndex]=0;
							else {
								SP[rowIndex][columnIndex]=Integer.MAX_VALUE;
							}
						}
					}
				}
				else if (i==1)
					numberEdges =  Integer.parseInt(line);
				if(i>1)
				{
					int firstNonZero = 0;
					while(line.charAt(firstNonZero)==' ') {
						firstNonZero++;	
					}
					line = line.substring(firstNonZero);
					String[] splitted = line.split("\\s+");
					int v = Integer.parseInt(splitted[0]);
					int w = Integer.parseInt(splitted[1]);
					double weight = Double.parseDouble(splitted[2]);
					SP[v][w]=weight;
				}
			}
			for(int i = 0; i <SP.length; i++)
			{
				for(int j = 0; j < SP.length; j++)
				{
					for(int k = 0; k < SP.length; k++)
					{
						if(SP[j][i] + SP[i][k] < SP[j][k])
						{
							SP[j][k] = SP[j][i] + SP[i][k];
						}
					}
				}
			}
			//printArray(SP,vertices,vertices);
		}
		catch(Exception x)
		{
			SP = new double[0][0];
			return;
		}
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){
		//Handle Errors  - the 3 speeds must be between 50 and 100 (inclusive)
		if (sA<50||sA>100||sB<50||sB>100||sC<50||sC>100) 
			return -1;
		if(numberEdges==0||vertices==0) 
			return -1;
		//The worst case scenario is the slowest walker ends up having to walk the longest "shortest" path
		double maxDist=0;
		for (int rowIndex = 0;rowIndex<vertices;rowIndex++) {
			for (int columnIndex=0;columnIndex<vertices;columnIndex++) {
				if (SP[rowIndex][columnIndex]==Integer.MAX_VALUE) {
					return -1; //No path exists here
				}
				if (SP[rowIndex][columnIndex]>maxDist) {
					maxDist = SP[rowIndex][columnIndex];
				}
			}
		}
		maxDist=maxDist*1000;//convert from km to m
		double slowestSpeed = Math.min(sA, Math.min(sB, sC));
		return (int) Math.ceil(maxDist/slowestSpeed);
	}
	public static void printSP() {
		System.out.println(Integer.MAX_VALUE);
	}
	public static void main (String[]args) throws FileNotFoundException {
		CompetitionFloydWarshall dd= new CompetitionFloydWarshall("input-C.txt",55,60,92);
		System.out.println(dd.timeRequiredforCompetition());
	}
}