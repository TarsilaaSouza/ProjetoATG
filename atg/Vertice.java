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
	 * O metodo statusVertice ira retornar true para os metodos de busca determinarem
	 * se o respectivo vertice ja foi atingido
	 */
	public boolean statusVertice() {
		return passou;
	}

	/*
	 * O metodo alteraStatusVertice sera utilizado para alterar a variavel evidenciando
	 * que o no ja foi atingido pelo metodo de busca
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
	public String toString() {
		return String.valueOf(valor);
	}

}