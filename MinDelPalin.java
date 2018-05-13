// https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
import java.io.*;
class MinDelPalin{
	public static void main(String[] args)throws IOException{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		char[] in=buff.readLine().toCharArray();
		int n=in.length;
		int [][]dp=new int[n][n];
		for(int i=0;i<n;i++)for(int j=0;j<i;j++)dp[i][j]=Integer.MAX_VALUE;
		for(int l=1;l<n;l++){
			for(int i=0;i<n-l;i++){
				int j=i+l;
				if(j==i+1)dp[i][j]=(in[i]==in[j])?0:1;
				else dp[i][j]=(in[i]==in[j])?dp[i+1][j-1]:1+Math.min(dp[i+1][j],dp[i][j-1]);
			}
		}
		System.out.println(dp[0][n-1]);
	}
}
