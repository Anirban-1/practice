import java.io.*;
class RoyNFlowers{
	public static void main(String[] args)throws IOException {
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		int n,p;
		String []in=buff.readLine().split(" ");
		n=Integer.parseInt(in[0]);		
		p=Integer.parseInt(in[1]);
		int []cp=new int[n+1];
		int []sp=new int[n+1];
		for(int i=1;i<=n;i++){
			in=buff.readLine().split(" ");
			sp[i]=Integer.parseInt(in[0]);
			cp[i]=Integer.parseInt(in[1]);
		}
		int minSpend[][]=new int[n+1][p+1];
		int maxProf[][]=new int[n+1][p+1];
		for(int i=1;i<=n;i++){
			for(int j=0;j<=p;j++){
				if(cp[i]<=j){
					if(maxProf[i-1][j-cp[i]]+sp[i]-cp[i]>maxProf[i-1][j])
					{
						maxProf[i][j]=maxProf[i-1][j-cp[i]]+sp[i]-cp[i];
						minSpend[i][j]=minSpend[i-1][j-cp[i]]+cp[i];
					}
					else if(maxProf[i-1][j-cp[i]]+sp[i]-cp[i]<maxProf[i-1][j]){
						maxProf[i][j]=maxProf[i-1][j];
						minSpend[i][j]=minSpend[i-1][j];
					}
					else{
						maxProf[i][j]=maxProf[i-1][j];
						minSpend[i][j]=(minSpend[i-1][j-cp[i]]+cp[i]<minSpend[i-1][j])?minSpend[i-1][j-cp[i]]+cp[i]:minSpend[i-1][j];
					}
				}
				else{
					maxProf[i][j]=maxProf[i-1][j];
					minSpend[i][j]=minSpend[i-1][j];
				}
			}
		}
		int total=maxProf[n][p]+p;
		System.out.println(minSpend[n][p]+" "+total);
	}
}