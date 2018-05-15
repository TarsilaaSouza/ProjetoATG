package atg;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mxgraph.analysis.mxGraphProperties.GraphType;

public class GraphControlTest {

	private static Graph grafo1;
	private static Graph grafo2;
	private static Graph grafo3;
	private static Graph grafo4;

	// teste1.txt == exemplo 1 do PDF
	// teste2.txt == exemplo 2 do PDF
	// teste3.txt == teste proprio - sem peso
	// teste4.txt == teste proprio - com peso

	@Test
	public void testReadGraph() {
		try {
			Graph grafo = null;

			grafo = GraphControl.readGraph("teste1.txt");
			assertNotNull(grafo);

			grafo = GraphControl.readGraph("teste3.txt");
			assertNotNull(grafo);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testReadWeightedGraph() {
		try {
			Graph grafo = null;

			grafo = GraphControl.readWeightedGraph("teste2.txt");
			assertNotNull(grafo);

			 grafo = GraphControl.readWeightedGraph("teste4.txt");
			 assertNotNull(grafo);

		} catch (Exception e) {
			fail();
		}
	}

	@BeforeClass
	public static void setUp() {
		try {
			grafo1 = GraphControl.readGraph("teste1.txt");
			grafo2 = GraphControl.readWeightedGraph("teste2.txt");
			grafo3 = GraphControl.readGraph("teste3.txt");
			grafo4 = GraphControl.readWeightedGraph("teste4.txt");
		} catch (Exception e) {
			e.printStackTrace();
//			fail();
		}
	}

	@Test
	public void testGetVertexNumber() {
		assertEquals(5, GraphControl.getVertexNumber(grafo1));
		assertEquals(5, GraphControl.getVertexNumber(grafo2));
		assertEquals(6, GraphControl.getVertexNumber(grafo3));
		assertEquals(6, GraphControl.getVertexNumber(grafo4));
	}

	@Test
	public void testGetEdgeNumber() {
		assertEquals(5, GraphControl.getEdgeNumber(grafo1));
		assertEquals(6, GraphControl.getEdgeNumber(grafo2));
		assertEquals(6, GraphControl.getEdgeNumber(grafo3));
		assertEquals(5, GraphControl.getEdgeNumber(grafo4));
	}

	@Test
	public void testGetMeanEdge() {
		assertEquals(2, GraphControl.getMeanEdge(grafo1), 0f);
		assertEquals(2.4, GraphControl.getMeanEdge(grafo2), 0.001f);
		assertEquals(2, GraphControl.getMeanEdge(grafo3), 0f);
		assertEquals(1.666, GraphControl.getMeanEdge(grafo4), 0.001f);
	}

	@Test
	public void testGraphRepresentation() {
		assertEquals("", GraphControl.graphRepresentation(grafo1, Graph.Tipo.AL));
	}

	@Test
	public void testBFS() {
		fail("Not yet implemented");
	}

	@Test
	public void testDFS() {
		fail("Not yet implemented");
	}

	@Test
	public void testConnected() {
		assertTrue(GraphControl.connected(grafo1));
		assertTrue(GraphControl.connected(grafo2));
		assertFalse(GraphControl.connected(grafo3));
		assertFalse(GraphControl.connected(grafo4));
	}

	@Test
	public void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testMst() {
		fail("Not yet implemented");
	}
}