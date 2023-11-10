import java.math.BigInteger;

public class EdgeWeightedDigraphMod extends EdgeWeightedGraphMod {
    private BigInteger h;

    public EdgeWeightedDigraphMod() {
      super();
      h = new BigInteger("0");
  
    }
  
    public EdgeWeightedDigraphMod(String filename) {
      super(filename);
      h = new BigInteger("0");
    }
  
    @Override
    public void addEdge(String v, String w, BigInteger weight) {
      EdgeMod e = new EdgeMod(v, w, weight);
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
      for (EdgeMod e : getEdges())
        sb.append(String.format("%s -> %s [label=\"%.3s\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
      sb.append("}" + NEWLINE);
      return sb.toString();
    }
  
    public void calcH(String v, BigInteger elemento){
      if(v.equals("hidrogenio")){
        h = h.add(elemento);
        return;
  
      }
      else{
          Iterable<EdgeMod> l = getAdj(v);
          for(EdgeMod e: l){
             calcH(e.getW(), e.getWeight().multiply(elemento));
          }
          return;
  
      }
    }
  
    public String getH(){
      return h.toString();
    }
  
}
