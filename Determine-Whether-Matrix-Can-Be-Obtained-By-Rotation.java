1class Solution {
2    public int[][] rotate(int[][] mat){
3        int n=mat.length;
4        int[][] t=new int[n][n];
5        for(int i=0;i<n;i++){
6            int a=n-1;
7            for(int j=0;j<n;j++){
8                t[i][j]=mat[a--][i];
9            }
10        }
11        return t;
12    }
13    public boolean findRotation(int[][] mat, int[][] target) {
14        int n=mat.length;
15        for(int k=0;k<4;k++){
16            int f=0;
17            for(int i=0;i<n;i++){
18                for(int j=0;j<n;j++){
19                    if(mat[i][j]!=target[i][j]){
20                        f=-1;
21                        break;
22                    }
23                }
24                if(f==-1)
25                break;
26            }
27            if(f==0)
28            return true;
29            mat=rotate(mat);
30        }
31        return false;
32    }
33}