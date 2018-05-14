// http://www.techiedelight.com/find-triplet-maximum-product-array/
#include <iostream>
#include <algorithm>
using namespace std;
int abs(int x){
   return (x<0)?-x:x;
}
int main(){
   int n;
   cin>>n;
   int ar[n];
   for(int i=0;i<n;i++)cin>>ar[i];
   int max_a=ar[0],min_a=ar[0],min_b,max_b,max_c,res;

   // finding the largest and the smallest element
   for(int i=1;i<n;i++)
   {
      max_a=max(max_a,ar[i]);
      min_a=min(min_a,ar[i]);
   }

   // finding the second & third largest elements
   max_b=max_c=min_a;
   for(int i=0;i<n;i++){
      if(ar[i]==max_a)continue;
      if(ar[i]>max_b){
         max_c=max_b;
         max_b=ar[i];
      }
      else if(ar[i]>max_c)max_c=ar[i];
   }

   // finding the second smallest element
   min_b=max_a;
   for(int i=0;i<n;i++){
      if(ar[i]==min_a)continue;
      if(ar[i]<min_b)min_b=ar[i];
   }
   if(max_b*max_c>min_b*min_a)
   {
      res=max_a*max_b*max_c;
      cout<<"{"<<max_a<<","<<max_b<<","<<max_c<<"}"<<endl;
   }
   else
   {
      res=max_a*min_a*min_b;
      cout<<"{"<<min_a<<","<<min_b<<","<<max_a<<"}"<<endl;
   }
   cout<<res<<endl;
}
