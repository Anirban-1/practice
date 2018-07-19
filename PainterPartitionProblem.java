// https://www.geeksforgeeks.org/painters-partition-problem/
import java.util.*;
import java.lang.*;
import java.io.*;

class PainPartitionProblem{

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		String[]in=buff.readLine().split(" ");
		int K=Integer.parseInt(in[0]);
		int n=Integer.parseInt(in[1]);
		in=buff.readLine().split(" ");
		int cost[]=new int[n];
		for(int i=0;i<n;i++)cost[i]=Integer.parseInt(in[i]);
		int [][]dp=new int[K+1][n+1];
		for(int i=1;i<=K;i++)dp[i][1]=cost[0];
		for(int i=1;i<=n;i++){
			int sum=0;
			for(int j=0;j<i;j++)sum+=cost[j];
			dp[1][i]=sum;
		}
		for(int k=2;k<=K;k++){
			for(int j=2;j<=n;j++){
				int minv=Integer.MAX_VALUE-1;
				for(int p=1;p<=j;p++){
					int sum=0, maxv=0;
					for(int i=p;i<=j;i++)sum+=cost[i-1];
					maxv=Math.max(sum,dp[k-1][p-1]);
					minv=Math.min(minv,maxv);
				}
				dp[k][j]=minv;
			}
		}
		System.out.println(dp[K][n]);
	}
}
