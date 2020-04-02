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
	public double[][] edgeWeights;
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
			System.out.println(line+i);
			if (i==0) {
				vertices = Integer.parseInt(line);
				edgeWeights = new double[vertices][vertices];	
				edgeTo = new int[vertices][vertices];
				distTo = new double[vertices][vertices];
			}
			else if (i==1)
				numberEdges =  Integer.parseInt(line);
			if(i>1)
			{
				String[] splited = line.split("\\s+");
				edgeWeights[Integer.parseInt(splited[0])][Integer.parseInt(splited[1])]=Double.parseDouble(splited[2]);
				System.out.println("4-0   "+edgeWeights[4][0]);
			}
		}
		printArray(distTo)
		// Initialize distTo[s][s] to 0 and distTo[s][v] to infinity for all other vertices v. 
		for (int rowIndex = 0;rowIndex<vertices;rowIndex++) {
			for (int columnIndex=0;columnIndex<vertices;columnIndex++) {
				if(rowIndex==columnIndex) {
					distTo[rowIndex][columnIndex]=0;
					edgeTo[rowIndex][columnIndex]=(Integer) null;//the last edge from itself is null
					edgeWeights[rowIndex][columnIndex]=0;//the distance from vertice f to vertex f is 0
				}
				distTo[rowIndex][columnIndex]=10000;
			}
		}
		int source = 0;
		
	}
	
	public void getSP (int v ) {
		for (int i = 0;i<distTo.length;i++) {
	//		distTo[i]=10000;
		}
	//	distTo[v]=0;
	}
	private void relaxEdge(int i) {
	
	}
	public void printArray(double[][]array,int rows,int columns) {
		for(int i = 0; i<rows; i++)
		{
		    for(int j = 0; j<columns; j++)
		    {
		        System.out.print(array[i][j]);
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
		//printing("tinyEWD.txt");

	}
}