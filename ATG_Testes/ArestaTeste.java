package ATG_Testes;

import static org.junit.Assert.*;
import org.junit.Test;
import ATG_Classes.Aresta;

public class ArestaTeste {
	
	String a = "1 2";
	String b = "1 2 0.1";
	String c = "1 2 -9.5";
	
    Aresta testeA = new Aresta (a.split(" "));
    Aresta testeB = new Aresta (b.split(" "));
    Aresta testeC = new Aresta (c.split(" "));

    @Test
    public void construtorArestaTeste() {

        // assert statements
        assertEquals(1, testeA.vertice1);
        assertEquals(2, testeA.vertice2);
        assertEquals( 0.0, testeA.peso, 0); // ERRO?
        
        assertEquals(1, testeB.vertice1);
        assertEquals(2, testeB.vertice2);
        assertEquals( 0.1, testeB.peso, 0);
        
        assertEquals(1, testeC.vertice1);
        assertEquals(2, testeC.vertice2);
        assertEquals(-9.5, testeC.peso, 0);
    }
    
    @Test
    public void toStringArestaTeste() {
        assertEquals(testeA.toString(), "(v1: 1, v2: 2, peso: 0.0)");
        assertEquals(testeB.toString(), "(v1: 1, v2: 2, peso: 0.1)");
        assertEquals(testeC.toString(), "(v1: 1, v2: 2, peso: -9.5)");
    }
}
