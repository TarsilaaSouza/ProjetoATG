package ATG_Classes;

public class Aresta {
	
	public int vertice1, vertice2;
	public double peso; 
	
public Aresta (String [] aresta) {
		vertice1 = Integer.parseInt(aresta[0]);
		vertice2 = Integer.parseInt(aresta[1]);
		
		if (aresta.length >2)
			this.peso = Double.parseDouble(aresta[2]);	
	}
}
