import java.math.BigInteger;
import java.util.LinkedList;


public class EdgeWeightedDigraphMod2 extends EdgeWeightedGraphMod2 {
     private BigInteger h;

    public EdgeWeightedDigraphMod2() {
      super();
      h = new BigInteger("0");
  
    }
  
    public EdgeWeightedDigraphMod2(String filename) {
      super(filename);
      h = new BigInteger("0");
    }
  
    @Override
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
    if(vv.getName().equals("ouro")){
        ouro = vv;
        BigInteger o = new BigInteger("1");
        ouro.setValue(o);
    }
    
   }
    for (Vert ver : verifica) {
    if(ver.getName().equals(w) ){
        vw = ver;
    }  
   }
   if(vw == null){
    vw = new Vert(w);
    verifica.add(vw);
    if(vw.getName().equals("hidrogenio") ){
        hidrogênio = vw;
    }
    
   }

    EdgeMod2 e = new EdgeMod2(vv, vw, weight);
    vw.sumEdgeCount();
    addToList(vv, e);
    if(!vertices.contains(vv)) {
        vertices.add(vv);
        totalVertices++;
    }
    if(!vertices.contains(vw)) {
        vertices.add(vw);
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
      for (EdgeMod2 e : getEdges())
      sb.append(String.format("%s -> %s [label=\"%.3s\"]", e.getVS(), e.getWS(), e.getWeight()) + NEWLINE);
      sb.append("}" + NEWLINE);
      return sb.toString();
    }
  

/* 
    public void calcH(String v){
      LinkedList fila = new LinkedList<>();
      LinkedList filaValor = new LinkedList<BigInteger>();
      filaValor.addFirst(new BigInteger("1"));
      fila.addFirst(v);
      while(fila.isEmpty() == false){
        Iterable<EdgeMod> l = getAdj((String) fila.removeFirst());
        BigInteger g = (BigInteger) filaValor.removeFirst();
         for(EdgeMod e: l){
          if(!e.getW().equals("hidrogenio")){
            e.setWeight(e.getWeight().multiply(g));
            filaValor.add(e.getWeight());
            fila.add(e.getW());
          }
          else{
            g = e.getWeight().multiply(g);
            h = h.add(g);
          }
          
          }

      }
    }

    */

    public void calcH(Vert v){
      LinkedList<Vert> fila = new LinkedList<Vert>();
      fila.addFirst(v);
      while(fila.isEmpty() == false){
        Iterable<EdgeMod2> l = getAdj((Vert)fila.removeFirst());
        for(EdgeMod2 e: l){
          e.getW().setValue(e.getW().getValue().add(e.getWeight().multiply(e.getV().getValue())));
          e.getW().sumEdgeQuant();
          if(e.getW().getEdgeQuant() == e.getW().getEdgeCount()){
           fila.add(e.getW());
          }
        }

      }

    }
  
  

 
}
