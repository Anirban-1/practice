// https://practice.geeksforgeeks.org/problems/maximum-tip-calculator/0
/**
 * The idea is to select ith item from A or B so as to maximize the net profit.
 * We can choose A[i] and recurse for the remaining n-1 elements while x (i.e., number of orders Rahul can take) becomes x-1,
 * or we can choose B[i] and recurse for the remaining n-1 elements while y (i.e., number of orders Ankit can take) becomes y-1
 */
/**
 * =====================RECURRENCE=====================================
 * f(n,x,y) = {
 *      0, if n==0;
 *      max(a[n]+f(n-1,x-1,y), b[n]+f(n-1,x,y-1)), if x!=0 & y!=0;
 *      a[n]+f(n-1,x-1,y), if y==0;
 *      b[n]+f(n-1,x,y-1), if x==0;
 * }
 */
import java.io.*;
class MaximumTipCalculator{
    static int max(int x,int y){
        return x>y?x:y;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(buff.readLine());
        while(t-->0){
            String[] in=buff.readLine().split(" ");
            int n=Integer.parseInt(in[0]), x=Integer.parseInt(in[1]), y=Integer.parseInt(in[2]);
            int []a=new int[n+1];
            int []b=new int[n+1];
            int [][][]dp=new int[n+1][x+1][y+1];
            in=buff.readLine().split(" ");
            for(int i=1;i<=n;i++)a[i]=Integer.parseInt(in[i-1]);
            in=buff.readLine().split(" ");
            for(int i=1;i<=n;i++)b[i]=Integer.parseInt(in[i-1]);
            /**
             *  f(n,x,y) = {
             *      0, if n=0
             *  }
             */
            for(int i=0;i<=x;i++)
                for(int j=0;j<=y;j++)
                    dp[0][x][y]=0;

            for(int i=1;i<=n;i++){
                /**
                 *  f(n,x,y) = {
                 *      a[n]+f(n-1,x-1,y), if y==0;
                 *  }
                 */
                for(int j=1;j<=x;j++)
                    dp[i][j][0]=dp[i-1][j-1][0]+a[i];
                /**
                 *  f(n,x,y) = {
                 *      b[n]+f(n-1,x,y-1), if x==0;
                 *  }
                 */
                for(int j=1;j<=y;j++)
                    dp[i][0][j]=dp[i-1][0][j-1]+b[i];
            }
            /**
             *  f(n,x,y) = {
             *      max(a[n]+f(n-1,x-1,y), b[n]+f(n-1,x,y-1)), if x!=0 & y!=0;
             *  }
             */
            for(int i=1;i<=n;i++){
                for(int j=1;j<=x;j++){
                    for(int k=1;k<=y;k++)
                        dp[i][j][k]=max(a[i]+dp[i-1][j-1][k],b[i]+dp[i-1][j][k-1]);
                }
            }
            System.out.println(dp[n][x][y]);
        }
    }
}