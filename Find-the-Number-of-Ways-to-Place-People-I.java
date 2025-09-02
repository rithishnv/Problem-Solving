class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        int res=0;
        for(int i=0;i<n;i++){
            int x1=points[i][0],y1=points[i][1];
            for(int j=0;j<n;j++){
                if(i==j)
                continue;
                int x2=points[j][0],y2=points[j][1];
                if(x1>x2 || y1<y2)
                continue;
                boolean f=true;
                for(int k=0;k<n;k++){
                    if(k==i || k==j)
                    continue;
                    int x=points[k][0],y=points[k][1];
                    if(x>=x1 && x<=x2 && y<=y1 && y>=y2){
                        f=false;
                        break;
                    }
                }
                if(f)
                res++;
            }
        }
        return res;
    }
}