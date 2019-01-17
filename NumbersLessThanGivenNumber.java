/*
* [Digit DP]
* Calculate how many numbers less than S but of length |S| can be formed from a given array of digits D.
* Example:
* D=[1 2 3 7 9]
* S=20
* Output: 5, i.e., 11,12,13,17,19 are the ones that can be formed
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class NumbersLessThanGivenNumber
{
	static int[]d,s;
	static int[][]dp;
	static int f(int l,int isSmall,int sum){
		if(dp[l][isSmall]!=-1)return dp[l][isSmall];
		if(l==s.length){
			System.out.println(sum);
			return 1;
		}
		int count=0;
		if(isSmall==1){
      // the first digit of the number to be formed cannot exceed the first digit of S
			if(l==0){
				for(int i=0;i<d.length && d[i]<=s[l];i++)
					count+=f(l+1,d[i]<s[l]?1:0,sum*10+d[i]);
			}
      // if the number formed until l-th position is already small then we can place any digit at l-th place and the number will
      // still be smaller
			else{
				for(int i=0;i<d.length;i++)
					count+=f(l+1,isSmall,sum*10+d[i]);
			}
		}
		else{
      // if the number formed till now is not smaller then we can only place a digit <= the digit at l-th position in S,
      // otherwise the number formed will become greater than S
			for(int i=0;i<d.length&&d[i]<=s[l];i++)
				count+=f(l+1,d[i]<s[l]?1:0,sum*10+d[i]);
		}
		return dp[l][isSmall]=count;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]in=br.readLine().split(" ");
		d=new int[in.length];
		for(int i=0;i<in.length;i++)d[i]=Integer.parseInt(in[i]);
		char[] ss=br.readLine().toCharArray();
		s=new int[ss.length];
		dp=new int[s.length+1][2];
		for(int i=0;i<=s.length;i++)dp[i][0]=dp[i][1]=-1;
		for(int i=0;i<ss.length;i++){
			s[i]=ss[i]-'0';
		}
		System.out.println(f(0,1,0));
	}
}
