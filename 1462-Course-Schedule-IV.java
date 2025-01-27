class Solution {
    public List<Boolean> checkIfPrerequisite(int num, int[][] pre, int[][] queries) {
        boolean[][] reach=new boolean[num][num];
        for(int[] i:pre){
            reach[i[0]][i[1]]=true;
        }
        for(int k=0;k<num;k++){
            for(int i=0;i<num;i++){
                for(int j=0;j<num;j++){
                    reach[i][j]=reach[i][j] ||(reach[i][k] &&reach[k][j]);
                }
            }
        }
        List<Boolean> li=new ArrayList<>();
        for(int[] i:queries){
            li.add(reach[i[0]][i[1]]);
        }
        return li;
    }
}