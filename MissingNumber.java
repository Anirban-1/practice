// https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
import java.util.*;
import java.lang.*;
import java.io.*;

class MissingNumber {
	public static void main (String[] args) throws IOException{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(buff.readLine());
		while(t-->0){
		    int n=Integer.parseInt(buff.readLine());
		    String[]in=buff.readLine().split(" ");
            int sum=0;
            // The idea is to find the sum of the given elements and subtract that sum from the original sum of elements from 1 to n i.e., n*(n+1)/2 - sumOfGivenElements
		    for(int i=0;i<in.length;i++)sum+=Integer.parseInt(in[i]);
		    System.out.println((n*(n+1)/2)-sum);
		}
	}
}