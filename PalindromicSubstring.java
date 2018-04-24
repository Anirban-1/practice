/*
	Find the length of the longest substring (NOTE: not sub-sequence) from a given string.
	Example:
	aabaaz -> 5
	aavsba -> 2
	abc -> 1
*/
import java.io.*;
class PalindromicSubstring{
	public static void main(String[] args)throws IOException {
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		char[] s=buff.readLine().toCharArray();
		int n=s.length;
		int [][]dp=new int[n][n];
		for(int l=1;l<=n;l++){
			for(int i=0;i<=n-l;i++){
				int j=i+l-1;
				if(i==j)dp[i][j]=1;
				else if(j==i+1 && s[i]==s[j])dp[i][j]=2;
				else if(j>i+1 && s[i]==s[j] && j-i-1==dp[i+1][j-1])dp[i][j]=2+dp[i+1][j-1];
				else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
			}
		}
		System.out.println(dp[0][n-1]);
	}
}