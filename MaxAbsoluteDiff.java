/*
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

*/
/*
Approach:
==========
The required complexity is O(n), so let's use the property of abs().
|A[i]-A[j]|+|i-j| can give 4 conditions:

i) (A[i]+i)-(A[j]+j) i.e., when (A[i]-A[j])>=0 & (i-j)>=0
ii) -(A[i]-i)+(A[j]-j) i.e., when (A[i]-A[j])<0 & (i-j)>=0
iii) (A[i]-i)-(A[j]-j) i.e., when (A[i]-A[j])>=0 & (i-j)<0
iv) -(A[i]+i)+(A[j]+j) i.e., when (A[i]-A[j])<0 & (i-j)<0

Therefore we see we need A[i]+i and A[i]-i for all 0<=i<A.length.
Let X be array of A[i]+i and Y be array of A[i]-i. Now we need Xmax, Xmin, Ymax, Ymin.
From these four values and above four conditions we can have the following four conditions:

i) Xmax-Xmin
ii) Xmin-Xmax
iii) Ymax-Ymin
iv) Ymin-Ymax
Our answer is the maximum of the above four conditions.
*/
public class Solution {
    public int maxArr(int[] A) {
        int n=A.length;
        int X[]=new int[n];
        int Y[]=new int[n];
        for(int i=0;i<n;i++){
            X[i]=A[i]+i;
            Y[i]=A[i]-i;
        }
        int Xmax=X[0],Xmin=X[0],Ymax=Y[0],Ymin=Y[0];
        for(int i=1;i<n;i++){
            if(X[i]>Xmax)Xmax=X[i];
            if(X[i]<Xmin)Xmin=X[i];
            if(Y[i]>Ymax)Ymax=Y[i];
            if(Y[i]<Ymin)Ymin=Y[i];
        }
        int res=Math.max(
            Math.max(Xmax-Xmin,-Xmax+Xmin),Math.max(Ymax-Ymin,-Ymax+Ymin)
        );
        return res;
    }
}

