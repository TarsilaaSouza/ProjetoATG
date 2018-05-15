package atg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GraphControl {

	public Graph readGraph(String path) throws IOException {
		FileReader arq = null;
		BufferedReader lerArq = null;
		Graph grafo = null;
		try {
			arq = new FileReader(path);
			lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // 1a linha
			int numeroDeVertices = Integer.parseInt(linha);

			grafo = new Graph(numeroDeVertices);

			linha = lerArq.readLine(); // 2a ate ultima linha
			while (linha != null && !linha.isEmpty()) {
				grafo.addAresta(new Aresta(linha.split(" ")));
				linha = lerArq.readLine();
			}
			
			AssociaGraphAresta(grafo);// associas as arestas a seus vertices pertencentes

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		} finally {
			if (arq != null) {
				arq.close();
			}
			if (lerArq != null) {
				lerArq.close();
			}
		}
		return grafo;
	}


	private void AssociaGraphAresta(Graph grafo) {
		for (int i = 0; i < grafo.getArestas().size(); i++) {		 
			 grafo.getArestas().get(i).getV1().getArestas().add(grafo.getArestas().get(i));
			 grafo.getArestas().get(i).getV2().getArestas().add(grafo.getArestas().get(i));
		}
	}
	

	public Graph readWeightedGraph(String path) throws IOException {
		return readGraph(path); // construtor de Aresta identifica se eh com peso

	}

	public int getVertexNumber(Graph grafo) {
		return grafo.getVertexNumber();
	}

	public int getEdgeNumber(Graph grafo) {
		return grafo.getEdgeNumber();
	}

	public float getMeanEdge(Graph grafo) {
		// Grau Medio = (Numero de arestas) / (numero de vertices)

		float grauMedio = grafo.getEdgeNumber() / grafo.getVertexNumber();
		
		return grauMedio;

	}

	public String graphRepresentation(Graph grafo, Graph.Tipo tipo) {
		String result = null;

		if (tipo.equals(Graph.Tipo.AM)) {
			result = representacaoAM(grafo);
		} else { // Tipo.AL
			result = representacaoAL(grafo);
		}

		return result;

	}

	private String representacaoAM(Graph grafo) {
		float[][] matriz = new float[grafo.getVertexNumber()][grafo.getVertexNumber()];
		for (Aresta aresta : grafo.getArestas()) {
			int valorA = aresta.getV1().getValor();
			int valorB = aresta.getV2().getValor();
			matriz[valorA][valorB] = aresta.getPeso(); // vale nos dois sentidos
			matriz[valorB][valorA] = aresta.getPeso(); // vale nos dois sentidos
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				result.append(matriz[i][j] + " ");
			}
			result.append("\n");
		}
		return result.toString();
	}

	private String representacaoAL(Graph grafo) {
		// TODO representacaoAL
		return null;
	}
	public String BFS(Graph grafo, Vertice vertice) {
		
		ArrayList<Integer> busca = new ArrayList<Integer>(); //vertice nivel pai	em ordem de descoberta
		ArrayList<Vertice> aux1 = new ArrayList<Vertice>(); //fila de nos pais a serem visitados
		ArrayList<Vertice> aux2 = new ArrayList<Vertice>(); //fila de nos filhos a serem visitdados
		int nivel = 0;
		
		aux1.add(vertice);//adiciona a raiz a aux1 para inicio da iteracao
		vertice.setPai(0);//seta o pai da raiz para zero
		
		while( aux1.size() > 0) {	
			
			for (int i = 0; i < aux1.size(); i++) {	
				if(aux1.get(i).getPassou() == false) {//verifrifica se o no ja nao foi atingido por outra ramificacao.
					busca.add(aux1.get(i).getValor()); 
					busca.add(nivel);
					busca.add(aux1.get(i).getPai());
					vertice.setPassou(true);
					for (int j = 0; i < vertice.getArestas().size(); j++) {
						proxVertice(vertice, vertice.getArestas().get(j)).setPai(aux1.get(i).getValor());//associa o no pai
						aux2.add(proxVertice(vertice, vertice.getArestas().get(j)));//adiciona lista dos proximos nos filhos serem percorridos
					}
					
					aux1 = aux2; //todos os nos pai ja foram percoridos, filhos se tornam a lista de nos pai
					aux2.clear(); //lista de nos filhos e esvaziada para o proximo ciclo de iteracoes
				}			
			}
			nivel++;
		}
			
		return criaStringDeSaida(grafo, busca);//formata o resutltado da busca para a string esperada
	}
	
	private String criaStringDeSaida(Graph grafo,ArrayList<Integer> busca) {
		int[] ordenaSaida = new int[grafo.getVertexNumber()*3+3];
		for (int i = 0; i < busca.size(); i+=3) {
				ordenaSaida[busca.get(i)*3] = busca.get(i); //vertice
				ordenaSaida[busca.get(i)*3+1] = busca.get(i+1); //nivel
				ordenaSaida[busca.get(i)*3+2] = busca.get(i+2); // pai
		}
		
		String retorno = "";
		for (int i = 3; i < ordenaSaida.length; i+=3) {		
					retorno +=  ordenaSaida[i] + " - " +  ordenaSaida[i+1] + " ";				
					if (ordenaSaida[i+2] == 0) {
						retorno += "-";
					}else {
						retorno += ordenaSaida[i+2];
					}				
					retorno+= "\n";
		}
		return retorno;
	}
	
	public String DFS(Graph grafo, Vertice vertice) {
		// TODO DFS
		return null;
	}

	public boolean connected(Graph grafo) {
		int numVertices = grafo.getVertexNumber();
		Set<Vertice> verticesVisitados = new HashSet<Vertice>(); // sem repeticoes
		for (Aresta aresta : grafo.getArestas()) {

			Vertice [] vertices = new Vertice[2];
			vertices[0]= aresta.getV1();
			vertices[1] = aresta.getV2();
			verticesVisitados.addAll(Arrays.asList(vertices));

		}

		return numVertices == verticesVisitados.size();
	}

	public String shortestPath(Vertice v1, Vertice v2) {
		
		ArrayList<Float> menorCaminho = new ArrayList<Float>();
		menorCaminho = menorCaminho(v1, v2, menorCaminho);
		
		if ( !menorCaminho.isEmpty() ) {
			String retorno = "";
			for (int i = 1; i < menorCaminho.size(); i++) {
				retorno += menorCaminho.get(i) + " ";
			}
			return retorno;
		}
		
		return null;
	}

	private ArrayList<Float> menorCaminho(Vertice v1, Vertice v2, ArrayList<Float> caminho){
		
		if(v1 == v2) {
			return caminho;
		}
		
		ArrayList<Float> menorCaminho = caminho;	
		
		if(caminho.size() == 0) {
			if (v1.getArestas().isEmpty()) {
				return caminho;
			}			
			menorCaminho.add((float) 0);
			menorCaminho.add((float) v1.getValor());
		}
		
		for (int i = 0; i < v1.getArestas().size(); i++) {
						
			Vertice proxVertice = proxVertice(v1, v1.getArestas().get(i));
			boolean jaPassou = false;
			for (int j = 1; j < caminho.size(); j++) {
				if (proxVertice.getValor() == caminho.get(j)) {
					jaPassou = true;
				}
			}
				
			if(!jaPassou) {
				ArrayList<Float> aux = caminho;
				aux.set(0, aux.get(0)+(v1.getArestas().get(i).getPeso()));
				aux.add((float) proxVertice.getValor());
				aux = menorCaminho(proxVertice, v2, aux);		
				
				if( aux.get(-1) == v2.getValor() &&( menorCaminho.get(0) > aux.get(0) || menorCaminho.get(0) == 0)) {
					menorCaminho = aux;
				}
					
			}
				
		}		
		return caminho;
	}
	
	private Vertice proxVertice( Vertice v1,Aresta a) { //retorna o vertice da outra ponta da aresta
		if(a.getV1() != v1) {
			return a.getV1();
		}else {
			return a.getV2();
		}
	}
	
	public String mst(Graph grafo) {
		// TODO mst
		return null;
	}
}