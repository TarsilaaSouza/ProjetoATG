package atg;

public class Aresta {

	private Vertice v1;
	private Vertice v2;
	private float peso;

	public Aresta(String[] linha) {

		setV1(new Vertice(Integer.parseInt(linha[0])));
		setV2(new Vertice(Integer.parseInt(linha[1])));
		peso = 1;

		if (linha.length > 2) {
			this.peso = Float.parseFloat(linha[2]);
		}
	}

	public float getPeso() {
		return peso;
	}

	public Vertice getV1() {
		return v1;
	}

	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public void setV2(Vertice v2) {
		this.v2 = v2;
	}
	
	@Override
	public String toString() {
		return "(vertices=[" + v1.toString() + ", " + v2.toString() + "], peso = " + peso + ")";
	}
}