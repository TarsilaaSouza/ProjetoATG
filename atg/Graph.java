package atg;

import java.util.ArrayList;

public class Graph {

	private int vertexNumber;
	private ArrayList<Aresta> arestas;
	private ArrayList<Vertice> verticesGraph;

	protected Graph(int numVertice) {
		this.vertexNumber = numVertice;
		arestas = new ArrayList<Aresta>();
		verticesGraph = new ArrayList<Vertice>();
	}

	public enum Tipo {
		AM, AL
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public int getEdgeNumber() {
		return arestas.size();
	}

	public void addAresta(Aresta aresta) {
		arestas.add(aresta);
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public ArrayList<Vertice> getVerticesGraph() {
		return verticesGraph;
	}
}