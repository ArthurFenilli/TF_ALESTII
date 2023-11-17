import java.math.BigInteger;

public class teste {

    public static void main(String args[]){
        //EdgeWeightedDigraph g = new EdgeWeightedDigraph("casof40.txt");
        //System.out.println(g.toDot());
        //System.out.println(g.getAdj("ouro"));
        //g.calcH("ouro",1);
        //System.out.println(g.getH());
        //EdgeWeightedDigraphMod m = new EdgeWeightedDigraphMod("casoteste.txt");
        //System.out.println(m.getAdj("ouro"));
        //BigInteger padrão = new BigInteger("1");
        //System.out.println(m.toDot());
        //long init = System.currentTimeMillis();
        //m.calcH("ouro",padrão);
        //long stop = System.currentTimeMillis();
        //System.out.println(stop - init);
        //System.out.println(m.getH());
        // -------------------------------------------------------------------------------------------------------------------//
        EdgeWeightedGraphMod2 p = new EdgeWeightedDigraphMod2("casof360.txt");
        //System.out.println(p.toDot());
        //System.out.println(p.hidrogênio.getEdgeCount());
        p.calcH(p.ouro);
        System.out.println(p.hidrogênio.getValue());
        

        
    }
    
}
