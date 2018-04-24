// longest substring with non-repeating characters
/* Example
	BBB -> 1 (B)
	eaeast -> 4 (east)	
	geeksforgeeks -> 7 (eksforg, ksforge)
*/
import java.io.*;
import java.util.*;
class LSWNRC{
	public static void main(String[] args)throws IOException{
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		char[] s=buff.readLine().toUpperCase().toCharArray();
		int []v=new int[26];	
		int maxCount=0,currentCount=0;
		Arrays.fill(v,-1);	
		for(int i=0;i<s.length;i++){
			int idx=s[i]-'A';
			// if the current character has not been used or if it is out of the current substring
			if(v[idx]==-1 || i-v[idx]>currentCount){
				currentCount++;
			}
			else{
			// discarding the previous occurence of the current character and calculating the current length
				currentCount=i-v[idx];
			}
			v[idx]=i;
			maxCount=Math.max(maxCount,currentCount);
		}
		System.out.println(maxCount);
	}
}
