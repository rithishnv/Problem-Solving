class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> imgA = new ArrayList<>();
        List<int[]> imgB = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1) imgA.add(new int[]{i,j});
                if(img2[i][j]==1) imgB.add(new int[]{i,j});
            }
        }
        int[][] count = new int[n*2][n*2];
        int res=0;
        for(int[] a :imgA){
            for(int[] b : imgB){
                int dx = b[0]-a[0]+n;
                int dy =b[1]-a[1]+n;
                 count[dx][dy]++;
                res = Math.max(res,count[dx][dy]);
            }
        }
        return res;
    }
}