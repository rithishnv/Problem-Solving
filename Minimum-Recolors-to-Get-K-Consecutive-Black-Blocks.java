class Solution {
    public int minimumRecolors(String blocks, int k) {
        int max=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='B'){
                max++;
            }
        }
        int t=max;
        for(int i=k;i<blocks.length();i++){
             if(blocks.charAt(i)=='B'){
                t++;
            }
             if(blocks.charAt(i-k)=='B'){
                t--;
            }
            max=Math.max(max,t);
        }
        return k-max;
    }
}