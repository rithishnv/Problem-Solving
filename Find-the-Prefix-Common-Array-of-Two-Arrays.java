1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int[] a=new int[A.length];
4        int[] r=new int[A.length+1];
5        int c=0;
6        for(int i=0;i<A.length;i++){
7            if(++r[A[i]]==2)
8            c++;
9            if(++r[B[i]]==2)
10            c++;
11            a[i]=c;
12        }
13        return a;
14    }
15}