import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedDigraph extends EdgeWeightedGraph {
    private int h;

  public EdgeWeightedDigraph() {
    super();
    h = 0;

  }

  public EdgeWeightedDigraph(String filename) {
    super(filename);
  }

  @Override
  public void addEdge(String v, String w, double weight) {
    Edge e = new Edge(v, w, weight);
    addToList(v, e);
    if(!vertices.contains(v)) {
      vertices.add(v);
      totalVertices++;
    }
    if(!vertices.contains(w)) {
      vertices.add(w);
      totalVertices++;
    }
    totalEdges += 2;
    totalEdges++;
  }

  @Override
  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (Edge e : getEdges())
      sb.append(String.format("%s -> %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

  public void calcH(Edge v, int hidrogenio){
    if(v.getV().equals("hidrogenio"))
    return;
    else{
        Iterable<Edge> l = getAdj(v.getV());
        for(Edge w: l){

        }

    }
  }
}
