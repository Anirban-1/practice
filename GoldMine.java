// https://www.geeksforgeeks.org/gold-mine-problem/
import java.io.*;
class GoldMine{
    static int max(int x,int y){
        return Math.max(x,y);
    }
    static int max(int x,int y,int z){
        return max(x,max(y,z));
    }
    public static void main(String[] args)throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        String[]in=buff.readLine().split(" ");
        n=Integer.parseInt(in[0]);
        m=Integer.parseInt(in[1]);
        int [][]mat=new int[n][m];
        int [][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            in=buff.readLine().split(" ");
            for(int j=0;j<m;j++)mat[i][j]=Integer.parseInt(in[j]);
        }
        for(int i=0;i<n;i++)dp[i][0]=mat[i][0];
        for(int j=1;j<m;j++){
            for(int i=0;i<n;i++){
                if(i==0)
                    dp[i][j]=max(dp[i+1][j-1],dp[i][j-1]);
                else if(i==n-1)
                    dp[i][j]=max(dp[i-1][j-1],dp[i][j-1]);
                else dp[i][j]=max(dp[i][j-1],dp[i-1][j-1],dp[i+1][j-1]);
                dp[i][j]+=mat[i][j];
            }
        }
        int res=0;
        for(int i=0;i<n;i++)res=max(res,dp[i][m-1]);
        System.out.println(res);
    }
}
