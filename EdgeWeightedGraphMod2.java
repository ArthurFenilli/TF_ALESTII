import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedGraphMod2 {
    protected static final String NEWLINE = System.getProperty("line.separator");
  protected ArrayList<Vert> verifica;
  protected Map<Vert, List<EdgeMod2>> graph;
  protected Set<Vert> vertices;
  protected int totalVertices;
  protected int totalEdges;
  public BigInteger hidr;
  protected Vert hidrogênio;
  public Vert ouro;

  public EdgeWeightedGraphMod2() {
    graph = new HashMap<>();
    vertices = new HashSet<>();
    totalVertices = totalEdges = 0;
  }

  public EdgeWeightedGraphMod2(String filename) {
    this();
    verifica = new ArrayList<>();
    hidr = new BigInteger("0");
    In in = new In(filename);
    String line;
    while ((line = in.readLine()) != null) {
      String[] edge = line.split(" ");
      for(int i = 0;i< edge.length - 3;i = i + 2){
        addEdge((edge[edge.length - 1]),(edge[i + 1]), new BigInteger(edge[i]) );
      }
      //addEdge(edge[0], edge[1], Double.parseDouble(edge[2]));
    }
    in.close();
  }

  public void addEdge(String v, String w, BigInteger weight) {
    Vert vv = null;
    Vert vw = null;
   for (Vert ver : verifica) {
    if(ver.getName().equals(v)){
        vv = ver;
    }  
   }
   if(vv == null){
    vv = new Vert(v);
    verifica.add(vv);
   }
    for (Vert ver : verifica) {
    if(ver.getName().equals(w) ){
        vw = ver;
    }  
   }
   if(vw == null){
    vw = new Vert(w);
    verifica.add(vw);
   }
   
    EdgeMod2 e = new EdgeMod2(vv, vw, weight);
    addToList(vv, e);
    addToList(vw, e);
    if(!vertices.contains(vv)) {
        if(vv.getName().equals("ouro")){
            ouro = vv;
        }
      vertices.add(vv);
      totalVertices++;
    }
    if(!vertices.contains(vw)) {
     if(vw.getName().equals("hidrogenio") ){
        hidrogênio = vw;
     }
      vertices.add(vw);
      totalVertices++;
    }
    totalEdges += 2;
  }

  public Iterable<EdgeMod2> getAdj(Vert v) {
    List<EdgeMod2> res = graph.get(v);
    if (res == null) res = new ArrayList<>();
    return res;
  }

  public boolean verifyAdj(Vert v){
    Iterable<EdgeMod2> lista = getAdj(v);
    for(EdgeMod2 e:lista){
      if(e.getW().equals(v) == false){
        if(e.getW().getState() == false ){
          return false;
        }
      }
    }
    return true;
  }

  public int getTotalVerts() { return totalVertices; }
  
  public int getTotalEdges() { return totalEdges; }

  public Set<Vert> getVerts() {
    return vertices;
  }

  public Iterable<EdgeMod2> getEdges() {
    Set<EdgeMod2> ed = new HashSet<>();
    for (Vert v : getVerts().stream().toList()) {
      for (EdgeMod2 e : getAdj(v)) {
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
    for (EdgeMod2 e : getEdges())
      sb.append(String.format("%s -- %s [label=\"%.3s\"]", e.getVS(), e.getWS(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

  public Vert getHidrogenioVert(){
    return hidrogênio;
  }

  // Adiciona um vértice adjacente a outro, criando a lista
  // de adjacências caso ainda não exista no dicionário
  protected List<EdgeMod2> addToList(Vert v, EdgeMod2 e) {
    List<EdgeMod2> list = graph.get(v);
    if (list == null)
      list = new ArrayList<>();
    list.add(e);
    graph.put(v, list);
    return list;
  }

  public void somaH(){
    calcH(hidrogênio);
    Vert o = ouro;
    Iterable<EdgeMod2> l1 = getAdj(o);
    for (EdgeMod2 e : l1) {
        hidr = hidr.add(e.getWeight());
    }

  }

  public void calcH(Vert v){

    BigInteger n;
    n = new BigInteger("0");
    if(v.getName().equals("ouro") || v.getName().equals("hidrogenio")){
      if(v.getName().equals("hidrogenio")){
        n = new BigInteger("1");
      }
      else{

      }
    }
    Iterable<EdgeMod2> l1 = getAdj(v);
    v.setState();
    
    //for(EdgeMod2 e:l1){ // marca que o vertice atual ja foi observado
     // if(e.getV().equals(v)){
       // e.getV().setState();
      //}
      //else{
      // e.getW().setState();
     // }
    //}
    
    while(verifyAdj(v) == false){
      for(EdgeMod2 e: l1){
        if(!e.getW().equals(v)  && e.getW().getState() == false){
          calcH(e.getW());
        }
      }
    }
    for (EdgeMod2 e : l1) {
      if(!e.getW().equals(v) ){
          n = n.add(e.getWeight());
        }
    }
    for(EdgeMod2 e : l1){
      if(e.getW().equals(v) ){
        e.setWeight(e.getWeight().multiply(n));
      }
    }
    for(EdgeMod2 e : l1){
      if(e.getW().equals(v) && e.getV().getState() == false){
        calcH(e.getV());
      }
    }
    return;

   
  }
    
    
}
