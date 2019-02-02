public class Exponentiate{
    private int base, exp;
    public Exponentiate(int base, int exp){
        this.base = base;
        this.exp = exp;
    }
    public int getValue(){
        // Fast exponentiation
        int ans=1;
        while(exp>0){
            if(exp%2!=0){
                ans*=base;
            }
            base=base*base;
            exp/=2;
        }
        return ans;
    }
    public static void main(String[] args) {
        Exponentiate e=new Exponentiate(3,3);
        System.out.println(e.getValue());
    }
}