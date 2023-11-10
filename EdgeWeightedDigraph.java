import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedDigraph extends EdgeWeightedGraph {
    private double h;

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

  public void calcH(String v, double elemento){
    if(v.equals("hidrogenio")){
      h = h + elemento;
      return;

    }
    else{
        Iterable<Edge> l = getAdj(v);
        for(Edge e: l){
           calcH(e.getW(), e.getWeight() * elemento);
        }
        return;

    }
  }

  public double getH(){
    return h;
  }

}
