class Solution {
    public int sortableIntegers(int[] nums) {
        int len = nums.length;
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i<=len; i++) {
            if(len%i==0){
                arr.add(i);
            } 
        }
        int sum = 0;
        for(int num: arr) {
            int subs = len/num;
            int prevmax = 0;
            int idx = 0;
            boolean consider = true;
            for(int i = 0; i<subs; i++) {
                boolean rotated = false;
                int min = nums[idx];
                int max = nums[idx];
                for(int j = idx; j<idx+num-1; j++) {
                    if(min>nums[j+1]){
                        min = nums[j+1];
                    }
                    if(max<nums[j+1]){
                        max = nums[j+1];
                    }
                    if(nums[j]>nums[j+1]) {
                        if(rotated || nums[idx]<nums[idx+num-1]) {
                            consider = false;
                            break;
                        }
                        rotated = true;
                    }
                }
                if(min<prevmax){
                    consider = false;
                }
                else{
                    prevmax = max;
                }
                if(!consider){
                    break;
                }
                idx+=num;
            }
            if(consider){
                sum+=num;
            }
        }
        return sum;
    }
}
