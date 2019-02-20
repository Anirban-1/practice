import java.util.*;
import java.lang.*;
import java.io.*;

class FindKthSmallest
{
    static void swap(int []ar,int i, int j){
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }
	static int partition(int[]ar,int lo, int hi){
		int i=lo,j=hi,key=ar[(hi+lo)/2];
		while(true){
            while(i<=j && ar[i]<=key)i++;
            while(ar[j]>key)j--;
            if(i>=j)break;
            swap(ar, i, j);
        }
		return j;
    }
    static int findK(int []ar,int lo, int hi, int k){
        if(lo==hi && k==lo)return ar[k];
        if(k>hi || k<lo)return -1;
        int p=partition(ar, lo, hi);
        if(k<=p)return ar[k];
        return findK(ar, p+1, hi, k);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]in=br.readLine().split(" ");
        int k=Integer.parseInt(br.readLine());
		int n=in.length;
		int[]ar=new int[n];
        for(int i=0;i<n;i++)ar[i]=Integer.parseInt(in[i]);
        System.out.println(findK(ar, 0, n-1, k-1));
	}
}