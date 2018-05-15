package atg;

import java.util.ArrayList;

public class Vertice {

	private int valor;
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	private boolean passou = false;
	private int pai;

	public Vertice(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	/*
	 * O metodo statusVertice ira retornar true para os metodos de busca
	 * determinarem se o respectivo vertice ja foi atingido
	 */
	public boolean statusVertice() {
		return passou;
	}

	/*
	 * O metodo alteraStatusVertice sera utilizado para alterar a variavel
	 * evidenciando que o no ja foi atingido pelo metodo de busca
	 */
	public void alteraStatusVertice(boolean passou) {
		this.passou = passou;
	}

	public int getPai() {
		return pai;
	}

	public void setPai(int pai) {
		this.pai = pai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vertice))
			return false;
		Vertice other = (Vertice) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(valor);
	}

}