/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

    Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].

Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].

*/
/*
Approach:
Convert the binary string into string of -1s and 1s by replacing 1s to -1s and 0s to 1s and then try to find the maximum contiguous sum. Reason is if we include one index and if it contains a 1 we will loose it so let's assume the score to be -1 and simillarly if we include an index which contains a 0 we gain a 1 so let's assume its score to be 1. So out problem becomes what is the maximum score we can gain by selecting a range in the array.
*/
public class Solution {
    public int[] flip(String A) {
        int[]ar=new int[A.length()];
        int n=ar.length;
        for(int i=0;i<n;i++)ar[i]=A.charAt(i)=='1'?-1:1;
        int l=-2,r=0,max=ar[0];
        for(int i=1;i<n;i++){
            ar[i]=Math.max(ar[i-1]+ar[i],ar[i]);
// we want the lexicographically smallest result do we try to find R from left and try to find the left most or smallest L
            if(ar[i]>max){
                max=ar[i];
                r=i;
            }
        }
        if(max>0){
// try to include lth index if the score is >=0 as we don't want to loose score i.e., we don't want to loose a 1 from the string while flipping
            for(l=r;l>=0&&ar[l]>=0;l--);
            l++;
            return new int[]{l+1,r+1};
        }
        return new int[0];
    }
}
