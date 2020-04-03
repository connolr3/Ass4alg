import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
//import java.util.ArrayList;
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
	CompetitionDijkstra (String filename, int sa, int sb, int sc) throws FileNotFoundException{
		this.sa=sa;
		this.sb=sb;
		this.sc=sc;
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		for(int i = 0;scan.hasNextLine();i++) {
			System.out.println(i);
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
							edgeTo[rowIndex][columnIndex]=-1;
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
				//edgeTo[v][w]=v;
				//distTo[v][w]=weight;
				DirectedEdge edge = new DirectedEdge(v,w,weight);
				adj[v].add(edge); 
			}
		}
		
		for (int source=0;source<vertices;source++) 
			relaxAllEdgesfromVertex(source, source);
	}
public void printArrays() {
	System.out.println("DISTANCE TO");
	printArray(distTo,vertices,vertices);
	System.out.println();
	System.out.println("EDGE TO");
	printArray(edgeTo,vertices,vertices);
	System.out.println();
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
		//The worst case scenario is the slowest walker ends up having to walk the longest "shortest" path
		double maxDist=0;
		for (int rowIndex = 0;rowIndex<vertices;rowIndex++) {
			for (int columnIndex=0;columnIndex<vertices;columnIndex++) {
				// If  its not possible to run the competition 
				//(i.e., if there are 2 random locations in a city between which no path exists), 
				//the method should return -1
				if (edgeTo[rowIndex][columnIndex]==-1) {
					return -1;
				}
				if (distTo[rowIndex][columnIndex]>maxDist) {
					maxDist = distTo[rowIndex][columnIndex];
				}
			}
		}
		maxDist=maxDist*1000;//convert from km to m
		double slowestSpeed = Math.min(sa, Math.min(sb, sc));
		return (int) Math.ceil(maxDist/slowestSpeed);
	}

	public static void main (String[]args) throws FileNotFoundException {
		CompetitionDijkstra dd= new CompetitionDijkstra("1000EWD.txt",55,60,92);
		int g = dd.timeRequiredforCompetition();
		System.out.println(g);

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