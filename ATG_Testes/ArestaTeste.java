package ATG_Testes;

import static org.junit.Assert.*;
import org.junit.Test;
import ATG_Classes.Aresta;

public class ArestaTeste {
	
	String a = "1 2";
	String b = "1 2 0.1";
	
    Aresta testeA = new Aresta (a.split(" "));
    Aresta testeB = new Aresta (b.split(" "));

    @Test
    public void construtorArestaTeste() {

        // assert statements
        assertEquals(0, testeA.vertice1, 1);
        assertEquals(0, testeA.vertice2, 2);
        assertEquals(0, testeA.peso, 0); // POSSÍVEL ERRO
        
        assertEquals(0, testeB.vertice1, 1);
        assertEquals(0, testeB.vertice2, 2);
        assertEquals(0, testeB.peso, 0.1);
    }
}
