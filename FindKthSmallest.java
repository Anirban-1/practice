import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.*;

class FindKthSmallest
{
    static void swap(int []ar,int i, int j){
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }
	static int partition(int[]ar,int lo, int hi){
		int key=ar[lo];
        int i=lo+1,j=hi;
		while(true){
            while(i<j&&ar[i]<key)i++;
            while(i<=j && ar[j]>=key)j--;
            if(i>=j)break;
            swap(ar, i, j);
        }
        swap(ar,lo,j);
		return j;
    }
    static void sort(int []ar,int lo, int hi, int k){
        if(lo>=hi)return;
        int x = ThreadLocalRandom.current().nextInt(lo,hi);
        swap(ar,x,lo);
        int p=partition(ar,lo,hi);
        int leftLength = p-lo+1;
        if(k>=leftLength)
            sort(ar,p+1,hi,k-leftLength);
        else sort(ar,lo,p-1,k);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]in=br.readLine().split(" ");
        int k=Integer.parseInt(br.readLine());
		int n=in.length;
		int[]ar=new int[n];
        for(int i=0;i<n;i++)ar[i]=Integer.parseInt(in[i]);
        sort(ar,0,n-1,k);
        System.out.println(ar[k-1]);
	}
}
