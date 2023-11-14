import java.math.BigInteger;

public class EdgeMod2 {
    private Vert v;
    private Vert w;
    private BigInteger weight;
  
    public EdgeMod2(Vert v, Vert w, BigInteger weight) {
      this.v = v;
      this.w = w;
      this.weight = weight;
    }
  
    public Vert getV() {
      return v;
    }

    public String getVS(){
        return v.getName();
    }

    public String getWS(){
        return w.getName();
    }
  
    public Vert getW() {
      return w;
    }
  
    public BigInteger getWeight() {
      return weight;
    }

    public void setWeight(BigInteger b){
      weight = b;
    }
  
    @Override
    public String toString() {
      return v + "-" + w + " (" + weight + ")";
    }
    
}
