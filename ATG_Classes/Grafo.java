package ATG_Classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
   
    public int numeroDeVertices = 0;
    public List<Aresta> arestas = new ArrayList<Aresta>();
   
    public Grafo (String path) {
         
            try {
              FileReader arq = new FileReader(path);
              BufferedReader lerArq = new BufferedReader(arq);
         
              String linha = lerArq.readLine(); // 1a linha
              numeroDeVertices = Integer.parseInt(linha);
             
              while (linha != null && !linha.isEmpty()) {
                linha = lerArq.readLine(); // 2a até última linha
                arestas.add(new Aresta(linha.split(" ")));
              }
              arq.close();
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                  e.getMessage());
            }
          }


   
   
     

      }