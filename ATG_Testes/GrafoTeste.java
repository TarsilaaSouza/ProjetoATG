package ATG_Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ATG_Classes.Aresta;
import ATG_Classes.Grafo;

public class GrafoTeste {
    
	String caminho1 = "teste1.txt";
	String caminho2 = "teste2.txt";
	
	Grafo testeA = new Grafo (caminho1);
	Grafo testeB = new Grafo (caminho2);

    @Test
    public void construtorGrafoTeste() {

        // assert statements
        assertEquals(0, testeA.numeroDeVertices, 5);
        assertEquals(0, testeA.arestas.size(), 5);

        
        assertEquals(0, testeB.numeroDeVertices, 5);
        assertEquals(0, testeB.arestas.size(), 6);
    }
    
    @Test
    public void arestasGrafoTeste() {

        Aresta a0 = testeA.arestas.get(0);
        Aresta a1 = testeA.arestas.get(1);
        Aresta a2 = testeA.arestas.get(2);
        Aresta a3 = testeA.arestas.get(3);
        Aresta a4 = testeA.arestas.get(4);
        
        Aresta b0 = testeB.arestas.get(0);
        Aresta b1 = testeB.arestas.get(1);
        Aresta b2 = testeB.arestas.get(2);
        Aresta b3 = testeB.arestas.get(3);
        Aresta b4 = testeB.arestas.get(4);
        Aresta b5 = testeB.arestas.get(5);
        
        
        // assert statements
        //testeA
        assertEquals(0, a0.vertice1, 1);
        assertEquals(0, a1.vertice1, 2);
        assertEquals(0, a2.vertice1, 5);
        assertEquals(0, a3.vertice1, 4);
        assertEquals(0, a4.vertice1, 1);
        
        assertEquals(0, a0.vertice2, 2);
        assertEquals(0, a1.vertice2, 5);
        assertEquals(0, a2.vertice2, 3);
        assertEquals(0, a3.vertice2, 5);
        assertEquals(0, a4.vertice2, 5);
        
        assertEquals(0, a0.peso, 0);
        assertEquals(0, a1.peso, 0);
        assertEquals(0, a2.peso, 0);
        assertEquals(0, a3.peso, 0);
        assertEquals(0, a4.peso, 0);
        
        //testeB  
        assertEquals(0, b0.vertice1, 1);
        assertEquals(0, b1.vertice1, 2);
        assertEquals(0, b2.vertice1, 5);
        assertEquals(0, b3.vertice1, 3);
        assertEquals(0, b4.vertice1, 4);
        assertEquals(0, b5.vertice1, 1);
        
        assertEquals(0, b0.vertice2, 2);
        assertEquals(0, b1.vertice2, 5);
        assertEquals(0, b2.vertice2, 3);
        assertEquals(0, b3.vertice2, 4);
        assertEquals(0, b4.vertice2, 5);
        assertEquals(0, b5.vertice2, 5);
        
        assertEquals(0, b0.peso, 0.1);
        assertEquals(0, b1.peso, 0.2);
        assertEquals(0, b2.peso, 5);
        assertEquals(0, b3.peso, -9.5);
        assertEquals(0, b4.peso, 2.3);
        assertEquals(0, b5.peso, 1);
        
    }
}