	class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
        List<int[]> li=new ArrayList<>();
        int n=rows*cols;
        int t=1;
        li.add(new int[]{r,c});
        n--;
        while(n>0){
            for(int i=0;i<t;i++){
                c++;
                if(c>-1&&r>-1&&c<cols&&r<rows){
                li.add(new int[]{r,c});
                n--;
                }
                
            }
             for(int i=0;i<t;i++){
                 r++;
                if(c>-1&&r>-1&&c<cols&&r<rows){
                li.add(new int[]{r,c});
                n--;
                }
               
            }
            t++;
             for(int i=0;i<t;i++){
                 c--;
                if(c>-1&&r>-1&&c<cols&&r<rows){
                li.add(new int[]{r,c});
                n--;
                }
               
            }
             for(int i=0;i<t;i++){
                r--;
               if(c>-1&&r>-1&&c<cols&&r<rows){
                li.add(new int[]{r,c});
                n--;
                }
                
            }
            t++;
        }
        return li.toArray(new int[rows*cols][]);
    }
}