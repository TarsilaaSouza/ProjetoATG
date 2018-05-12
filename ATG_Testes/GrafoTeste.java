package ATG_Testes;

import static org.junit.Assert.*;

import org.junit.Test;
import ATG_Classes.Aresta;
import ATG_Classes.Grafo;

public class GrafoTeste {
    
	String teste1 = "teste1.txt";
	String teste2 = "teste2.txt";
	
	Grafo testeA = new Grafo (teste1);
	Grafo testeB = new Grafo (teste2);

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
        assertEquals(1, a0.vertice1);
        assertEquals(2, a1.vertice1);
        assertEquals(5, a2.vertice1);
        assertEquals(4, a3.vertice1);
        assertEquals(1, a4.vertice1);
        
        assertEquals(2, a0.vertice2);
        assertEquals(5, a1.vertice2);
        assertEquals(3, a2.vertice2);
        assertEquals(5, a3.vertice2);
        assertEquals(5, a4.vertice2);
        
        assertEquals(0, a0.peso, 0);
        assertEquals(0, a1.peso, 0);
        assertEquals(0, a2.peso, 0);
        assertEquals(0, a3.peso, 0);
        assertEquals(0, a4.peso, 0);
        
        //testeB  
        assertEquals(1, b0.vertice1);
        assertEquals(2, b1.vertice1);
        assertEquals(5, b2.vertice1);
        assertEquals(3, b3.vertice1);
        assertEquals(4, b4.vertice1);
        assertEquals(1, b5.vertice1);
        
        assertEquals(2, b0.vertice2);
        assertEquals(5, b1.vertice2);
        assertEquals(3, b2.vertice2);
        assertEquals(4, b3.vertice2);
        assertEquals(5, b4.vertice2);
        assertEquals(5, b5.vertice2);
        
        assertEquals( 0.1, b0.peso, 0);
        assertEquals( 0.2, b1.peso, 0);
        assertEquals( 5.0, b2.peso, 0);
        assertEquals(-9.5, b3.peso, 0);
        assertEquals( 2.3, b4.peso, 0);
        assertEquals( 1.0, b5.peso, 0);
        
    }
}