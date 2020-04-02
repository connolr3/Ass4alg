import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	public ArrayList<Double>[] adj;
	ArrayList<Integer>[] al = new ArrayList[n]; 
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
				// Initialize distTo[s][s] to 0 and distTo[s][v] to infinity for all other vertices v. 
				for (int rowIndex = 0;rowIndex<vertices;rowIndex++) {
					adj[rowIndex] = new ArrayList<Double>(); 
					for (int columnIndex=0;columnIndex<vertices;columnIndex++) {
						if(rowIndex==columnIndex) 
							distTo[rowIndex][columnIndex]=0;
						else
							distTo[rowIndex][columnIndex]=10000;
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
				edgeTo[v][w]=v;
				distTo[v][w]=weight;
				//ArrayList edge = new
				adj[v].add(v); 
			}
		}
				
		System.out.println("DISTANCE TO");
		printArray(distTo,vertices,vertices);
		System.out.println();
		System.out.println("EDGE TO");
		printArray(edgeTo,vertices,vertices);
		System.out.println();
		int source = 0;
		getSP(source);
	}

	public void getSP (int v ) {
		printRow(edgeTo,v);
		printRow(distTo,v);
		double minDist = distTo[v][0];
		for (int column=1;column<vertices;column++) {
			minDist = Math.min(distTo[v][column]);
		}
	}
	public void printRow(double[][]table,int row){
		for(int j = 0; j < table[1].length; j++)
			   System.out.print(table[row][j]+"   ");
		System.out.println();
	}
	public void printRow(int[][]table,int row){
		for(int j = 0; j < table[1].length; j++)
			   System.out.print(table[row][j]+"   ");
		System.out.println();
	}
	private void relaxEdge(int i) {

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
	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){
		//TO DO
		return -1;
	}
	public static void main (String[]args) throws FileNotFoundException {
		CompetitionDijkstra dd= new CompetitionDijkstra("tinyEWD.txt",3,4,5);
		PriorityQueue pq = new PriorityQueue();
		//printing("tinyEWD.txt");

	}
}