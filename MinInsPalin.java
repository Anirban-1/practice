// https://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
import java.io.*;
class MinInsPalin{
	public static void main(String[] args)throws IOException {
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		char[] str=buff.readLine().toCharArray();
		int n=str.length;
		int dp[][]=new int[n][n];
		for(int l=1;l<n;l++){
			for(int i=0;i<n-l;i++){
				int j=i+l;
				dp[i][j]=(str[i]==str[j])?dp[i+1][j-1]:Math.min(dp[i][j-1],dp[i+1][j])+1;
			}
		}
		System.out.println(dp[0][n-1]);
	}
}
