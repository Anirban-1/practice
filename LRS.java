/*
*Longest Repeating Subsequence
*URL: https://www.geeksforgeeks.org/longest-repeated-subsequence/
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class LRS
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		char []ar=buff.readLine().toCharArray();
		int n=ar.length+1;
		int dp[][]=new int[n][n];	
		for(int i=n-2;i>=0;i--){
			for(int j=n-2;j>=i;j--){
				if(ar[i]==ar[j] &&i!=j)dp[i][j]=1+dp[i+1][j+1];
				else dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
			}
		}
		String res="";
		for(int i=0;i<=n-2;i++)
			if(dp[i][i]>dp[i+1][i+1])res+=ar[i];
		System.out.println(res);
	}
}
