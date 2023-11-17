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
  public String hidr;

  public EdgeWeightedGraphMod() {
    graph = new HashMap<>();
    vertices = new HashSet<>();
    totalVertices = totalEdges = 0;
  }

  public EdgeWeightedGraphMod(String filename) {
    this();
    hidr = "0";
    In in = new In(filename);
    String line;
    while ((line = in.readLine()) != null) {
      String[] edge = line.split(" ");
      for(int i = 0;i< edge.length - 3;i = i + 2){
        addEdge((edge[edge.length - 1] + "f"),(edge[i + 1] + "f"), new BigInteger(edge[i]) );
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

  public boolean verifyAdj(String v){
    Iterable<EdgeMod> lista = getAdj(v);
    for(EdgeMod e:lista){
      if(e.getW().equals(v) == false){
        if(e.getW().charAt(e.getW().length()-1) != 'v'){
          return false;
        }
      }
    }
    
    return true;
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
      sb.append(String.format("%s -- %s [label=\"%.3s\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
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

  public void calcH(String v){
    BigInteger n;
    n = new BigInteger("0");
    if(v.equals("ourof") || v.equals("hidrogeniof")){
      if(v.equals("hidrogeniof")){
        n = new BigInteger("1");
      }
      else{

      }
    }
    Iterable<EdgeMod> l1 = getAdj(v);
    for(EdgeMod e:l1){ // marca que o vertice atual ja foi observado
      if(e.getV().contains(v.substring(0, v.length() -1))){
        String vn = e.getV().substring(0, v.length() -1) + "v";
        e.setV(vn);
      }
      else{
        String wn = e.getW().substring(0, v.length() -1) + "v";
        e.setW(wn);
      }
      v = v.substring(0, v.length()-1) + "v";
    }
    while(verifyAdj(v) == false){
      for(EdgeMod e: l1){
        if(e.getW() != v && e.getW().charAt(e.getW().length() - 1) == 'f'){
          calcH(e.getW());
        }
      }
    }
    for (EdgeMod e : l1) {
      if(e.getW() != v){
          n = n.add(e.getWeight());
        }
    }
    for(EdgeMod e : l1){
      if(e.getW() == v ){
        e.setWeight(e.getWeight().multiply(n));
      }
    }
    for(EdgeMod e : l1){
      if(e.getW() == v){
        calcH(e.getV());
      }
    }
    return;


   
  }
}
