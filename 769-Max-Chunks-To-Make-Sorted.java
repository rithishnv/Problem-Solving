class Solution {
    public int maxChunksToSorted(int[] arr) {
        int r=0;
        int max=-1;
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
            if(max==i)
            r++;
        }
        return r;
    }
}