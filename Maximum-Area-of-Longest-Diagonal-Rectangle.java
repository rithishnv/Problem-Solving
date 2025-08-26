class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double dia=0;
        int a=0;
        for(int[] i:dimensions){
            double t=Math.sqrt((i[0]*i[0])+(i[1]*i[1]));
            if(t>dia){
                dia=t;
                a=i[0]*i[1];
            }
            else if(t==dia){
                a=Math.max(i[0]*i[1],a);
            }
        }
        return a;
    }
}