import java.io.*;
class Test{
	public static void main(String[] args)throws IOException{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		String []in=buff.readLine().split(" ");
		int n=in.length, sum=Integer.parseInt(buff.readLine());
		int[] ar=new int[n];
		boolean[][] dp=new boolean[sum+1][n];
		for(int i=0;i<n;i++)ar[i]=Integer.parseInt(in[i]);	
		for(int i=0;i<n;i++)dp[0][i]=true;
		for(int i=1;i<=sum;i++)dp[i][0]=false;
		for(int i=1;i<=sum;i++){
			for(int j=1;j<n;j++){
				if(i<ar[j])dp[i][j]=dp[i][j-1];
				else dp[i][j]=dp[i-ar[j]][j-1];
			}
		}
		for(int i=0;i<=sum;i++){
			for(int j=0;j<n;j++)System.out.print(dp[i][j]+" ");
			System.out.println();
		}
		boolean res=false;
		for(int i=0;i<n;i++)res=res||dp[sum][i];
		if(res)System.out.println("Yes");
		else System.out.println("No");
	}
}
