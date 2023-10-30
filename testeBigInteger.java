import java.math.BigInteger;

public class testeBigInteger{

    public BigInteger fatorial(int n){
        BigInteger f = new BigInteger("1");

        for(int i = 2; i<=n; i++){
             f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }


    public static void main(String args[]){
        testeBigInteger p = new testeBigInteger();
        BigInteger a = p.fatorial(100);
        String as = a.toString();
        System.out.println(as.equals("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"));

    }
}