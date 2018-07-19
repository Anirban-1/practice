// https://practice.geeksforgeeks.org/problems/total-decoding-messages/0
import java.util.*;
import java.lang.*;
import java.io.*;

class WaysToDecode
{
	static boolean valid(char x,char y){
		return x=='1'||(x=='2' && y<='6');
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		char[]a=buff.readLine().toCharArray();
		// the string can't start with a 0, otherwise it's invalid string
		boolean check=a[0]!='0';
		int n=a.length;
		int dp[]=new int[n+1];
		// check if the string is valid by looking for two or more consecutive 0s or multiples of 10 greater than 20, eg., 30,40,50, ..
		for(int i=0;i<n-1;i++)
			if((a[i]=='0' || a[i]>'2')&&a[i+1]=='0'){
				check=false;
				break;
			}
		// if valid string calculate how many decodings possible
		// FOLLOWING IS THE RECURRENCE:
		// f(i,a) = {
		// 		0, if i>a.length;
		// 		1, if i==a.length;
		// 		f(i+1,a) + f(i+2,a) if a[i]!='0' and isValidIntegerLessThan27(a[i], a[i+1]);
		//	 	f(i+1,a) otherwise and if a[i]!=0;
		// }
		if(check){
			dp[n]=1;
			for(int i=n-1;i>=0;i--){
				if(a[i]!='0')dp[i]=dp[i+1];
				if(i<n-1 && a[i]!='0'&&valid(a[i],a[i+1]))
					dp[i]+=dp[i+2];
			}
			System.out.println(dp[0]);
		}else System.out.println(0);
	}
}
