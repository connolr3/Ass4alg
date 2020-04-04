import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompetitionDijkstraTest {


	@Test
	public void testCompetitionDijkstraConstructor() throws FileNotFoundException {
		CompetitionDijkstra map1;
		String filename = "tinyEWD.txt";
		map1 = new CompetitionDijkstra(filename, 55,60,92);
		CompetitionDijkstra map2 = new CompetitionDijkstra("INVALID", 55,60,92);
		assertEquals(34, map1.timeRequiredforCompetition());
	}
	@Test
	public void testCompetitionFloydWarshallConstructor()  {
		String filename = "tinyEWD.txt";
		CompetitionFloydWarshall map1 = new CompetitionFloydWarshall(filename, 55,60,92);
		CompetitionFloydWarshall map2 = new CompetitionFloydWarshall("INVALID", 55,60,92);
		assertEquals(34, map1.timeRequiredforCompetition());
	}

	@Test
	public void testTimeRequiredInvalidSpeeds()  {
		String filename = "tinyEWD.txt";
		CompetitionDijkstra map1 = new CompetitionDijkstra(filename, 105,60,92);
		CompetitionDijkstra map2 = new CompetitionDijkstra(filename, -55,60,92);
		CompetitionDijkstra map3 = new CompetitionDijkstra(filename, 55,-60,92);
		CompetitionDijkstra map4 = new CompetitionDijkstra(filename, 55,160,92);
		CompetitionDijkstra map5 = new CompetitionDijkstra(filename, 55,-60,234);
		CompetitionDijkstra map6 = new CompetitionDijkstra(filename, 55,160,-1000);
		CompetitionFloydWarshall map7 = new CompetitionFloydWarshall(filename, 655,60,92);
		CompetitionFloydWarshall map8 = new CompetitionFloydWarshall(filename, -55,60,92);
		CompetitionFloydWarshall map9 = new CompetitionFloydWarshall(filename, 60,-60,92);
		CompetitionFloydWarshall map10 = new CompetitionFloydWarshall(filename, 60,6640,92);
		CompetitionFloydWarshall map11 = new CompetitionFloydWarshall(filename, 655,60,920);
		CompetitionFloydWarshall map12 = new CompetitionFloydWarshall(filename, -55,60,-92);
		assertEquals(-1, map1.timeRequiredforCompetition());
		assertEquals(-1, map2.timeRequiredforCompetition());
		assertEquals(-1, map3.timeRequiredforCompetition());
		assertEquals(-1, map4.timeRequiredforCompetition());
		assertEquals(-1, map5.timeRequiredforCompetition());
		assertEquals(-1, map6.timeRequiredforCompetition());
		assertEquals(-1, map7.timeRequiredforCompetition());
		assertEquals(-1, map8.timeRequiredforCompetition());
		assertEquals(-1, map9.timeRequiredforCompetition());
		assertEquals(-1, map10.timeRequiredforCompetition());
		assertEquals(-1, map11.timeRequiredforCompetition());
		assertEquals(-1, map12.timeRequiredforCompetition());
	}
	//WEB CAT WANTS THIS SHOWN TO BE -1 WITH MULTIPLE INPUTS
	@Test
	public void testInputA() {
		//where there is 2 vertices but only 1 edge
		CompetitionDijkstra  map1 = new CompetitionDijkstra("input-A.txt", 55,60,92);
		CompetitionFloydWarshall map2= new CompetitionFloydWarshall("input-A.txt", 60,60,92);
		assertEquals(-1, map1.timeRequiredforCompetition());
		assertEquals(-1, map2.timeRequiredforCompetition()); 	
	}
	@Test
	public void testInputB() {
		String filename = "input-B.txt";
		CompetitionDijkstra  map1 = new CompetitionDijkstra (filename, 55,60,92);
		CompetitionFloydWarshall map2 = new CompetitionFloydWarshall(filename, 55,60,92);
		assertEquals(9091, map1.timeRequiredforCompetition());
		assertEquals(9091, map2.timeRequiredforCompetition());
	}
	@Test
	public void testInputC() {
		//all weights are equal
		String filename = "input-C.txt";
		CompetitionDijkstra  map1 = new CompetitionDijkstra (filename, 55,60,92);
		CompetitionFloydWarshall map2 = new CompetitionFloydWarshall(filename, 55,60,92);
		assertEquals(-1, map1.timeRequiredforCompetition());
		assertEquals(-1, map2.timeRequiredforCompetition());
	}
	@Test
	public void testInputD() {
		String filename = "input-D.txt";
		CompetitionDijkstra  map1 = new CompetitionDijkstra (filename, 55,60,92);
		CompetitionFloydWarshall map2 = new CompetitionFloydWarshall(filename, 55,60,92);
		CompetitionDijkstra  map3 = new CompetitionDijkstra (filename, 50,80,60);
		CompetitionFloydWarshall map4 = new CompetitionFloydWarshall(filename, 50,80,60);
		assertEquals(34, map1.timeRequiredforCompetition());
		assertEquals(34, map2.timeRequiredforCompetition());
		assertEquals(38, map3.timeRequiredforCompetition());
		assertEquals(38, map4.timeRequiredforCompetition());
	}
	//E
	@Test
	public void testInputF() {
		//When Edges Equal Vertices
		String filename = "input-F.txt";
		CompetitionDijkstra  map1 = new CompetitionDijkstra (filename, 55,60,92);
		CompetitionFloydWarshall map2 = new CompetitionFloydWarshall(filename, 55,60,92);
		assertEquals(-1, map1.timeRequiredforCompetition());
		assertEquals(-1, map2.timeRequiredforCompetition());
	}
	@Test
	public void testInputJ() {
		//When no. edges = no.vertices = 0
		String filename = "input-J.txt";
		CompetitionDijkstra  map1 = new CompetitionDijkstra (filename, 55,60,92);
		CompetitionFloydWarshall map2 = new CompetitionFloydWarshall(filename, 55,60,92);
		assertEquals(-1, map1.timeRequiredforCompetition());
		assertEquals(-1, map2.timeRequiredforCompetition());
	}
	@Test
	public void testInputG() {
		String filename = "input-G.txt";
		CompetitionDijkstra  map1 = new CompetitionDijkstra (filename, 55,60,92);
		CompetitionFloydWarshall map2 = new CompetitionFloydWarshall(filename, 55,60,92);
		assertEquals(-1, map1.timeRequiredforCompetition());
		assertEquals(-1, map2.timeRequiredforCompetition());
	}
	/*
e
g
h
i
k
l
m
n
o
p
	 */


}
