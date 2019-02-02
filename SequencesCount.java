// https://www.geeksforgeeks.org/sequences-given-length-every-element-equal-twice-previous/
/*
Recurrence:
f(i,n)={
  0 if i>m,
  m-i+1 if i<=m and n==0 (i.e., all possible values from i to m)
  Sum(f(2*j,n-1)) for i<=j<=m (i.e., if nth value is i then the minimum value of (n-1)th item should be 2*i and onwards upto m)
}
*/
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	static int m;
	static int dp[][];
	static int f(int i,int n){
		if(i>m)return 0;
		if(n==1)return m-i+1;
		if(dp[i][n]!=-1)return dp[i][n];
		int ways=0;
		for(int j=i;j<=m;j++)ways+=f(2*j,n-1);
		return dp[i][n]=ways;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    String[]in=br.readLine().split(" ");
    		m=Integer.parseInt(in[0]);
    		int n=Integer.parseInt(in[1]);
    		dp=new int[m+1][n+1];
    		for(int i=0;i<=m;i++)Arrays.fill(dp[i],-1);
    		System.out.println(f(1,n));
		}
	}
}
