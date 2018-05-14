package atg;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private int vertexNumber;
	private ArrayList<Aresta> arestas;


	protected Graph(int numVertice) {
		this.vertexNumber = numVertice;
		arestas = new ArrayList<Aresta>();
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

}