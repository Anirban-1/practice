// https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
import java.io.*;
class BinStr{
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		final int MAX=100;
		final int MOD=1000000007;
		int[]dp=new int[MAX+1];
		dp[1]=2; // 2 strings with non-consecutive 1s can be formed with 1 bit
		dp[2]=3; // 3 strings with non-consecutive 1s can be formed with 2 bits
		/* we can either put 1 in nth position and hence see for the next n-2 position, or we
   		*  can skip nth position and see for the next n-1 positions. Hence f(n)=f(n-1)+f(n-2).
   		*/
		for(int i=3;i<=MAX;i++)
			dp[i]=(dp[i-1]%MOD+dp[i-2]%MOD)%MOD;
		int n;
		n=Integer.parseInt(br.readLine());
		System.out.println(dp[n]);
	}
}
