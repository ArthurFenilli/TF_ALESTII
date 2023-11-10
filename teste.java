import java.math.BigInteger;

public class teste {

    public static void main(String args[]){
        //EdgeWeightedDigraph g = new EdgeWeightedDigraph("casof40.txt");
        //System.out.println(g.toDot());
        //System.out.println(g.getAdj("ouro"));
        //g.calcH("ouro",1);
        //System.out.println(g.getH());
        EdgeWeightedDigraphMod m = new EdgeWeightedDigraphMod("casof360.txt");
        BigInteger padrão = new BigInteger("1");
        //System.out.println(m.toDot());
        m.calcH("ouro",padrão);
        System.out.println(m.getH());
    }
    
}
