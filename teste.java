import java.math.BigInteger;

public class teste {

    public static void main(String args[]){
        //EdgeWeightedDigraph g = new EdgeWeightedDigraph("casof40.txt");
        //System.out.println(g.toDot());
        //System.out.println(g.getAdj("ouro"));
        //g.calcH("ouro",1);
        //System.out.println(g.getH());
        EdgeWeightedDigraphMod m = new EdgeWeightedDigraphMod("casof120.txt");
        BigInteger padrão = new BigInteger("1");
        //System.out.println(m.toDot());
        //long init = System.currentTimeMillis();
        m.calcH("ouro");
        //long stop = System.currentTimeMillis();
        //System.out.println(stop - init);
        System.out.println(m.getH());

        
    }
    
}
