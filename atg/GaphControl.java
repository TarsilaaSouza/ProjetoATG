package atg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

	public Graph readWeightedGraph(String path) throws IOException {
		return readGraph(path); // construtor de Aresta identifica se eh com peso
	}

	public int getVertexNumber(Graph grafo) {
		return grafo.getVertexNumber();
	}

	public int getEdgeNumber(Graph grafo) {
		return grafo.getEdgeNumber();
	}

	public float getMeanEdge(Graph grafo) {
		// Grau Medio = (Numero de arestas) / (numero de vertices)
		float grauMedio = grafo.getEdgeNumber() / grafo.getVertexNumber();
		return grauMedio;
	}

	public String graphRepresentation(Graph grafo, Graph.Tipo tipo) {
		String result = null;

		if (tipo.equals(Graph.Tipo.AM)) {
			result = representacaoAM(grafo);
		} else { // Tipo.AL
			result = representacaoAL(grafo);
		}

		return result;
	}

	private String representacaoAM(Graph grafo) {
		float[][] matriz = new float[grafo.getVertexNumber()][grafo.getVertexNumber()];
		for (Aresta aresta : grafo.getArestas()) {
			Vertice[] vertices = aresta.getVertices();
			int valorA = vertices[0].getValor();
			int valorB = vertices[1].getValor();
			matriz[valorA][valorB] = aresta.getPeso(); // vale nos dois sentidos
			matriz[valorB][valorA] = aresta.getPeso(); // vale nos dois sentidos
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				result.append(matriz[i][j] + " ");
			}
			result.append("\n");
		}
		return result.toString();
	}

	private String representacaoAL(Graph grafo) {
		// TODO representacaoAL
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
		int numVertices = grafo.getVertexNumber();
		Set<Vertice> verticesVisitados = new HashSet<Vertice>(); // sem repeticoes
		for (Aresta aresta : grafo.getArestas()) {
			verticesVisitados.addAll(Arrays.asList(aresta.getVertices()));
		}

		return numVertices == verticesVisitados.size();
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