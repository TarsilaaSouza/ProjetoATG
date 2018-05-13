package atg;

import java.util.Arrays;

public class Aresta {

	private Vertice[] vertices;
	private float peso;

	public Aresta(String[] linha) {
		vertices = new Vertice[2];

		vertices[0] = new Vertice(Integer.parseInt(linha[0]));
		vertices[1] = new Vertice(Integer.parseInt(linha[1]));
		peso = 1;

		if (linha.length > 2) {
			this.peso = Float.parseFloat(linha[2]);
		}
	}

	public Vertice[] getVertices() {
		return vertices;
	}

	public float getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "(vertices=" + Arrays.toString(vertices) + ", peso = " + peso + ")";
	}
}