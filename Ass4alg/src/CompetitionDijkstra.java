import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
//import java.util.ArrayList;
import java.util.Scanner;
//Are we allowed use priority queues
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
	public ArrayList<DirectedEdge>[] adj;
	//public Array[] distTo;
	//public ArrayList<Integer>[] edgeTo;
	public double[][] distTo;
	public int[][]  edgeTo;
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
			if (i==0) {
				vertices = Integer.parseInt(line);	
				edgeTo = new int[vertices][vertices];
				distTo = new double[vertices][vertices];
				adj = new ArrayList[vertices];
				//edgeTo = new ArrayList[vertices];
				//distTo = new ArrayList[vertices];
				// Initialize distTo[s][s] to 0 and distTo[s][v] to infinity for all other vertices v. 
				for (int rowIndex = 0;rowIndex<vertices;rowIndex++) {
					adj[rowIndex] = new ArrayList<DirectedEdge>(); 
					for (int columnIndex=0;columnIndex<vertices;columnIndex++) {
						//if edgeTo[v][w]=vertices, it hasn't been visisted
						if(rowIndex==columnIndex) {
							distTo[rowIndex][columnIndex]=0;
							edgeTo[rowIndex][columnIndex]=rowIndex;}
						else {
							distTo[rowIndex][columnIndex]=10000;
							edgeTo[rowIndex][columnIndex]=vertices;
						}
					}
				}
			}
			else if (i==1)
				numberEdges =  Integer.parseInt(line);
			if(i>1)
			{
				String[] splited = line.split("\\s+");
				int v = Integer.parseInt(splited[0]);
				int w = Integer.parseInt(splited[1]);
				double weight = Double.parseDouble(splited[2]);
				//edgeTo[v][w]=v;
				//distTo[v][w]=weight;
				DirectedEdge edge = new DirectedEdge(v,w,weight);
				adj[v].add(edge); 
			}
		}
		System.out.println("DISTANCE TO");
		printArray(distTo,vertices,vertices);
		System.out.println();
		System.out.println("EDGE TO");
		printArray(edgeTo,vertices,vertices);
		System.out.println();

		for (int source=0;source<vertices;source++) {
			getSP(source);
		}

		System.out.println("DISTANCE TO");
		printArray(distTo,vertices,vertices);
		System.out.println();
		System.out.println("EDGE TO");
		printArray(edgeTo,vertices,vertices);
		System.out.println();
	}

	public void getSP (int s) 
	{
		relaxAllEdgesfromVertex(s,s);
	}
	private void relaxAllEdgesfromVertex(int source, int vertex) {
		for (DirectedEdge edge : adj[vertex]) {
			int from = edge.from();
			int to = edge.to();
			if (distTo[source][to]>(distTo[source][from]+edge.weight())) {
				edgeTo[source][to]=from;
				distTo[source][to]=edge.weight()+distTo[source][from];
				relaxAllEdgesfromVertex(source,to);
			}	
		}
	}
	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */

	public int timeRequiredforCompetition(){
		//Handle Errors  - the 3 speeds must be between 50 and 100 (inclusive)
		if (sa<50||sa>100||sb<50||sb>100||sc<50||sc>100) {
			return -1;
		}
		//TO DO
		return -1;
	}

	public static void main (String[]args) throws FileNotFoundException {
		CompetitionDijkstra dd= new CompetitionDijkstra("tinyEWD.txt",3,4,5);

	}









	public void printArray(double[][]array,int rows,int columns) {
		for(int i = 0; i<rows; i++)
		{
			for(int j = 0; j<columns; j++)
			{
				System.out.print(array[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public void printArray(int[][]array,int rows,int columns) {
		for(int i = 0; i<rows; i++)
		{
			for(int j = 0; j<columns; j++)
			{
				System.out.print(array[i][j]+"  ");
			}
			System.out.println();
		}
	}
}