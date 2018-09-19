/*
Count of substrings divisible by 4 but not by 3.
Example:
1) str = "124".
Of all the substrings "1","2","4","12","24","124", only "124" & "4" are not divisible by 3 but divisible by 4.
So, output: 2

2) str = "04". output: 1
*/
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CountSubstrings
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int n=str.length();
		int[][]dp=new int[n][3];
		int prefSum[]=new int[n];
		prefSum[0]=str.charAt(0);
		for(int i=1;i<n;i++)prefSum[i]=prefSum[i-1]+(str.charAt(i)-'0');
		int res=0;
		for(int i=n-1;i>=1;i--)
			if(Integer.parseInt(str.substring(i-1,i+1))%4==0){
				int j=i-1;
				while(j>=0){
					if(j>0)dp[i][(prefSum[i]-prefSum[j-1])%3]++;
					else dp[i][prefSum[i]%3]++;
					j--;
				}
			}
		for(int i=0;i<n;i++)res+=dp[i][1]+dp[i][2];
		for(int i=0;i<n;i++)
		{
			if(i>0 && str.charAt(i-1)=='0')continue;
			if(str.charAt(i)!='0' && (str.charAt(i)-'0')%3!=0 && (str.charAt(i)-'0')%4==0)res++;
		}
		System.out.println(res);
	}
}
