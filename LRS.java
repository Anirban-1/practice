/*
*Longest Repeating Subsequence
*URL: https://www.geeksforgeeks.org/longest-repeated-subsequence/
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class LRS
{
	static String f(char[]ar,int i,int j){
		if(i==ar.length || j==ar.length)return "";
		if(ar[i]==ar[j] && i!=j)return ar[i]+f(ar,i+1,j+1);
		else{
			String suffixA=f(ar,i+1,j);
			String suffixB=f(ar,i,j+1);
			if(suffixA.length()>suffixB.length())
				return suffixA;
			return suffixB;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		char []ar=buff.readLine().toCharArray();
		System.out.println(f(ar,0,0));
	}
}
