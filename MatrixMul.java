import java.io.*;
class MatrixMul{
	public static void main(String []args)throws IOException{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		String[]in=buff.readLine().split(" ");
		int n=in.length;
		int[] p=new int[n];
		for(int i=0;i<n;i++)p[i]=Integer.parseInt(in[i]);
		int[][]dp=new int[n][n];
		for(int l=2;l<n;l++){
			for(int i=1;i<=n-l;i++){
				int j=i+l-1;
				int minCost=Integer.MAX_VALUE-1;
				for(int k=i;k<j;k++){
					minCost=Math.min(minCost,p[i-1]*p[k]*p[j]+dp[i][k]+dp[k+1][j]);	
				}
				dp[i][j]=minCost;
			}
		}
		System.out.println(dp[1][n-1]);
	}
}
