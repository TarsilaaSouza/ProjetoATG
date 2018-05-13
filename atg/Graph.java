package atg;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private int vertexNumber;
	public List<Aresta> arestas;

	protected Graph(int numVertice) {
		this.vertexNumber = numVertice;
		arestas = new ArrayList<Aresta>();
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public void addAresta(Aresta aresta) {
		arestas.add(aresta);
	}

	public enum Tipo {
		AM, AL
	}

}