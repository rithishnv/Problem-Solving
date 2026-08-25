class Solution {
    public int missingMultiple(int[] nums, int k) {
        int i=1;
        while(true){
            int t=k*i;
            boolean f=true;
            for(int j:nums){
                if(j==t){
                    f=!f;
                    break;
                }
            }
            if(f)
            return t;
            i++;
        }
    }
}