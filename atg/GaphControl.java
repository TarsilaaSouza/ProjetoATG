package atg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GaphControl {

	public Graph readGraph(String path) throws IOException {
		FileReader arq = null;
		BufferedReader lerArq = null;
		Graph grafo = null;
		try {
			arq = new FileReader(path);
			lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // 1a linha
			int numeroDeVertices = Integer.parseInt(linha);

			grafo = new Graph(numeroDeVertices);

			linha = lerArq.readLine(); // 2a ate ultima linha
			while (linha != null && !linha.isEmpty()) {
				grafo.addAresta(new Aresta(linha.split(" ")));
				linha = lerArq.readLine();
			}

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		} finally {
			if (arq != null) {
				arq.close();
			}
			if (lerArq != null) {
				lerArq.close();
			}
		}
		return grafo;
	}

	public Graph readWeightedGraph(String path) {
		// TODO readWeightedGraph
		return null;
	}

	public int getVertexNumber(Graph grafo) {
		// TODO getVertexNumber
		return 0;
	}

	public int getEdgeNumber(Graph grafo) {
		// TODO getEdgeNumber
		return 0;
	}

	public float getMeanEdge(Graph grafo) {
		// TODO getMeanEdge
		return 0;
	}

	public String graphRepresentation(Graph grafo, Graph.Tipo tipo) {
		// TODO graphRepresentation
		return null;
	}

	public String BFS(Graph grafo, Vertice vertice) {
		// TODO BFS
		return null;
	}

	public String DFS(Graph grafo, Vertice vertice) {
		// TODO DFS
		return null;
	}

	public boolean connected(Graph grafo) {
		// TODO connected
		return false;
	}

	public String shortestPath(Vertice v1, Vertice v2) {
		// TODO shortestPath
		return null;
	}

	public String mst(Graph grafo) {
		// TODO mst
		return null;
	}
}