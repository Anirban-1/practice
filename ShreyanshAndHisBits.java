/*
https://practice.geeksforgeeks.org/problems/shreyansh-and-his-bits/0

Shreyansh has an integer N. He is really curious about the binary representation of integers. He sees that any given integer has a number of set bits. Now he wants to find out that how many positive integers, strictly less than N, have the same number of set bits as N.
He is a little weak in maths. Help him find the number of integers.
Note : Since N takes large values, brute force won't work.

Input :
First line of input contains a single integer T denoting the number of test cases.
The only line of each test case contains an integer N.

Output :
For each test case, print the required answer in a new line.

Constraints :
1 <= T <= 1000
1 <= N <= 10^12

Example :
Input :
3
8
1
4

Output :
3
0
2

Explanation :
Case 1 :
Binary representation of 8 : 1000
So the integers less than 8 with same number of set bits are : 4, 2, 1

Case 2 :
Binary representation of 1 : 1
There are no positive integers less than 1.

Case 3 :
Binary representation of 8 : 100
So the integers less than 4 with same number of set bits are : 2, 1

*/
/*
Approach:
=========

Since we have to find the how many integers strictly less than the given integer are there with the same number of set bits,
we are interested in finding how many combinations can be formed with the count of set bits till ith bit (0<=i<=40). That is,
we are interested in choosing nSetBits (till ith position from LSB position) out of i bit positions.

Note: we cannot consider combinations where if ith bit is the set bit, then the combinations where the set bits in lesser than
ith position can be arranged in i places as in that case for some combinations the numbers formed will exceed the given number
*/
import java.io.*;
class MaxAbsoluteDiff{
    public static void main (String[] args) throws java.lang.Exception
	{
		final int N=40;
		long dp[][]=new long[41][41];
		for(int i=0;i<=N;i++)dp[i][0]=1;
		for(int i=1;i<=N;i++)
			for(int j=1;j<=i;j++)dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(buff.readLine());
		while(t-->0){
			final long n=Long.parseLong(buff.readLine());
			int x=0,y=0,k=0,nSetBits=0;
			long res=0;
			for(k=0;k<=40;k++)
			    if(((long)(1L<<k)&n)!=0)nSetBits++;
			while(k>=0){
				if(((long)(1L<<k)&n)!=0)res+=dp[k][nSetBits--];
				k--;
			}
			System.out.println(res);
		}
	}
}
