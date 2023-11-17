import java.math.BigInteger;

public class Vert {
    private String name;
    private boolean state;
    private int edgeQuant;
    private int edgeCount;
    private BigInteger value;

    public Vert(String name){
        this.name = name;
        state = false;
        edgeCount = 0;
        edgeQuant = 0;
        value = new BigInteger("0");
    }

    public String getName(){
        return name;
    }

    public boolean getState(){
        return state;
    }

    public void setState(){
        state = !state;
    }

    public int getEdgeCount(){
        return edgeCount;
      }
  
       public int getEdgeQuant(){
        return edgeQuant;
      }
  
      public void sumEdgeCount(){
        edgeCount ++;
      }
  
      public void sumEdgeQuant(){
        edgeQuant ++;
      }

      public BigInteger getValue(){
        return value;
      }

      public void setValue(BigInteger e){
        value = e;
      }
    
}
