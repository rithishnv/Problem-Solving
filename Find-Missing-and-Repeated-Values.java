class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       int[] fre=new int[grid.length*grid[0].length+1];
       int n=grid.length;
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            fre[grid[i][j]]++;
        }
       }
       int[] res=new int[2];
       for(int i=0;i<fre.length;i++){
        if(fre[i]==0)
        res[1]=i;
        if(fre[i]>1)
        res[0]=i;
       }
       return res;
    }
}