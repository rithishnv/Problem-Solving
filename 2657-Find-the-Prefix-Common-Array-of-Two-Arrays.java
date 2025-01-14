class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] a=new int[A.length];
        int[] r=new int[A.length+1];
        int c=0;
        for(int i=0;i<A.length;i++){
            if(++r[A[i]]==2)
            c++;
            if(++r[B[i]]==2)
            c++;
            a[i]=c;
        }
        return a;
    }
}