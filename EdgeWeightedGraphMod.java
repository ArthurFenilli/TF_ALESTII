import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedGraphMod {
    protected static final String NEWLINE = System.getProperty("line.separator");

  protected Map<String, List<EdgeMod>> graph;
  protected Set<String> vertices;
  protected int totalVertices;
  protected int totalEdges;

  public EdgeWeightedGraphMod() {
    graph = new HashMap<>();
    vertices = new HashSet<>();
    totalVertices = totalEdges = 0;
  }

  public EdgeWeightedGraphMod(String filename) {
    this();
    In in = new In(filename);
    String line;
    while ((line = in.readLine()) != null) {
      String[] edge = line.split(" ");
      for(int i = 0;i< edge.length - 3;i = i + 2){
        addEdge(edge[edge.length - 1],edge[i + 1], new BigInteger(edge[i]) );
      }
      //addEdge(edge[0], edge[1], Double.parseDouble(edge[2]));
    }
    in.close();
  }

  public void addEdge(String v, String w, BigInteger weight) {
    EdgeMod e = new EdgeMod(v, w, weight);
    addToList(v, e);
    addToList(w, e);
    if(!vertices.contains(v)) {
      vertices.add(v);
      totalVertices++;
    }
    if(!vertices.contains(w)) {
      vertices.add(w);
      totalVertices++;
    }
    totalEdges += 2;
  }

  public Iterable<EdgeMod> getAdj(String v) {
    List<EdgeMod> res = graph.get(v);
    if (res == null) res = new ArrayList<>();
    return res;
  }

  public int getTotalVerts() { return totalVertices; }
  
  public int getTotalEdges() { return totalEdges; }

  public Set<String> getVerts() {
    return vertices;
  }

  public Iterable<EdgeMod> getEdges() {
    Set<EdgeMod> ed = new HashSet<>();
    for (String v : getVerts().stream().sorted().toList()) {
      for (EdgeMod e : getAdj(v)) {
        if (!ed.contains(e)) {
          ed.add(e);
        }
      }
    }
    return ed;
  }

  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("graph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (EdgeMod e : getEdges())
      sb.append(String.format("%s -- %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

  // Adiciona um vértice adjacente a outro, criando a lista
  // de adjacências caso ainda não exista no dicionário
  protected List<EdgeMod> addToList(String v, EdgeMod e) {
    List<EdgeMod> list = graph.get(v);
    if (list == null)
      list = new ArrayList<>();
    list.add(e);
    graph.put(v, list);
    return list;
  }
    
}
