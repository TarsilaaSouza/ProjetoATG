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

	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}
	
	public boolean getPassou() {
		return passou;
	}

	public void setPassou(boolean passou) {
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