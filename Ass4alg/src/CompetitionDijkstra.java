import java.io.File;
import java.io.FileNotFoundException;
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
 * This class implements the competition using Dijkstra's algorithm
 */
public class CompetitionDijkstra {
	public int sa;
	public int sb;
	public int sc;
	public int numberEdges;
	public int vertices;
	public int[][] edges;
	public int[] distTo;
	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 * @throws FileNotFoundException 
	 */
	CompetitionDijkstra (String filename, int sA, int sB, int sC) throws FileNotFoundException{
		this.sa=sa;
		this.sb=sb;
		this.sc=sc;
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		for(int i = 0;scan.hasNextLine();i++) {
			String line = scan.nextLine();
			System.out.println(line+i);
			if (i==0) {
				vertices = Integer.parseInt(line);
			}
			else if (i==1)
				numberEdges =  Integer.parseInt(line);
			if(i>1)
			{
				double[][] edges = new double[numberEdges][numberEdges];
				String[] splited = line.split("\\s+");
				edges[Integer.parseInt(splited[0])][Integer.parseInt(splited[1])]=Double.parseDouble(splited[2]);
			}
		}
		double[]  distTo = new double[vertices];
	}
public static void printing(String filename) throws FileNotFoundException {
	File comp = new File(filename);
	Scanner scan = new Scanner(comp);
	while (scan.hasNextLine()) {
		String line = scan.nextLine();
		System.out.println(line);
	}
}
	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){

		//TO DO
		return -1;
	}
	public static void main (String[]args) throws FileNotFoundException {
		File comp = new File("tinyEWD.txt");
		int vertices =0;
		int edges = 0;
		Scanner scan = new Scanner(comp);
		for(int i = 0;i<2;i++) {
			String line = scan.nextLine();	
			if (i==0) {
				vertices = Integer.parseInt(line);	
			}
			if (i==1) {
				edges =  Integer.parseInt(line);	
			}
		}
		CompetitionDijkstra dd= new CompetitionDijkstra("tinyEWD.txt",3,4,5);
	//printing("tinyEWD.txt");

	}
}