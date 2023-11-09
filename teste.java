public class teste {

    public static void main(String args[]){
        EdgeWeightedGraph g = new EdgeWeightedGraph("casoteste.txt");
        System.out.println(g.toDot());
    }
    
}
