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
	    	CompetitionDijkstra map;
	    	String filename = "tinyEWD.txt";
	    	map = new CompetitionDijkstra(filename, 55,60,92);
	    	assertEquals(34, map.timeRequiredforCompetition());
	}
	@Test
	public void testCompetitionFloydWarshall() throws FileNotFoundException {
	    	String filename = "tinyEWD.txt";
	    	CompetitionFloydWarshall map = new CompetitionFloydWarshall(filename, 55,60,92);
	    	assertEquals(34, map.timeRequiredforCompetition());
	}

	@Test
	public void testTimeRequiredforCompetition() throws FileNotFoundException {
    	String filename = "tinyEWD.txt";
    	CompetitionDijkstra map = new CompetitionDijkstra(filename, 55,60,92);
    	CompetitionDijkstra map1 = new CompetitionDijkstra(filename, -55,60,92);
    	assertEquals(34, map.timeRequiredforCompetition());
    	assertEquals(-1, map1.timeRequiredforCompetition());
    	CompetitionFloydWarshall map2 = new CompetitionFloydWarshall(filename, 55,60,92);
    	CompetitionFloydWarshall map3 = new CompetitionFloydWarshall(filename, -55,60,92);
    	assertEquals(34, map2.timeRequiredforCompetition());
    	assertEquals(-1, map3.timeRequiredforCompetition());
	}

	

}
