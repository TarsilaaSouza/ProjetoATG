package atg;

import java.awt.*;
import javax.swing.*;
import org.jgrapht.*;
import org.jgrapht.ext.*;
import org.jgrapht.graph.*;
import com.mxgraph.layout.*;
import com.mxgraph.swing.*;
import com.mxgraph.util.mxConstants;

public class GraphJGraphX extends JApplet {

	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
	private JGraphXAdapter<String, MyEdge> jgxAdapter;
	private Graph grafo;

	public GraphJGraphX(Graph grafo) {
		this.grafo = grafo;
	}

	@Override
	public void init() {

		ListenableGraph<String, MyEdge> g = new DefaultListenableGraph<String, MyEdge>(new SimpleWeightedGraph<String, MyEdge>(MyEdge.class));

		jgxAdapter = new JGraphXAdapter<String, MyEdge>(g);
		getContentPane().add(new mxGraphComponent(jgxAdapter));
		resize(DEFAULT_SIZE);

		jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_ENDARROW, "none");
		setAllVertexAndEdges(g);

		mxCircleLayout layout = new mxCircleLayout(jgxAdapter);
		layout.execute(jgxAdapter.getDefaultParent());
	}

	public static class MyEdge extends DefaultWeightedEdge {

		private static final long serialVersionUID = 1L;

		@Override
		public String toString() {
			return String.valueOf(getWeight());
		}
	}

	private void setAllVertexAndEdges(ListenableGraph<String, MyEdge> g) {

		for (int i = 1; i <= grafo.getVertexNumber(); i++) {
			g.addVertex(Integer.toString(i));
		}

		for (Aresta a : grafo.getArestas()) {
			g.addEdge(a.getV1().toString(), a.getV2().toString());

			Double p = Double.valueOf(new Float(a.getPeso()).toString());
			g.setEdgeWeight(g.getEdge(a.getV1().toString(), a.getV2().toString()), p);
		}
	}
}
