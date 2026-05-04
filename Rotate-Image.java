1class Solution {
2    public void rotate(int[][] matrix) {
3        List<Integer> li=new ArrayList<>();
4        int k=0;
5        for(int i=0;i<matrix.length;i++){
6            for(int j=matrix.length-1;j>=0;j--){
7                li.add(matrix[j][i]);
8            }
9        }
10        for(int i=0;i<matrix.length;i++){
11            for(int j=0;j<matrix.length;j++){
12                matrix[i][j]=li.get(k++);
13            }
14        }
15    }
16}