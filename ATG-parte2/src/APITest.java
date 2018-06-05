

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import api.API;
import graph.Graph;

public class APITest {

	
	Graph grafo1;
	Graph grafo2;
	Graph grafo3;
	//Graph grafo4;
	Graph grafo5;
	Graph grafo6;
	API api;

	@Before
	public void TestAPI() {
		api = new API();
		grafo1 = api.readGraph("teste1.txt");
		grafo2 = api.readWeightedGraph("teste2.txt");
		grafo3 = api.readGraph("teste3.txt");
		//grafo4 = api.readWeightedGraph("teste4.txt");
		grafo5 = api.readGraph("teste5.txt");
		grafo6 = api.readGraph("teste6.txt");
	}

	@Test
	public void testGetVertexNumber() {

		Assert.assertEquals(5, api.getVertexNumber(grafo1));
		Assert.assertNotEquals(1, api.getVertexNumber(grafo1));
		Assert.assertNotEquals(null, api.getVertexNumber(grafo1));
		Assert.assertNotEquals(-1, api.getVertexNumber(grafo1));
		
		Assert.assertEquals(5, api.getVertexNumber(grafo2));
		Assert.assertNotEquals(1, api.getVertexNumber(grafo2));
		Assert.assertNotEquals(null, api.getVertexNumber(grafo2));
		Assert.assertNotEquals(-1, api.getVertexNumber(grafo2));
		
		Assert.assertEquals(6, api.getVertexNumber(grafo3));
		Assert.assertNotEquals(1, api.getVertexNumber(grafo3));
		Assert.assertNotEquals(null, api.getVertexNumber(grafo3));
		Assert.assertNotEquals(-1, api.getVertexNumber(grafo3));
		
		Assert.assertEquals(20, api.getVertexNumber(grafo5));
		Assert.assertNotEquals(1, api.getVertexNumber(grafo5));
		Assert.assertNotEquals(null, api.getVertexNumber(grafo5));
		Assert.assertNotEquals(-1, api.getEdgeNumber(grafo5));
		
		Assert.assertEquals(20, api.getVertexNumber(grafo6));
		Assert.assertNotEquals(1, api.getVertexNumber(grafo6));
		Assert.assertNotEquals(null, api.getVertexNumber(grafo6));
		Assert.assertNotEquals(-1, api.getVertexNumber(grafo6));
	}

	@Test
	public void testGetEdgeNumber() {

		Assert.assertEquals(5, api.getEdgeNumber(grafo1));
		Assert.assertNotEquals(4, api.getEdgeNumber(grafo1));
		Assert.assertNotEquals(null, api.getEdgeNumber(grafo1));
		Assert.assertNotEquals(-1, api.getEdgeNumber(grafo1));
		
		Assert.assertEquals(6, api.getEdgeNumber(grafo2));
		Assert.assertNotEquals(4, api.getEdgeNumber(grafo2));
		Assert.assertNotEquals(null, api.getEdgeNumber(grafo2));
		Assert.assertNotEquals(-1, api.getEdgeNumber(grafo2));

		
		Assert.assertEquals(6, api.getEdgeNumber(grafo3));
		Assert.assertNotEquals(4, api.getEdgeNumber(grafo3));
		Assert.assertNotEquals(null, api.getEdgeNumber(grafo3));
		Assert.assertNotEquals(-1, api.getEdgeNumber(grafo3));	
		
		Assert.assertEquals(21, api.getEdgeNumber(grafo5));
		Assert.assertNotEquals(4, api.getEdgeNumber(grafo5));
		Assert.assertNotEquals(null, api.getEdgeNumber(grafo5));
		Assert.assertNotEquals(-1, api.getEdgeNumber(grafo5));
		
		Assert.assertEquals(20, api.getEdgeNumber(grafo6));
		Assert.assertNotEquals(4, api.getEdgeNumber(grafo6));
		Assert.assertNotEquals(null, api.getEdgeNumber(grafo6));
		Assert.assertNotEquals(-1, api.getEdgeNumber(grafo6));

	}

