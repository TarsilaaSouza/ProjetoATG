package atg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;

public abstract class GraphControl {

	/**
	 * O metodo readGraph ira gerar um grafo a partir de um arquivo txt passado como
	 * parametro
	 * 
	 * @param path
	 * @return Graph
	 * @throws IOException
	 */
	public static Graph readGraph(String path) throws IOException {
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

			associaGraphAresta(grafo);
			criaListaDeVertices(grafo);
			resetStatusVertex(grafo);

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		} catch (Exception e) {
			System.err.printf("Conteudo do arquivo invalido: %s - %s\n", path, e.getMessage());
		} finally {
			if (arq != null) {
				arq.close();
			}
			if (lerArq != null) {
				lerArq.close();
			}
		}
//		showGraph(grafo);
		return grafo;
	}

	/**
	 * O metodo ira associar as arestas aos respectivos vertices
	 * 
	 * @param grafo
	 */
	private static void associaGraphAresta(Graph grafo) {
		for (int i = 0; i < grafo.getArestas().size(); i++) {
			grafo.getArestas().get(i).getV1().getArestas().add(grafo.getArestas().get(i));
			grafo.getArestas().get(i).getV2().getArestas().add(grafo.getArestas().get(i));
		}
	}

	/**
	 * O metodo ira criar uma lista de todos os vertices pertencentes ao grafo,
	 * sendo essa uma lista de adjacencias
	 * 
	 * @param graph
	 */
	private static void criaListaDeVertices(Graph graph) {
		for (int i = 0; i < graph.getArestas().size(); i++) {
			if (!graph.getArestas().get(i).getV1().statusVertice()) {
				graph.getVerticesGraph().add( graph.getArestas().get(i).getV1() );
				graph.getArestas().get(i).getV1().alteraStatusVertice(true);
			}

			if (!graph.getArestas().get(i).getV2().statusVertice()) {
				graph.getVerticesGraph().add( graph.getArestas().get(i).getV2() );
				graph.getArestas().get(i).getV2().alteraStatusVertice(true);

			}
		}
	}

	/**
	 * O metodo ira passar pelos vertices do grafo resetando o status do mesmo para
	 * com isso realizar novas buscas corretamente
	 * 
	 * @param graph
	 */
	private static void resetStatusVertex(Graph graph) {
		for (int i = 0; i < graph.getVerticesGraph().size(); i++) {
			graph.getVerticesGraph().get(i).alteraStatusVertice(false);
		}
	}

	/**
	 * O metodo readGraph ira gerar um grafo considerando arestas com pesos a partir
	 * de um arquivo txt passado como parametro
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static Graph readWeightedGraph(String path) throws IOException {
		// construtor de Aresta identifica se eh com peso
		return readGraph(path);
	}

	/**
	 * O metodo calcula o total de vertices do grafo
	 * 
	 * @param grafo
	 * @return
	 */
	public static int getVertexNumber(Graph grafo) {
		return grafo.getVertexNumber();
	}

	/**
	 * O metodo calcula o total de arestas do grafo
	 * 
	 * @param grafo
	 * @return
	 */
	public static int getEdgeNumber(Graph grafo) {
		return grafo.getEdgeNumber();
	}

	/**
	 * O metodo ira calcular o grau medio do grafo passado como parametro a partir
	 * do numero de arestas e numero de vertices.
	 * 
	 * @param grafo
	 * @return
	 */
	public static float getMeanEdge(Graph grafo) {
		float grauMedio = 2 * (float) grafo.getEdgeNumber() / grafo.getVertexNumber();

		return grauMedio;
	}

	/**
	 * O metodo ira mostrar a representacao do tipo do grafo
	 * 
	 * @param grafo
	 * @param tipo
	 * @return
	 */
	public static String graphRepresentation(Graph grafo, Graph.Tipo tipo) {
		String result = null;

		if (tipo.equals(Graph.Tipo.AM)) {
			result = representacaoAM(grafo);
		} else { // Tipo.AL
			result = representacaoAL(grafo);
		}

		return result;
	}

	/**
	 * O metodo ira gerar uma representacao do tipo AM (matriz de adjacencia) a
	 * partir do grafo passado como parametro
	 * 
	 * @param grafo
	 * @return
	 */
	private static String representacaoAM(Graph grafo) {
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

	/**
	 * O metodo ira gerar uma representacao do tipo AL (lista de adjacencia) a
	 * partir do grafo passado como parametro
	 * 
	 * @param grafo
	 * @return
	 */
	private static String representacaoAL(Graph grafo) {
		String retorno = "";

		for (int i = 0; i < grafo.getVerticesGraph().size(); i++) {
			retorno += grafo.getVerticesGraph().get(i).getValor()  + " ";

			for (int j = 0; j < grafo.getVerticesGraph().get(i).getArestas().size(); j++) {
				retorno += proxVertice(grafo.getVerticesGraph().get(i), grafo.getVerticesGraph().get(i).getArestas().get(j)) + " ";
			}

			retorno += "/n";
		}

		return retorno;
	}

	/**
	 * O metodo ira realizar uma busca por profundidade a partir do grafo passado
	 * como paramentro
	 * 
	 * @param grafo
	 * @param vertice
	 * @return
	 */
	public static String BFS(Graph grafo, Vertice vertice) {
		ArrayList<Integer> busca = new ArrayList<Integer>(); // vertice nivel pai em ordem de descoberta
		ArrayList<Vertice> aux1 = new ArrayList<Vertice>(); // fila de nos pais a serem visitados
		ArrayList<Vertice> aux2 = new ArrayList<Vertice>(); // fila de nos filhos a serem visitdados

		int nivel = 0;

		aux1.add(vertice);// adiciona a raiz a aux1 para inicio da iteracao
		vertice.setPai(0);// seta o pai da raiz para zero

		while (aux1.size() > 0) {
			for (int i = 0; i < aux1.size(); i++) {
				if (aux1.get(i).statusVertice() == false) {// verifrifica se o no ja nao foi atingido por outra ramificacao.
					busca.add(aux1.get(i).getValor());
					busca.add(nivel);
					busca.add(aux1.get(i).getPai());
					vertice.alteraStatusVertice(true);

					for (int j = 0; i < vertice.getArestas().size(); j++) {
						proxVertice(vertice, vertice.getArestas().get(j)).setPai(aux1.get(i).getValor());// associa o no pai
						aux2.add(proxVertice(vertice, vertice.getArestas().get(j)));// adiciona lista dos proximos nos filhos serem percorridos
					}

					aux1 = aux2; // todos os nos pai ja foram percoridos, filhos se tornam a lista de nos pai
					aux2.clear(); // lista de nos filhos e esvaziada para o proximo ciclo de iteracoes
				}
			}

			nivel++;
		}

		resetStatusVertex(grafo);

		return criaStringDeSaida(grafo, busca);// formata o resutltado da busca para a string esperada
	}

	/**
	 * O metodo fara uma formatacao de String a partir de um array do tipo Int
	 * 
	 * @param grafo
	 * @param busca
	 * @return
	 */
	private static String criaStringDeSaida(Graph grafo, ArrayList<Integer> busca) {
		int[] ordenaSaida = new int[grafo.getVertexNumber() * 3 + 3];

		for (int i = 0; i < busca.size(); i += 3) {
			ordenaSaida[busca.get(i) * 3] = busca.get(i); // vertice
			ordenaSaida[busca.get(i) * 3 + 1] = busca.get(i + 1); // nivel
			ordenaSaida[busca.get(i) * 3 + 2] = busca.get(i + 2); // pai
		}

		String retorno = "";

		for (int i = 3; i < ordenaSaida.length; i += 3) {
			retorno += ordenaSaida[i] + " - " + ordenaSaida[i + 1] + " ";
			if (ordenaSaida[i + 2] == 0) {
				retorno += "-";

			} else {
				retorno += ordenaSaida[i + 2];
			}

			retorno += "\n";
		}

		return retorno;
	}

	public static String DFS(Graph grafo, Vertice vertice) {
		// TODO DFS
		return null;
	}

	/**
	 * true caso o grafo passado como parametro seja conectado. 
	 * false caso contrario
	 * 
	 * @param grafo
	 * @return
	 */
	public static boolean connected(Graph grafo) {
		int numVertices = grafo.getVertexNumber();
		Set<Vertice> verticesVisitados = new HashSet<Vertice>(); // sem repeticoes
		for (Aresta aresta : grafo.getArestas()) {
			verticesVisitados.add(aresta.getV1());
			verticesVisitados.add(aresta.getV2());
		}

		return numVertices == verticesVisitados.size();
	}

	/**
	 * O metodo encontra o menor caminho entre os vertices passados como paramentro
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String shortestPath(Vertice v1, Vertice v2) {
		ArrayList<Float> menorCaminho = new ArrayList<Float>();
		menorCaminho = menorCaminho(v1, v2, menorCaminho);

		if (!menorCaminho.isEmpty()) {
			String retorno = "";
			for (int i = 1; i < menorCaminho.size(); i++) {
				retorno += menorCaminho.get(i) + " ";
			}
			return retorno;
		}

		return null;
	}

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @param caminho
	 * @return
	 */
	private static ArrayList<Float> menorCaminho(Vertice v1, Vertice v2, ArrayList<Float> caminho) {
		if (v1 == v2) {
			return caminho;
		}

		ArrayList<Float> menorCaminho = caminho;

		if (caminho.size() == 0) {
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

			if (!jaPassou) {
				ArrayList<Float> aux = caminho;
				aux.set(0, aux.get(0) + (v1.getArestas().get(i).getPeso()));
				aux.add((float) proxVertice.getValor());
				aux = menorCaminho(proxVertice, v2, aux);

				if (aux.get(-1) == v2.getValor() && (menorCaminho.get(0) > aux.get(0) || menorCaminho.get(0) == 0)) {
					menorCaminho = aux;
				}
			}
		}
		return caminho;
	}

	/**
	 * O metodo retorna o vertice da outra extremidade da aresta
	 * 
	 * @param v1
	 * @param a
	 * @return
	 */
	private static Vertice proxVertice(Vertice v1, Aresta a) {
		if (a.getV1() != v1) {
			return a.getV1();
		} else {
			return a.getV2();
		}
	}

	public static String mst(Graph grafo) {
		// TODO mst
		return null;
	}
	
	public static void showGraph (Graph grafo) {
		GraphJGraphX applet = new GraphJGraphX(grafo);
        applet.init();
        
        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}