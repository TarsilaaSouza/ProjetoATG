package atg;

import java.util.ArrayList;

public class Graph {

	private int vertexNumber;
	private ArrayList<Aresta> arestas;
	private Vertice[] verticesGraph;

	protected Graph(int numVertice) {
		this.vertexNumber = numVertice;
		arestas = new ArrayList<Aresta>();
		verticesGraph = new Vertice[numVertice];
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

	public Vertice[] getVerticesGraph() {
		return verticesGraph;
	}
}