	@Test
	public void testGetMeanEdge() { // TODO parcialmente verificado

		Assert.assertEquals(2, api.getMeanEdge(grafo1), 0);
		Assert.assertNotEquals(0, api.getMeanEdge(grafo1), 0);
		Assert.assertNotEquals(5, api.getMeanEdge(grafo1), 0);
		
		Assert.assertEquals(12/5, api.getMeanEdge(grafo2), 0);
		Assert.assertNotEquals(0, api.getMeanEdge(grafo2), 0);
		Assert.assertNotEquals(5, api.getMeanEdge(grafo2), 0);
		
		Assert.assertEquals(2, api.getMeanEdge(grafo3), 0);
		Assert.assertNotEquals(0, api.getMeanEdge(grafo3), 0);
		Assert.assertNotEquals(5, api.getMeanEdge(grafo3), 0);
		
		Assert.assertEquals(2, api.getMeanEdge(grafo5), 0);
		Assert.assertNotEquals(0, api.getMeanEdge(grafo5), 0);
		Assert.assertNotEquals(5, api.getMeanEdge(grafo5), 0);
		
		Assert.assertEquals(42/20, api.getMeanEdge(grafo6), 0);
		Assert.assertNotEquals(0, api.getMeanEdge(grafo6), 0);
		Assert.assertNotEquals(5, api.getMeanEdge(grafo6), 0);
		
	}

	@Test
	public void testShortestPath() { // TODO falta verificar p/ grafo5 e grafo6
		String caminho;
		
		caminho = api.shortestPath(grafo1, 1, 3);
		Assert.assertEquals("1 5 3", caminho);
		caminho = api.shortestPath(grafo1, 1, 3);
		Assert.assertNotEquals("1 3", caminho);
		caminho = api.shortestPath(grafo1, 1, 3);
		Assert.assertNotEquals("1 2 5 3", caminho);
		
		caminho = api.shortestPath(grafo2, 1, 3);
		Assert.assertEquals("1 2 5 4 3", caminho); // TODO ERRO: não consida edge negativa
		caminho = api.shortestPath(grafo2, 1, 3);
		Assert.assertNotEquals("1 5 3", caminho);
		caminho = api.shortestPath(grafo2, 1, 3);
		Assert.assertNotEquals("1 2 5 3", caminho); // erro anterior (segundo menor)
		
		caminho = api.shortestPath(grafo3, 1, 4);
		Assert.assertEquals("1 5 4", caminho);
		caminho = api.shortestPath(grafo3, 1, 4);
		Assert.assertNotEquals("1 2 3 4", caminho);
		caminho = api.shortestPath(grafo3, 1, 4);
		Assert.assertNotEquals("1 2 5 4", caminho);
		
		caminho = api.shortestPath(grafo3, 1, 6); // TODO ERRO: quebra (grafo desconectado)
		Assert.assertEquals(null, caminho);
				

	}

	@Test
	public void testGraphRepresentationSemPeso() { // TODO falta verificar p/ grafo5 e grafo6
		String adjList, adjMatrix;
		
		String list1 = "\n";
		list1 += "1 - 2 5" + "\n";
		list1 += "2 - 1 5" + "\n";
		list1 += "3 - 5" + "\n";
		list1 += "4 - 5" + "\n";
		list1 += "5 - 1 2 3 4";
		
		String matrix1 = "";
		matrix1 += "  1 2 3 4 5" + "\n";
		matrix1 += "1 0 1 0 0 1" + "\n";
		matrix1 += "2 1 0 0 0 1" + "\n";
		matrix1 += "3 0 0 0 0 1" + "\n";
		matrix1 += "4 0 0 0 0 1" + "\n";
		matrix1 += "5 1 1 1 1 0";
		
		adjList = api.graphRepresentation(grafo1, "AL");
		assertEquals(list1, adjList);
		adjMatrix = api.graphRepresentation(grafo1, "AM");
		assertEquals(matrix1, adjMatrix);
		
		
		String list2 = "\n";
		list2 += "1 - 2 5" + "\n";
		list2 += "2 - 1 5" + "\n";
		list2 += "3 - 5" + "\n";
		list2 += "4 - 5" + "\n";
		list2 += "5 - 1 2 3 4";
		
		String matrix2 = "";
		matrix2 += "  1 2 3 4 5" + "\n";
		matrix2 += "1 0 1 0 0 1" + "\n";
		matrix2 += "2 1 0 0 0 1" + "\n";
		matrix2 += "3 0 0 0 0 1" + "\n";
		matrix2 += "4 0 0 0 0 1" + "\n";
		matrix2 += "5 1 1 1 1 0";
		
		adjList = api.graphRepresentation(grafo1, "AL");
		assertEquals(list2, adjList);
		adjMatrix = api.graphRepresentation(grafo1, "AM");
		assertEquals(matrix2, adjMatrix);
		
		
		String list3 = "\n";
		list3 += "1 - 2 5" + "\n";
		list3 += "2 - 1 3 5" + "\n";
		list3 += "3 - 2 4" + "\n";
		list3 += "4 - 3 5" + "\n";
		list3 += "5 - 1 2 4" + "\n";
		list3 += "6 -";
		
		String matrix3 = "";
		matrix3 += "  1 2 3 4 5 6" + "\n";
		matrix3 += "1 0 1 0 0 1 0" + "\n";
		matrix3 += "2 1 0 1 0 1 0" + "\n";
		matrix3 += "3 0 1 0 1 0 0" + "\n";
		matrix3 += "4 0 0 1 0 1 0" + "\n";
		matrix3 += "5 1 1 0 1 0 0" + "\n";
		matrix3 += "6 0 0 0 0 0 0";
		
		adjList = api.graphRepresentation(grafo3, "AL");
		assertEquals(list3, adjList);
		adjMatrix = api.graphRepresentation(grafo3, "AM");
		assertEquals(matrix3, adjMatrix);
	}
	
