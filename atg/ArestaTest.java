package atg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArestaTest {

	private String a = "1 2";
	private String b = "1 2 0.1";
	private String c = "1 2 -9.5";

	private Aresta testeA;
	private Aresta testeB;
	private Aresta testeC;

	@Before
	public void testAresta() {
		testeA = new Aresta(a.split(" "));
		testeB = new Aresta(b.split(" "));
		testeC = new Aresta(c.split(" "));
	}

	@Test
	public void testGetVertices() {
		assertEquals(1, testeA.getV1().getValor());
		assertEquals(2, testeA.getV2().getValor());

		assertEquals(1, testeB.getV1().getValor());
		assertEquals(2, testeB.getV2().getValor());

		assertEquals(1, testeC.getV1().getValor());
		assertEquals(2, testeC.getV2().getValor());
	}

	@Test
	public void testGetPeso() {
		assertEquals(1.0, testeA.getPeso(), 0.001);

		assertEquals(0.1, testeB.getPeso(), 0.001);

		assertEquals(-9.5, testeC.getPeso(), 0.001);
	}

	@Test
	public void testToString() {
		assertEquals(testeA.toString(), "(vertices=[1, 2], peso = 1.0)");
		
		assertEquals(testeB.toString(), "(vertices=[1, 2], peso = 0.1)");
		
		assertEquals(testeC.toString(), "(vertices=[1, 2], peso = -9.5)");
	}
}
