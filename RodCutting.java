import java.io.*;
class RodCutting{
	public static void main(String [] args)throws IOException{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		// taking input
		String[] in=buff.readLine().split(" ");
		int n=in.length;
		int[] cost=new int[n];
		int[] dp=new int[n+1];
		for(int i=0;i<n;i++)cost[i]=Integer.parseInt(in[i]);
		for(int l=1;l<=n;l++){
			for(int p=1;p<=l;p++)
				dp[l]=Math.max(dp[l],cost[p-1]+dp[l-p]);
		}
		System.out.println(dp[n]);
	}
}