	@Test
	public void testGraphRepresentationComPeso() { // TODO parcialmente verificado
		String adjList, adjMatrix;
		
		String list2 = "\n";
		list2 += "1 - 2(0.1) 5(1)" + "\n";
		list2 += "2 - 1(0.1) 5(0.2)" + "\n";
		list2 += "3 - 4(-9.5) 5(5)" + "\n";
		list2 += "4 - 3(-9.5) 5(2.3)" + "\n";
		list2 += "5 - 1(1) 2(0.2) 3(5) 4(2.3)";
		
		String matrix2 = "";
		matrix2 += "  1 2 3 4 5" + "\n";
		matrix2 += "1 0 0.1 0 0 1" + "\n";
		matrix2 += "2 0.1 0 0 0 0.2" + "\n";
		matrix2 += "3 0 0 0 -9.5 5" + "\n";
		matrix2 += "4 0 0 -9.5 0 2.3" + "\n";
		matrix2 += "5 1 0.2 5 2.3 0";
		
		adjList = api.graphRepresentation(grafo2, "AL");
		assertEquals(list2, adjList);
		adjMatrix = api.graphRepresentation(grafo2, "AM");
		assertEquals(matrix2, adjMatrix);
	}

	@Test
	public void testBFS() {  // TODO parcialmente verificado
		// 2 ------- 0
		// / \
		// 1---5 ------- 1
		// / \
		// 4 3 ------- 2
		
		String result = "1 - 0 -\n" + 
				"2 - 1 1\n" + 
				"3 - 2 5\n" + 
				"4 - 2 5\n" + 
				"5 - 1 1\n";
		assertEquals(result, api.BFS(grafo1, 1));
		
		// 2 ------- 0
		// / \
		// 1---5 ------- 1
		// / \
		// 4 3 ------- 2
		
		String result2 = "1 - 0 -\n" + 
				"2 - 1 1\n" + 
				"3 - 2 5\n" + 
				"4 - 2 5\n" + 
				"5 - 1 1\n";
		assertEquals(result2, api.BFS(grafo2, 1));
		
		// 2 ------- 0
		// / \
		// 1---5 ------- 1
		// / \
		// 4 3 ------- 2
		
		String result3 = "1 - 0 -\n" + 
				"2 - 1 1\n" + 
				"3 - 2 2\n" + 
				"4 - 2 5\n" + 
				"5 - 1 1\n" +
				"0 - 0 -\n";
		assertEquals(result3, api.BFS(grafo3, 1));
	}
	
	@Test
	public void testDFS() {  // TODO não verificado
		String result = "1 - 1 5\n" + 
				"2 - 2 1\n" + 
				"3 - 1 5\n" + 
				"4 - 1 5\n" + 
				"5 - 0 -\n";
		assertEquals(result, api.DFS(grafo1, 5));
	}


	@Test
	public void testConnectedGraph() {
		Assert.assertTrue(api.connected(grafo1));
		Assert.assertTrue(api.connected(grafo2));
		Assert.assertFalse(api.connected(grafo3)); // TODO ERRO: não deveria afirmar conectado
		Assert.assertTrue(api.connected(grafo5));
		Assert.assertFalse(api.connected(grafo6)); // TODO ERRO: não deveria afirmar conectado
	}

	@Test
	public void MstTest() { // TODO não verificado
		
		String Inputresult = "5 - 0 - 0\n"
		+ "0 - 1 - 3\n"
		+ "2 - 1 - 3\n"
		+ "1 - 2 - 0\n";
				
		assertEquals(Inputresult, api.MST(grafo1));	
	}


}
