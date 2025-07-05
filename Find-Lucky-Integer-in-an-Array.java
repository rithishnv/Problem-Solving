class Solution {
    public int findLucky(int[] arr) {
        int[] ar=new int[501];
        int max=-1;
        for(int i:arr){
            ++ar[i];
        }
        for(int i:arr){
            if(ar[i]==i){
                max=Math.max(max,i);
            }
        }
        return max;
    }
}