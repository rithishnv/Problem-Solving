class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        k%=(n*m);
        int[][] temp=new int[n][m];
        int t=0;
        int i=0,j=0;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(t==k)
                break;
                t++;
            }
            if(t==k){
                if(j==m)
                i++;
            break;
            }
        }
        for(int a=0;a<n;a++){ 
            for(int b=0;b<m;b++){
                temp[i%n][j%m]=grid[a][b];
                j++;
                if(j%m==0)
                i++;
            }
        }
        for(int[] y:temp){
            List<Integer> li=new ArrayList<>();
            for(int u:y)
            li.add(u);
            res.add(li);
        }
        return res;
    }
}