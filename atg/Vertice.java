package atg;

public class Vertice {

	private int valor;

	public Vertice(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return String.valueOf(valor);
	}
}