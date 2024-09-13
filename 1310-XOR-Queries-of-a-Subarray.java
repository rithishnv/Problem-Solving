class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] a=new int[arr.length];
        int[] r=new int[queries.length];
        a[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            a[i]=a[i-1]^arr[i];
        }
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==0)
             r[i]=a[queries[i][1]];
            else
            r[i]=a[queries[i][1]]^a[queries[i][0]-1];
        }
        return r;
    }
}