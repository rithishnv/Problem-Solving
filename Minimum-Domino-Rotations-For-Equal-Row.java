class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
       int[] arr=new int[7];
       int res=Integer.MAX_VALUE;
       int n=tops.length;
       for(int i=0;i<n;i++){
        arr[tops[i]]++;
        if(tops[i]!=bottoms[i])
        arr[bottoms[i]]++;
       }
       for(int i=1;i<=6;i++){
        if(arr[i]<n)
        continue;
        int t=0,b=0;
        for(int j=0;j<n;j++){
            if(tops[j]!=i)
            t++;
            if(bottoms[j]!=i)
            b++;
        }
        res=Math.min(res,Math.min(t,b));
       }
       return res==Integer.MAX_VALUE ? -1:res;
    }
}