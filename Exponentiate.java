public class Exponentiate{
    private int base, exp;
    public Exponentiate(int base, int exp){
        this.base = base;
        this.exp = exp;
    }
    public int getValue(){
        int ans=1;
        while(exp>0){
            if(exp%2!=0)
                ans = base*ans*ans;
            else ans=ans*ans;
            exp/=2;
        }
        return ans;
    }
}