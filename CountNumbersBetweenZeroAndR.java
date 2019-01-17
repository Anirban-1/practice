/*
* This is a basic structure for solving Digit DP problems.
* =========================================================..
* Given a number R, find how many numbers are there between 0 and R.
* Here R is converted into array `s` of its digits. This basic structure can be modified to solve other digit DP problems such as
* count numbers in range L and R with some specific properties.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CountNumbersBetweenZeroAndR
{
	static int[][]dp;
	static int[]s;
	static int f(int l,int isGreater){
		if(l==0)return isGreater==1?0:1;
		if(dp[l][isGreater]!=-1)return dp[l][isGreater];
		int sol=0;
		if(isGreater==1){
			for(int i=0;i<=9;i++)
				sol+=f(l-1,i>=s[l-1]?1:0);
		}
		else{
			for(int i=0;i<=9;i++)
				sol+=f(l-1,0);
		}
		return dp[l][isGreater]=sol;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] ss=br.readLine().toCharArray();
		s=new int[ss.length];
		dp=new int[s.length+1][2];
		for(int i=0;i<=s.length;i++)dp[i][0]=dp[i][1]=-1;
		for(int i=0;i<ss.length;i++){
			s[i]=ss[i]-'0';
		}
		System.out.println(f(s.length,1));
	}
}
