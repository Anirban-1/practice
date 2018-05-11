import java.io.*;
class RoyNFlowers2{
	public static void main(String[] args)throws IOException {
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(buff.readLine());
		while(t-->0){
			int n,p;
			String []in=buff.readLine().split(" ");
			n=Integer.parseInt(in[0]);		
			p=Integer.parseInt(in[1]);
			int []cp=new int[n];
			int []sp=new int[n];
			for(int i=0;i<n;i++){
				in=buff.readLine().split(" ");
				sp[i]=Integer.parseInt(in[0]);
				cp[i]=Integer.parseInt(in[1]);
			}
			int[][]dp=new int[n+1][p+1];
			for(int i=1;i<=n;i++){
				for(int j=0;j<=p;j++){
					if(cp[i-1]<=j)
					dp[i][j]=Math.max(dp[i-1][j-cp[i-1]]+sp[i-1],dp[i-1][j]);
					else dp[i][j]=dp[i-1][j];
				}
			}
			int amtSpent=0;
			for(int i=0;i<=p;i++){
				if(dp[n][i]-i>dp[n][amtSpent]-amtSpent)
					amtSpent=i;
			}
			int total=dp[n][amtSpent]+p-amtSpent;
			System.out.println(amtSpent+" "+total);
		}
	}
}