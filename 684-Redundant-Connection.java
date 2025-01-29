class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] p=new int[edges.length+1];
        for(int i=0;i<p.length;i++){
            p[i]=i;
        }
        for(int[] i:edges){
            int p1=i[0];
            int p2=i[1];
            while(p1!=p[p1])
            p1=p[p1];
            while(p2!=p[p2])
            p2=p[p2];
            if(p[p1]==p[p2])
            return i;
            p[p2]=p1;
        }
        return null;
    }
}