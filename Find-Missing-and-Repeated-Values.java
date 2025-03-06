class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res=new int[2];
        Set<Integer> set=new HashSet<>();
        int n=grid.length;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(set.add(grid[i][j])){
                    sum+=grid[i][j];
                }
                else
                res[0]=grid[i][j];
            }
        }
        n*=n;
        n=(n)*(n+1)/2;
        n-=sum;
        res[1]=n;
        return res;
    }
}