public class teste {

    public static void main(String args[]){
        EdgeWeightedDigraph g = new EdgeWeightedDigraph("casoteste.txt");
        System.out.println(g.toDot());
        System.out.println(g.getAdj("ouro"));
    }
    
}
